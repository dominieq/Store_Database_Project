package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import javafx.fxml.FXML;

/**
 * TODO comments
 */
public class StartMenuController {

    private DatabaseApp app;

    public StartMenuController() {}

    @FXML private void initialize() {}

    /**
     * Changes BorderPane's center to WarehouseLogistics.
     */
    @FXML private void handleWarehouseLogistics() {
        this.app.showWarehouseLogistics();
    }

    /**
     * Changes BorderPane's center WarehouseBusiness
     */
    @FXML private void handleWarehouseBusiness() {
        this.app.showWarehouseBusiness();
    }

    /**
     * Sets StartMenuController's app
     * @param app DatabaseApp
     */
    public void setApp (DatabaseApp app) {
        this.app =  app;
    }
}
