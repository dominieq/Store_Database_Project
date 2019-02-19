package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import DatabaseApp.models.Warehouse;
import DatabaseApp.models.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class WarehouseLogisticsController {

    private DatabaseApp app;
    @FXML private TableView<Warehouse> warehouseTableView;
    @FXML private TableColumn<Warehouse, String> warehouseIdTableColumn;
    @FXML private TableColumn<Warehouse, String> warehouseAddressTableColumn;
    @FXML private ChoiceBox<String> warehouseTraitChoiceBox;
    @FXML private TextField warehouseTraitTextField;

    @FXML private ChoiceBox<Worker> workerChoiceBox;
    @FXML private Label workerIdLabel;
    @FXML private Label workerNameLabel;
    @FXML private Label workerSurnameLabel;
    @FXML private Label workerAddressLabel;
    @FXML private Label workerTelNumLabel;
    @FXML private Label workerMailLabel;
    @FXML private Label workerPESELLabel;
    @FXML private ChoiceBox<String> workerTraitChoiceBox;
    @FXML private TextField workerTraitTextField;

    @FXML private Label informationLabel;

    public WarehouseLogisticsController() {}

    @FXML private void initialize() {
        this.warehouseIdTableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getIndexProperty()
        );

        this.warehouseAddressTableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAddressProperty()
        );

        this.warehouseTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    if(newValue != null) {
                        this.workerChoiceBox.setItems(newValue.getWorkersObservable());
                        this.informationLabel.setText("Workers from: " + newValue.toString() +
                                ".\n Double click on warehouse to cancel selection.");
                    }
                })
        );

        this.warehouseTableView.setRowFactory( doubleClick -> {
            TableRow<Warehouse> row = new TableRow<>();
            row.setOnMouseClicked( event -> {
                if(event.getClickCount() == 2 && (!row.isEmpty())) {
                    this.workerChoiceBox.setItems(this.app.getWorkers());
                    this.warehouseTableView.getSelectionModel().clearSelection();
                    this.informationLabel.setText("You are currently viewing all workers. " +
                            "Select warehouse to view it's workers");
                    this.workerChoiceBox.getSelectionModel().selectFirst();
                }
            });
            return row;
        });

        this.workerChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showWorker(newValue))
        );

    }

    /**
     * Creates dummy warehouse then opens window to edit it's features.
     * When dialog succeeds new warehouse will be added to warehouses and database.
     * Function refreshes all fxml elements.
     */
    @FXML private void handleAddWarehouse() {
        Warehouse warehouse = new Warehouse(100, "[address]");
        if(this.app.showWarehouseDialog("Add warehouse", warehouse)) {
            System.out.println("Warehouse: " + warehouse.toString() + " added");
            this.app.getWarehouses().add(warehouse);

            // TODO SQL query INSERT INTO
            this.app.sqldmlinsert("INSERT INTO warehouse (ADDRESS) VALUES('" + warehouse.getAddress() + "')");

            refreshWarehouse(warehouse);
        }
    }

    /**
     * Gets selected warehouse and deletes it from warehouses and database.
     * When no warehouse was selected displays error.
     * Function refreshes all fxml elements.
     */
    @FXML private void handleDelWarehouse() {
        Warehouse warehouse = this.warehouseTableView.getSelectionModel().getSelectedItem();
        if(warehouse != null) {
            ArrayList<Worker> toRemove = new ArrayList<>();
            for(Worker worker : this.app.getWorkers()) {
                if(worker.getWarehouseIndex() == warehouse.getIndex()) {
                    toRemove.add(worker);
                }
            }
            System.out.println("Warehouse " + warehouse.toString() + " removed");
            this.app.getWorkers().removeAll(toRemove);
            this.app.getWarehouses().remove(warehouse);

            // TODO SQL query DELETE FROM
            this.app.sqldmldelete("DELETE FROM warehouse WHERE ID = " + warehouse.getIndex());

            this.warehouseTableView.refresh();
            this.warehouseTableView.getSelectionModel().selectFirst();
            this.workerChoiceBox.setItems(
                    this.warehouseTableView.getSelectionModel().getSelectedItem().getWorkersObservable());
        } else {
            this.app.showWarning("No selection", "You have to select warehouse to delete it.");
        }

    }

    /**
     * Gets selected warehouse then opens window to edit it's features.
     * When dialog succeeds function refreshes all fxml elements.
     */
    @FXML private void handleEditWarehouse() {
        Warehouse warehouse = this.warehouseTableView.getSelectionModel().getSelectedItem();
        if(warehouse != null) {
            if(this.app.showWarehouseDialog("Edit warehouse", warehouse)) {
                System.out.println("Warehouse: " + warehouse.toString() + " edited");

                // TODO SQL query UPDATE
                this.app.sqldmlupdate("UPDATE warehouse SET ADDRESS = '" + warehouse.getAddress() + "' WHERE ID = " + warehouse.getIndex());

                refreshWarehouse(warehouse);
            }
        } else {
            this.app.showWarning("No selection", "You have to select warehouse to edit it.");
        }
    }

    /**
     * Search for Warehouse using SQL query.
     * When a warehouse is found, function refreshes all fxml elements.
     */
    @FXML private void handleSearchWarehouse() {
        String trait = this.warehouseTraitChoiceBox.getValue();
        String wantedTrait = this.warehouseTraitTextField.getText();

        // TODO use SQL query to search for warehouse
        // SELECT index FROM warehouses
        // WHERE [trait] = [wantedTrait]
        this.app.sqlselect("SELECT * FROM warehouse WHERE LOWER(" + trait + ") like lower('%" + wantedTrait + "%')");

    }

    /**
     * Creates dummy worker then opens window to edit it's features.
     * When dialog succeeds new worker will be added to workers and database.
     * Function refreshes all fxml elements.
     */
    @FXML private void handleAddWorker() {
        Worker worker = new Worker(100, "[name]", "[surname]", "[address]",
                "[telephone number]", "[email address]", "00000000000",
                this.app.getWarehouses().get(0).getIndex());
        if(this.app.showWorkerEditDialog("Add Worker", worker)){
            for(Warehouse warehouse : this.app.getWarehouses()) {
                if(warehouse.getIndex() == worker.getWarehouseIndex()) {
                    System.out.println("Worker: " + worker.toString() + " added");
                    warehouse.addWorker(worker);
                    this.app.getWorkers().add(worker);
                }
            }

            // TODO SQL query INSERT INTO
            this.app.sqldmlinsert("INSERT INTO worker (NAME, SURNAME, ADDRESS, TELNUM, MAIL, PESEL, WAREHOUSE) VALUES('" +
                    worker.getName() + "', '" + worker.getSurname() + "', '" + worker.getAddress() + "', '" + worker.getTelNum() + "', '" + worker.getMail() + "', '" + worker.getPESEL() + "', " + worker.getWarehouseIndex() + ")");

            refreshWorker(worker);
        }
    }

    /**
     * Gets selected workers and deletes it from workers and database.
     * When no worker was selected displays error.
     * Function refreshes all fxml elements.
     */
    @FXML private void handleDelWorker() {
        Worker worker = this.workerChoiceBox.getSelectionModel().getSelectedItem();
        if(worker != null) {
            for (Warehouse warehouse : this.app.getWarehouses()) {
                if(worker.getWarehouseIndex() == warehouse.getIndex()) {
                    System.out.println("Worker: " + worker.toString() + " removed");
                    warehouse.deleteWorker(worker);
                    this.app.getWorkers().remove(worker);

                    // TODO SQL query DELETE FROM
                    this.app.sqldmldelete("DELETE FROM worker WHERE ID = " + worker.getIndex());

                }
            }
            showWorker(null);
            this.warehouseTableView.refresh();
            this.workerChoiceBox.getSelectionModel().clearSelection();
            this.workerChoiceBox.setItems(
                    this.warehouseTableView.getSelectionModel().getSelectedItem().getWorkersObservable());
            this.workerChoiceBox.getSelectionModel().selectFirst();

        }
        else {
            this.app.showWarning("No selection", "You have to select worker to delete it.");
        }
    }

    /**
     * Gets selected worker then opens window to edit it's features.
     * When dialog succeeds function refreshes all fxml elements.
     */
    @FXML private void handleEditWorker() {
        Worker worker = this.workerChoiceBox.getSelectionModel().getSelectedItem();
        if(worker != null) {
            if(this.app.showWorkerEditDialog("Edit worker", worker)) {
                System.out.println("Worker: " + worker.toString() + " edited");

                // TODO use SQL query UPDATE
                this.app.sqldmlupdate("UPDATE worker SET NAME = '" + worker.getName() +
                        "', SURNAME = '" + worker.getSurname() +
                        "', ADDRESS = '" + worker.getAddress() +
                        "', TELNUM = '" + worker.getTelNum() +
                        "', MAIL = '" + worker.getMail() +
                        "', PESEL = '" + worker.getPESEL() +
                        "', WAREHOUSE = " + worker.getWarehouseIndex() +
                        " WHERE ID = " + worker.getIndex());

                refreshWorker(worker);
            }
        }
        else {
            this.app.showWarning("No selection", "You have to select worker to edit it.");
        }
    }

    /**
     * Search for Worker using SQL query.
     * When a worker is found, function refreshes all fxml elements.
     */
    @FXML private void handleSearchWorker() {
        String trait = this.workerTraitChoiceBox.getValue();
        String wantedTrait = this.workerTraitTextField.getText();

        // TODO use SQL query to search for worker
        // SELECT index FROM workers
        // WHERE [trait] = [wantedTrait]
        this.app.sqlselect("SELECT * FROM worker WHERE LOWER(" + trait + ") like lower('%" + wantedTrait + "%')");
    }

    /**
     * Changes WarehouseTableView selection to specific warehouse.
     * @param warehouse Warehouse
     */
    private void refreshWarehouse(Warehouse warehouse) {
        this.warehouseTableView.refresh();
        this.warehouseTableView.getSelectionModel().select(warehouse);
        this.workerChoiceBox.setItems(warehouse.getWorkersObservable());
        this.workerChoiceBox.getSelectionModel().clearSelection();
        showWorker(null);
    }

    /**
     * Changes WarehouseTableView selection to warehouse that contains specific worker
     * and WorkerChoiceBox selection to that worker then displays worker's features on Labels.
     * Used in handleAddWorker, handleEditWorker.
     * @param worker Worker
     */
    private void refreshWorker(Worker worker) {
        for(Warehouse warehouse : this.app.getWarehouses()) {
            if(warehouse.getIndex() == worker.getWarehouseIndex()) {
                this.warehouseTableView.refresh();
                this.warehouseTableView.getSelectionModel().select(warehouse);
                this.workerChoiceBox.setItems(warehouse.getWorkersObservable());
                this.workerChoiceBox.getSelectionModel().select(worker);
            }
        }
        showWorker(worker);
    }

    /**
     * Displays worker's traits on Labels
     * @param worker Worker
     */
    private void showWorker(Worker worker) {
        if(worker != null) {
            this.workerIdLabel.setText(worker.getIndexString());
            this.workerNameLabel.setText(worker.getName());
            this.workerSurnameLabel.setText(worker.getSurname());
            this.workerAddressLabel.setText(worker.getAddress());
            this.workerTelNumLabel.setText(worker.getTelNum());
            this.workerMailLabel.setText(worker.getMail());
            this.workerPESELLabel.setText(worker.getPESEL());
        }
        else {
            this.workerIdLabel.setText("No selection");
            this.workerNameLabel.setText("No selection");
            this.workerSurnameLabel.setText("No selection");
            this.workerAddressLabel.setText("No selection");
            this.workerTelNumLabel.setText("No selection");
            this.workerMailLabel.setText("No selection");
            this.workerPESELLabel.setText("No selection");
        }
    }

    /**
     * Sets WarehouseLogisticsController's app.
     * Sets warehouseTableView with warehouseObservableList.
     * Sets traitsChoiceBoxes with constant values.
     * @param app DatabaseApp
     */
    public void setApp(DatabaseApp app) {
        this.app = app;
        this.warehouseTableView.setItems(this.app.getWarehouses());
        this.workerChoiceBox.setItems(this.app.getWorkers());
        ObservableList<String> warehouseTraits = FXCollections.observableArrayList();
        warehouseTraits.addAll("Address", "Id");
        ObservableList<String> workerTraits = FXCollections.observableArrayList();
        workerTraits.addAll("Id", "Name", "Surname", "Address",
                "Telephone Number", "Mail Address", "PESEL");
        this.warehouseTraitChoiceBox.setItems(warehouseTraits);
        this.workerTraitChoiceBox.setItems(workerTraits);
    }
}
