import java.util.HashMap;

public abstract class Shopp implements Logger {
    private String nameShop;
    private HashMap<String, String[]> stock;

    public Shopp(String nameShop, HashMap<String, String[]> stock) {
        this.nameShop = nameShop;
        this.stock = stock;
    }

    public String getNameShop() {
        return nameShop;
    }

    public HashMap<String, String[]> getStock() {
        return stock;
    }

    @Override
    public String welcomeShopp() {
        return "Добро пожаловать в ";
    }
}
