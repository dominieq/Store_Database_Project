package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import DatabaseApp.models.Warehouse;
import DatabaseApp.models.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
                    this.workerChoiceBox.getSelectionModel().selectPrevious();
                }
            });
            return row;
        });

        this.workerChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showWorker(newValue))
        );

    }

    /**
     * Displays WarehouseWindow. After confirmation adds new warehouse to:
     *    1) warehouseObservableList,
     *    2) database.
     * Commits changes to database.
     */
    @FXML private void handleAddWarehouse() {

        /* TODO Display WarehouseWindow */

    }

    /**
     * Deletes selected Warehouse from:
     *     1) warehouseObservableList,
     *     2) database.
     * Commits changes to database.
     */
    @FXML private void handleDelWarehouse() {

    }

    /**
     * Displays WarehouseWindow. After confirmation adds changes to:
     *     1) warehouseObservableList,
     *     2) database.
     * Commits changes to database.
     */
    @FXML private void handleEditWarehouse() {

    }

    /**
     * Search for Warehouse in warehouseObservableList.
     * When a warehouse is found, selects it in TableView.
     */
    @FXML private void handleSearchWarehouse() {

    }

    /**
     * Displays WorkerWindow. After confirmation adds new worker to:
     *    1) workerObservableList,
     *    2) database.
     * Commits changes to database.
     */
    @FXML private void handleAddWorker() {
        Worker worker = new Worker(100, "[name]", "[surname]", "[address]",
                "[telephone number]", "[email address]", "00000000000",
                this.app.getWarehouses().get(0).getIndex());
        if(this.app.showWorkerEditDialog("Add Worker", worker)){
            this.app.getWorkers().add(worker);
            refreshWorker(worker);
        }
    }

    /**
     * Deletes selected Worker from:
     *     1) workerObservableList,
     *     2) database.
     * Commits changes to database.
     */
    @FXML private void handleDelWorker() {
        Worker worker = this.workerChoiceBox.getSelectionModel().getSelectedItem();
        if(worker != null) {
            for (Warehouse warehouse : this.app.getWarehouses()) {
                if(worker.getWarehouseIndex() == warehouse.getIndex()) {
                    warehouse.deleteWorker(worker);
                    this.app.getWorkers().remove(worker);
                }
            }
            showWorker(null);
            this.workerChoiceBox.getSelectionModel().selectFirst();
        }
        else {
            this.app.showWarning("No selection", "First choose worker to delete it");
        }
    }

    /**
     * Displays WorkerWindow. After confirmation adds changes to:
     *     1) workerObservableList,
     *     2) database.
     * Commits changes to database.
     */
    @FXML private void handleEditWorker() {
        Worker worker = this.workerChoiceBox.getSelectionModel().getSelectedItem();
        if(worker != null) {
            if(this.app.showWorkerEditDialog("Edit worker", worker)) refreshWorker(worker);
        }
        else {
            this.app.showWarning("No selection", "First choose worker to edit it");
        }
    }

    /**
     * Search for Worker in workerObservableList.
     * When a worker is found, selects it in ChoiceBox.
     * Cancels selection in TableView.
     */
    @FXML private void handleSearchWorker() {

    }

    private void refreshWorker(Worker worker) {
        for(Warehouse warehouse : this.app.getWarehouses()) {
            if(warehouse.getIndex() == worker.getWarehouseIndex()) {
                this.warehouseTableView.getSelectionModel().select(warehouse);
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
