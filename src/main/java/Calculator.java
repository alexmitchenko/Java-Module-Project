import java.util.ArrayList;

public class Calculator {

    public static int peopleCount;
    private static final ArrayList<Good> basket = new ArrayList<>();

    public static void addNewGood(Good good) {
        basket.add(good);
        System.out.printf("Добавлен новый товар [" + good.goodLabel + "] стоимостью [%.2f] "
                + setRoubleCase(good.goodPrice) + "\n", good.goodPrice);
    }

    public static void printCheck() {
        printGoods();
        double totalPrice = getTotalPrice();
        System.out.printf("Общая сумма: %.2f %s%n", totalPrice, setRoubleCase(totalPrice));
        System.out.printf("Количество человек: %s%n", peopleCount);
        System.out.printf("Каждый должен заплатить: %.2f %s%n", getShareRatio(totalPrice, peopleCount), setRoubleCase(totalPrice));
    }

    public static void printGoods() {
        System.out.print("Добавленные товары:\n");
        for (int i = 0; i < basket.size(); i++) {
            System.out.printf("Товар [" + basket.get(i).goodLabel + "] стоимостью [%.2f] "
                    + setRoubleCase(basket.get(i).goodPrice) + "\n", basket.get(i).goodPrice);
        }
    }

    public static double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < basket.size(); i++) {
            totalPrice = totalPrice + basket.get(i).goodPrice;
        }
        return totalPrice;
    }

    public static double getShareRatio(double totalPrice, int totalShare) {
        return totalPrice / totalShare;
    }

    private static String setRoubleCase(double d) {
        int n1 = (int) d % 100;
        int n2 = (n1 % 10);
        if (n1 > 10 && n1 < 20) {
            return "рублей";
        } else
        if (n2 > 1 && n2 < 5) {
            return "рубля";
        } else
        if (n2 == 1) {
            return "рубль";
        } else
            return "рублей";
    }

}