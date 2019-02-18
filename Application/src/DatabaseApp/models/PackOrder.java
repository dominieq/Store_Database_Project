package DatabaseApp.models;

/**
 * TODO comments
 */
public class PackOrder {

    private String index;

    private int amount;

    private Order order;

    private Stock stock;

    /**
     * Creates new PackOrder object using order and stock
     * @param order Order
     * @param stock Stock
     */
    public PackOrder(Order order, Stock stock) {
        this.amount = 0;
        this.order = order;
        this.stock = stock;
        createID();
    }

    /**
     * Creates new PackOrder object using amount, order and stock
     * @param amount int
     * @param order Order
     * @param stock Stock
     */
    public PackOrder(int amount, Order order, Stock stock) {
        this.amount = amount;
        this.order = order;
        this.stock = stock;
        createID();
    }

    /**
     * Creates index using order's index and stock's index
     * Add "/" between those indices
     */
    public void createID() {
        if(this.order != null && this.stock != null) {
            this.index = this.stock.toString() + "/" + this.order.toString();
        }
        else {
            this.index = "";
        }
    }

    /**
     * Overridden function that return PackOrder's index.
     * @return String: PackOrder's index
     */
    @Override public String toString() {
        return this.index;
    }



    public void setIndex(String index) {
        this.index = index;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAmount(String amount) {
        this.amount = Integer.parseInt(amount);
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }



    public String getIndex() {
        return index;
    }

    public int getAmount() {
        return amount;
    }

    public String getAmountString() {
        return String.valueOf(this.amount);
    }

    public Order getOrder() {
        return order;
    }

    public Stock getStock() {
        return stock;
    }
}
