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
        this.app.showStartMenu();
        if(backToStartMenuItem.isVisible()) {
            setInvisible();
        }
    }

    /**
     * Closes application
     */
    @FXML private void handleCloseButton() {
        this.app.getPrimaryStage().close();
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
    private void setInvisible() {
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
