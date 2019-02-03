package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import javafx.fxml.FXML;

public class WarehouseBusinessController {

    private DatabaseApp app;

    public WarehouseBusinessController() {}

    @FXML private void initialize() {}

    /**
     * Sets WarehouseBusinessController's app
     * @param app DatabaseApp
     */
    public void setApp(DatabaseApp app) {
        this.app = app;
    }
}
