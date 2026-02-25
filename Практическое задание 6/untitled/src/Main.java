import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задачу:");
        System.out.println("1 - Биржа (Observer)");
        System.out.println("2 - Расчет поездки (Strategy)");

        int taskChoice = scanner.nextInt();

        switch (taskChoice) {
            case 1:
                runObserverTask();
                break;
            case 2:
                runStrategyTask(scanner);
                break;
            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }

   
    private static void runObserverTask() {

        StockExchange exchange = new StockExchange();

        exchange.addStock("AAPL", 150);
        exchange.addStock("GOOG", 2800);

        Trader trader1 = new Trader("Иван", 160);
        TradingRobot robot1 = new TradingRobot("RoboX", 140, 3000);

        exchange.subscribe("AAPL", trader1);
        exchange.subscribe("AAPL", robot1);

        exchange.setStockPrice("AAPL", 165);
        exchange.setStockPrice("AAPL", 135);

        exchange.generateReport();
        exchange.shutdown();
    }


    private static void runStrategyTask(Scanner scanner) {

        TravelBookingContext context = new TravelBookingContext();

        try {
            System.out.println("Выберите транспорт: 1 - Самолет, 2 - Поезд, 3 - Автобус");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    context.setStrategy(new AirplaneCostStrategy());
                    break;
                case 2:
                    context.setStrategy(new TrainCostStrategy());
                    break;
                case 3:
                    context.setStrategy(new BusCostStrategy());
                    break;
                default:
                    throw new IllegalArgumentException("Неверный выбор транспорта");
            }

            System.out.print("Введите расстояние (км): ");
            double distance = scanner.nextDouble();

            System.out.print("Введите количество пассажиров: ");
            int passengers = scanner.nextInt();

            System.out.print("Класс обслуживания (economy/business): ");
            String serviceClass = scanner.next();

            System.out.print("Есть багаж? (true/false): ");
            boolean luggage = scanner.nextBoolean();

            System.out.print("Это ребенок? (true/false): ");
            boolean child = scanner.nextBoolean();

            System.out.print("Это пенсионер? (true/false): ");
            boolean pensioner = scanner.nextBoolean();

            TravelRequest request = new TravelRequest(
                    distance,
                    passengers,
                    serviceClass,
                    luggage,
                    child,
                    pensioner
            );

            double totalCost = context.calculate(request);

            if (child) {
                totalCost *= 0.5;
            } else if (pensioner) {
                totalCost *= 0.8;
            }

            System.out.println("Итоговая стоимость поездки: " + totalCost);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}