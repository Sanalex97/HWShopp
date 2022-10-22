import java.util.HashMap;

public class ElectronicsStore extends Shopp implements Logger {

    public ElectronicsStore(String nameShop, HashMap<String, String[]> stock) {
        super(nameShop, stock);
    }

    @Override
    public String welcomeShopp() {
        return super.welcomeShopp() + "магазин электроники!";
    }
}
