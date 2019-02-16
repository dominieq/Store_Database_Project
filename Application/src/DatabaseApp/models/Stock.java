package DatabaseApp.models;

/**
 * TODO comments
 */
public class Stock {

    private String index;

    private int amount;

    private Merchandise merchandise;

    private Warehouse warehouse;

    /**
     * Creates new Stock object using merchandise and warehouse
     * @param merchandise Merchandise
     * @param warehouse Warehouse
     */
    public Stock(Merchandise merchandise, Warehouse warehouse) {
        this.index = createID(merchandise, warehouse);
        this.amount = 0;
        this.merchandise = merchandise;
        this.warehouse =  warehouse;
    }

    /**
     * Creates new Stock object using amount, merchandise and warehouse
     * @param amount int
     * @param merchandise Merchandise
     * @param warehouse Warehouse
     */
    public Stock(int amount, Merchandise merchandise, Warehouse warehouse)  {
        this.index = createID(merchandise, warehouse);
        this.amount = amount;
        this.merchandise = merchandise;
        this.warehouse = warehouse;
    }

    /**
     * Creates index from merchandise's index and warehouse's index.
     * Adds "#" at the beginning and "-" between those indices.
     * @param merchandise Merchandise: Index will be used in first part of Stock's index
     * @param warehouse Warehouse: Index will be used in second part of Stock's index
     * @return String: New Stock's index
     */
    private String createID(Merchandise merchandise, Warehouse warehouse) {
        return "#" + merchandise.getName() + "-" + warehouse.getIndexString();
    }

    /**
     * Overridden function that return Stock's index.
     * @return String: Stock's index
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

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }



    public String getIndex() {
        return index;
    }

    public int getAmount() {
        return amount;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
