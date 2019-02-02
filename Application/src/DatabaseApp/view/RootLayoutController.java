package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * TODO comments
 */
public class RootLayoutController {

    private DatabaseApp app;

    @FXML private MenuItem backToStartMenuItem;

    @FXML private SeparatorMenuItem separatorMenuItem;

    public RootLayoutController() {}

    @FXML private void initialize() {}

    /**
     * Changes BorderPane's center to StartMenu
     */
    @FXML private void handleBackToStartButton() {

        /* TODO Change BorderPane's center to StartMenu*/

    }

    /**
     * Closes application
     */
    @FXML private void handleCloseButton() {

        /* TODO Close application */

    }

    /**
     * Sets backToStartMenuItem and separatorMenuItem to visible
     */
    public void setVisible() {
        this.backToStartMenuItem.setVisible(true);
        this.separatorMenuItem.setVisible(true);
    }

    /**
     * Sets backToStartMenuItem and separatorMenuItem to invisible
     */
    public void setInvisible() {
        this.backToStartMenuItem.setVisible(false);
        this.separatorMenuItem.setVisible(false);
    }

    /**
     * Sets RootLayoutController's app
     * @param app DatabaseApp
     */
    public void setDatabaseApp(DatabaseApp app) {
        this.app = app;
    }
}
