import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Добро пожаловать в систему совместных закупок!\n");
        getPeopleCount();
        getGoods();
        Calculator.printCheck();
    }

    static void getPeopleCount() {
        int peopleCount;

        System.out.print("Сколько человек будет приобретать товары?\n");

        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= 2) {
                    peopleCount = input;
                    break;
                }
                else {
                    System.out.print("Ошибка: неверный ввод!\n");
                }
            }
            else {
                System.out.print("Ошибка: неверный ввод!\n");
                scanner.next();
            }
        }
        Calculator.peopleCount = peopleCount;
    }

    static void getGoods() {

        String goodLabel;
        double goodPrice;

        System.out.print("Введите название товара:\n");
        goodLabel = scanner.next();

        while (true) {

            System.out.print("Введите стоимость товара [" + goodLabel + "] в формате: \"руб.коп\", например [10.45, 11.40]:\n");

            while (true) {

                if (scanner.hasNextDouble()) {
                    double input = scanner.nextDouble();
                    if (isRightFormat(input)) {
                        goodPrice = input;
                        break;
                    } else {
                        System.out.print("Ошибка: неверный ввод!\n");
                    }
                } else {
                    System.out.print("Ошибка: неверный ввод!\n");
                    scanner.next();
                }
            }

            Calculator.addNewGood(new Good(goodLabel, goodPrice));

            System.out.print("Введите название товара, или введите \"Завершить\", чтобы закончить:\n");
            String input = scanner.next();

            if (input.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                goodLabel = input;
            }

        }
    }

    static boolean isRightFormat (Double d) {
        String[] splitter = String.valueOf(d).split("[.]");
        int l = splitter[1].length();
        return (d > 0) && (l <= 2);
    }
}