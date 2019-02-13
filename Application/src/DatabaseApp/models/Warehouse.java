package DatabaseApp.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * TODO Comments
 */
public class Warehouse {

    private int index;

    private String address;

    private ArrayList<Worker> workers;

    /**
     * Creates Warehouse object. Sets index and address
     * @param index warehouse's id
     * @param address warehouse's address
     */
    public Warehouse(int index, String address) {
        this.index = index;
        this.address = address;
        this.workers = new ArrayList<>();
    }

    /**
     * Creates Warehouse object. Sets index, address and workers
     * @param index warehouse's id
     * @param address warehouse's address
     * @param workers list of workers in warehouse
     */
    public Warehouse(int index, String address, ArrayList<Worker> workers) {
        this.index = index;
        this.address = address;
        this.workers = workers;
    }

    /**
     * Overridden function that return Warehouse's index and address with "@" between them.
     * @return String: index + "@" + address
     */
    @Override public String toString() {
        return this.index + "@" + this.address;
    }



    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndex(String index) {
        this.index = Integer.parseInt(index);
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public int getIndex() {
        return this.index;
    }

    public String getIndexString() {
        return String.valueOf(index);
    }

    public String getAddress() {
        return address;
    }



    public SimpleStringProperty getIndexProperty() {
        return new SimpleStringProperty(String.valueOf(index));
    }

    public SimpleStringProperty getAddressProperty() {
        return new SimpleStringProperty(address);
    }



    public ObservableList<Worker> getWorkersObservable() {
        ObservableList<Worker> temp = FXCollections.observableArrayList();
        temp.addAll(this.workers);
        return temp;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public void deleteWorker(Worker worker) {
        this.workers.remove(worker);
    }

    public void deleteWorker(int idWorker) {
        this.workers.remove(idWorker);
    }
}
