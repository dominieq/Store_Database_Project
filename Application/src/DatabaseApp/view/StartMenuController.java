package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import javafx.fxml.FXML;

public class StartMenuController {

    private DatabaseApp app;

    public StartMenuController() {}

    @FXML private void initialize() {}

    /**
     * Shows WarehouseLogisticsLayout
     */
    @FXML private void handleWarehouseLogistics() {

        /* TODO Show WarehouseLogisticsLayout*/

    }

    /**
     * Shows WarehouseBusinessLayout
     */
    @FXML private void handleWarehouseBusiness() {
        /* TODO Show WarehouseBusinessLayout */
    }

    /**
     * Sets StartMenuController's app
     * @param app DatabaseApp
     */
    public void setApp (DatabaseApp app) {
        this.app =  app;
    }
}
