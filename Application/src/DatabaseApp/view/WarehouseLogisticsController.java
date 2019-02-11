package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import DatabaseApp.SQLHelper;
import DatabaseApp.classes.Warehouse;
import DatabaseApp.classes.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public WarehouseLogisticsController() {}

    @FXML private void initialize() {
        this.warehouseIdTableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getIdWarehouseProperty()
        );

        this.warehouseAddressTableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAddressWarehouseProperty()
        );

        this.warehouseTableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> this.workerChoiceBox.setItems(newValue.getWorkerArrayList()))
        );

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

    }

    /**
     * Deletes selected Worker from:
     *     1) workerObservableList,
     *     2) database.
     * Commits changes to database.
     */
    @FXML private void handleDelWorker() {

    }

    /**
     * Displays WorkerWindow. After confirmation adds changes to:
     *     1) workerObservableList,
     *     2) database.
     * Commits changes to database.
     */
    @FXML private void handleEditWorker() {

    }

    /**
     * Search for Worker in workerObservableList.
     * When a worker is found, selects it in ChoiceBox.
     * Cancels selection in TableView.
     */
    @FXML private void handleSearchWorker() {

    }

    /**
     * Displays worker's traits on Labels
     * @param worker Worker
     */
    private void showWorker(Worker worker) {
        if(worker != null) {
            this.workerIdLabel.setText(worker.getIdWorker());
            this.workerNameLabel.setText(worker.getNameWorker());
            this.workerSurnameLabel.setText(worker.getSurnameWorker());
            this.workerAddressLabel.setText(worker.getAddressWorker());
            this.workerTelNumLabel.setText(worker.getTelNumWorker());
            this.workerMailLabel.setText(worker.getMailWorker());
            this.workerPESELLabel.setText(worker.getPESELWorker());
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
        ObservableList<String> warehouseTraits = FXCollections.observableArrayList();
        warehouseTraits.addAll("Address", "Id");
        ObservableList<String> workerTraits = FXCollections.observableArrayList();
        workerTraits.addAll("Id", "Name", "Surname", "Address",
                "Telephone Number", "Mail Address", "PESEL");
        this.workerChoiceBox.setItems(this.app.getWorkers());
        this.warehouseTraitChoiceBox.setItems(warehouseTraits);
        this.workerTraitChoiceBox.setItems(workerTraits);
    }
}
