package DatabaseApp.models;

/**
 * TODO comments
 */
public class PackDelivery {

    private String index;

    private int amount;

    private Supply supply;

    private Stock stock;

    /**
     * Creates new PackDelivery object using supply and stock
     * @param supply Supply
     * @param stock Stock
     */
    public PackDelivery(Supply supply, Stock stock) {
        this.index = createID(supply, stock);
        this.amount = 0;
        this.supply = supply;
        this.stock = stock;
    }

    /**
     * Creates new PackDelivery object using amount, supply and stock
     * @param amount int
     * @param supply Supply
     * @param stock Stock
     */
    public PackDelivery(int amount, Supply supply, Stock stock) {
        this.index = createID(supply, stock);
        this.amount = amount;
        this.supply = supply;
        this.stock = stock;
    }

    /**
     * Creates index using delivery's index and stock's index
     * Add "/" between those indices
     * @param supply Supply: index will be used in second part of PackDelivery's index
     * @param stock Stock: index will be used in first part of PackDelivery's index
     * @return String: New PackDelivery's index
     */
    private String createID(Supply supply, Stock stock) {
        return stock.toString() + "/" + supply.toString();
    }

    /**
     * Overridden function that return PackDelivery's index.
     * @return String: PackDelivery's index
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

    public void setSupply(Supply supply) {
        this.supply = supply;
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

    public Supply getSupply() {
        return supply;
    }

    public Stock getStock() {
        return stock;
    }
}
