import java.util.HashMap;
import java.util.Random;

public class Booking {
    private final int orderNum;
    private final String[] delivery = new String[]{"самовывоз", "доставка"};
    private int orderCost;

    private final int trackNumDelivery;
    private Buyer buyer;

    private Random random = new Random();

    public String[] getDelivery() {
        return delivery;
    }

    public Booking(Buyer buyer) {
        this.buyer = buyer;
        this.orderNum = random.nextInt(164);
        this.trackNumDelivery = random.nextInt(164);
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public int getTrackNumDelivery() {
        return trackNumDelivery;
    }

}
