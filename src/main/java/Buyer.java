import java.util.HashMap;

public class Buyer {
    private String name;
    private int resPrice;

    private HashMap<String, Integer> basket = new HashMap<>();

    public Buyer(String name) {
        this.name = name;
    }

    public void addProduct(String nameProduct, int amount, int priceProduct) {
        basket.put(nameProduct, amount);
        this.resPrice = priceProduct * amount;
    }

    public HashMap<String, Integer> getBasket() {
        return basket;
    }


    public Booking checkout() {
        if (basket.isEmpty()) {
            System.out.println("Ваша корзина пуста. Заказ не оформлен");
            return null;
        }
        System.out.println("Заказ успешно оформлен. ");
        return new Booking(this);
    }
}
