import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Buyer buyer = new Buyer("Alex");
        HashMap<String, String[]> stockProductsStore = createStock(
                new String[]{"Яблоки", "Персики", "Абрикосы", "Картофель", "Капуста"},
                new String[]{"100", "200", "250", "70", "50"},
                new String[]{"Россия", "Абхазия", "Турция", "Россия", "Россия"});

        HashMap<String, String[]> stockElectronicsStore = createStock(
                new String[]{"Транзисторы", "Резисторы", "Микроконтроллеры", "Одноплатные компьютеры", "Микропроцессоры"},
                new String[]{"30", "4", "1100", "7000", "550"},
                new String[]{"Россия", "Абхазия", "Турция", "Россия", "Тайвань"});

        Shopp shopp = null;

        System.out.println("Какой магазин желаете посетить:\n 1.Электроники\n 2.Продуктовый");

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int input;
        input = scanner.nextInt();
        switch (input) {
            /****************************** Dependency inversion principle *****************************/
            case 1 -> shopp = new ElectronicsStore("Электрон", stockElectronicsStore);
            case 2 -> shopp = new ProductsStore("Магнит", stockProductsStore);
        }

        assert shopp != null;
        System.out.println(shopp.welcomeShopp());

        while (input != -1) {
            System.out.println("1.Посмотреть ассортимент\n" + "2.Уйти с магазина");

            input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    List<String> stream = shopp.getStock().entrySet().stream()
                            .map(entry -> entry.getKey() + "-" + Arrays.toString(entry.getValue()))
                            .collect(Collectors.toList());

                    for (int i = 0; i < stream.size(); i++) {
                        System.out.println(stream.get(i));
                    }

                    System.out.println("Для добавления товара в корзину введите его название и количество в следующем формате: название - кол-во");
                    System.out.println("Если все необходимые товары добавлены в корзину, введите:\n" + " 1.Для перехода к оформлению заказа\n 2.Продолжить покупки");

                    while (!scanner2.hasNext("2")) {
                        String inputStr = scanner2.nextLine();

                        if (inputStr.equals("1")) {
                            Booking booking = new Booking(buyer);

                            if (buyer.checkout() != null) {
                                System.out.println("Укажите способ доставки:\n" + "1." + booking.getDelivery()[0] + "\n" + "2." + booking.getDelivery()[1]);

                                input = scanner.nextInt();
                                if (input == 1) {
                                    System.out.println("Номер вашего заказа:" + booking.getOrderNum());
                                    input = -1;
                                    break;
                                } else if (input == 2) {
                                    System.out.println("Номер для отслеживания вашего заказа:" + booking.getTrackNumDelivery());
                                    input = -1;
                                    break;
                                }
                            }
                            break;
                        } else {
                            String[] product = inputStr.split("-");
                            for (String key : shopp.getStock().keySet()) {
                                if (product[0].equals(key)) {
                                    String priceProduct = shopp.getStock().get(key)[0];
                                    buyer.addProduct(product[0], Integer.parseInt(product[1]), Integer.parseInt(priceProduct));
                                }
                            }
                            System.out.println("Ваша корзина: " + buyer.getBasket());
                        }
                    }
                }
                case 2 -> {
                    System.out.println("До скорых встреч! Приходите еще");
                    input = -1;
                }
            }
        }
    }

    public static HashMap<String, String[]> createStock(String[] merchandise, String[] price, String[] manufacturer) {
        /****************************** Магические числа, DRY *****************************/
        HashMap<String, String[]> stock = new HashMap<>();
        for (int i = 0; i < merchandise.length; i++) {
            stock.put(merchandise[i], new String[]{price[i], manufacturer[i]});
        }
        return stock;
    }

}