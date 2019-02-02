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

    private int idWarehouse;

    private String addressWarehouse;

    private ArrayList<Worker> workerArrayList;

    /**
     * Creates Warehouse object. Sets idWarehouse and addressWarehouse
     * @param idWarehouse warehouse's id
     * @param addressWarehouse warehouse's address
     */
    public Warehouse(int idWarehouse, String addressWarehouse) {
        this.idWarehouse = idWarehouse;
        this.addressWarehouse = addressWarehouse;
    }

    /**
     * Creates Warehouse object. Sets idWarehouse, addressWarehouse and workerArrayList
     * @param idWarehouse warehouse's id
     * @param addressWarehouse warehouse's address
     * @param workerArrayList list of workers in warehouse
     */
    public Warehouse(int idWarehouse, String addressWarehouse, ArrayList<Worker> workerArrayList) {
        this.idWarehouse = idWarehouse;
        this.addressWarehouse = addressWarehouse;
        this.workerArrayList = workerArrayList;
    }

    /**
     * Returns warehouse's id as SimpleIntegerProperty
     * @return SimpleIntegerProperty
     */
    public SimpleIntegerProperty getIdWarehouseProperty() {
        return new SimpleIntegerProperty(idWarehouse);
    }

    /**
     * Sets warehouse's id
     * @param idWarehouse int
     */
    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    /**
     * Returns warehouse's address as SimpleStringProperty
     * @return SimpleStringProperty
     */
    public SimpleStringProperty getAddressWarehouse() {
        return new SimpleStringProperty(addressWarehouse);
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
