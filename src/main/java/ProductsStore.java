import java.util.HashMap;

public class ProductsStore extends Shopp implements Logger {
    public ProductsStore(String nameShop, HashMap<String, String[]> stock) {
        super(nameShop, stock);
    }

    @Override
    public String welcomeShopp() {
        return super.welcomeShopp() + "продуктовый магазин!";
    }
}
