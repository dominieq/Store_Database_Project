package DatabaseApp.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * TODO Comments
 */
public class Warehouse {

    private String idWarehouse;

    private String addressWarehouse;

    private ArrayList<Worker> workerArrayList;

    /**
     * Creates Warehouse object. Sets idWarehouse and addressWarehouse
     * @param idWarehouse warehouse's id
     * @param addressWarehouse warehouse's address
     */
    public Warehouse(String idWarehouse, String addressWarehouse) {
        this.idWarehouse = idWarehouse;
        this.addressWarehouse = addressWarehouse;
        workerArrayList = new ArrayList<>();
    }

    /**
     * Creates Warehouse object. Sets idWarehouse, addressWarehouse and workerArrayList
     * @param idWarehouse warehouse's id
     * @param addressWarehouse warehouse's address
     * @param workerArrayList list of workers in warehouse
     */
    public Warehouse(String idWarehouse, String addressWarehouse, ArrayList<Worker> workerArrayList) {
        this.idWarehouse = idWarehouse;
        this.addressWarehouse = addressWarehouse;
        this.workerArrayList = workerArrayList;
    }

    /**
     * Returns warehouse's id as SimpleIntegerProperty
     * @return SimpleIntegerProperty
     */
    public SimpleStringProperty getIdWarehouseProperty() {
        return new SimpleStringProperty(idWarehouse);
    }

    /**
     * Sets warehouse's id
     * @param idWarehouse int
     */
    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    /**
     * Returns warehouse's address as SimpleStringProperty
     * @return SimpleStringProperty
     */
    public SimpleStringProperty getAddressWarehouseProperty() {
        return new SimpleStringProperty(addressWarehouse);
    }

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public String getAddressWarehouse() {
        return addressWarehouse;
    }

    /**
     * Sets warehouse's address
     * @param addressWarehouse String
     */
    public void setAddressWarehouse(String addressWarehouse) {
        this.addressWarehouse = addressWarehouse;
    }

    /**
     * Returns warehouse's workerArrayList as ObservableList
     * @return ObservableList
     */
    public ObservableList<Worker> getWorkerArrayList() {
        ObservableList<Worker> temp = FXCollections.observableArrayList();
        temp.addAll(this.workerArrayList);
        return temp;
    }

    /**
     * Sets warehouse's workerArrayList
     * @param workerArrayList ArrayList
     */
    public void setWorkerArrayList(ArrayList<Worker> workerArrayList) {
        this.workerArrayList = workerArrayList;
    }

    /**
     * Adds worker to workerArrayList
     * @param worker Worker
     */
    public void addWorker(Worker worker) {
        this.workerArrayList.add(worker);
    }

    /**
     * Deletes worker from workerArrayList
     * @param worker Worker
     */
    public void deleteWorker(Worker worker) {
        this.workerArrayList.remove(worker);
    }

    /**
     * Deletes worker from workerArrayList
     * @param idWorker int
     */
    public void deleteWorker(int idWorker) {
        this.workerArrayList.remove(idWorker);
    }
}
