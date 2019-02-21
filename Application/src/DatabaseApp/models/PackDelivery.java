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
        this.amount = 0;
        this.supply = supply;
        this.stock = stock;
        createID();
    }

    /**
     * Creates new PackDelivery object using amount, supply and stock
     * @param amount int
     * @param supply Supply
     * @param stock Stock
     */
    public PackDelivery(int amount, Supply supply, Stock stock) {
        this.amount = amount;
        this.supply = supply;
        this.stock = stock;
        createID();
    }

    /**
     * Creates index using delivery's index and stock's index
     * Add "/" between those indices
     */
    public void createID() {
        if(this.supply != null && this.stock != null) {
            this.index = "SUPPLY: " + this.supply.toString() + "\n" + this.stock.toString();
        }
        else {
            this.index = "";
        }
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

    public void setAmount(String amount) {
        this.amount = Integer.parseInt(amount);
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

    public String getAmountString() {
        return String.valueOf(this.amount);
    }

    public Supply getSupply() {
        return supply;
    }

    public Stock getStock() {
        return stock;
    }
}
