package DatabaseApp;

import DatabaseApp.helpers.SQLHelper;
import DatabaseApp.models.Warehouse;
import DatabaseApp.models.Worker;
import DatabaseApp.view.RootLayoutController;
import DatabaseApp.view.StartMenuController;
import DatabaseApp.view.WarehouseBusinessController;
import DatabaseApp.view.WarehouseLogisticsController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;

/**
 * TODO comments
 */
public class DatabaseApp extends Application {

    private SQLHelper sqlhelper;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController rootLayoutController;
    private ObservableList<Warehouse> warehouses;
    private ObservableList<Worker> workers;

    /**
     * Starts application. Launches initRootLayout and showStartMenu functions.
     * @param primaryStage Stage
     */
    @Override public void start(Stage primaryStage) {
        this.sqlhelper = new SQLHelper(this);
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Database Project");
        initRootLayout();
        showStartMenu();
    }

    /**
     * Starts rootLayout and sets rootLayoutController.
     * Sets all ObservableLists.
     */
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("view/RootLayout.fxml"));
            this.rootLayout = loader.load();

            Scene scene =  new Scene(this.rootLayout);
            this.primaryStage.setScene(scene);

            this.rootLayoutController = loader.getController();
            this.rootLayoutController.setDatabaseApp(this);

            this.warehouses = FXCollections.observableArrayList();
            this.workers = FXCollections.observableArrayList();

            this.primaryStage.show();
        } catch (Exception exception) {

           if( exception instanceof IOException) {
               System.out.println("IOException: Couldn't load RootLayout.fxml");
               System.exit(1);
           }
           else {
               System.out.println("Error occurred when loading RootLayout");
               exception.printStackTrace();
               System.exit(1);
           }

        }
    }

    /**
     * Displays StartMenuLayout on rootLayout's center.
     * Sets StartMenuController.
     */
    public void showStartMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("view/StartMenu.fxml"));
            AnchorPane pane = loader.load();

            this.rootLayout.setCenter(pane);

            StartMenuController controller = loader.getController();
            controller.setApp(this);

        } catch (Exception exception) {

            if(exception instanceof IOException) {
                System.out.println("IOException: Couldn't load StartMenu");
                System.exit(1);
            }
            else {
                System.out.println("Error occurred when loading StartMenu");
                exception.printStackTrace();
                System.exit(1);
            }

        }
    }

    /**
     * Displays WarehouseLogisticsLayout on rootLayout center.
     * Sets WarehouseLogisticsController.
     */
    public void showWarehouseLogistics() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("view/WarehouseLogistics.fxml"));
            AnchorPane pane = loader.load();

            this.rootLayout.setCenter(pane);

            WarehouseLogisticsController controller = loader.getController();
            controller.setApp(this);
            this.rootLayoutController.setVisible();

        } catch (Exception exception) {

            if(exception instanceof IOException) {
                String error = "IOException: Couldn't load WarehouseLogistics";
                System.out.println(error);
                showError("IOException", error);
            }
            else {
                System.out.println("Error occurred when loading WarehouseLogistics");
                showError("Exception", exception);
            }

        } finally {

            handleSQLExceptions(this.sqlhelper.fillWarehouses());
            handleSQLExceptions(this.sqlhelper.fillWorkers());

        }
    }

    /**
     * Handles some exceptions that may occur when using SQL queries.
     * @param exception Exception
     */
    private void handleSQLExceptions(Exception exception) {

        if(exception instanceof SQLException) {
            showError("SQLError", "Error while executing SELECT query.");
            System.out.println("#####--------#####");
            exception.printStackTrace();
            System.out.println("#####--------#####");
        }
        else if(exception instanceof NullPointerException) {
            showError("Database empty", "Couldn't select relation from database.");
            System.out.println("#####--------#####");
            exception.printStackTrace();
            System.out.println("#####--------#####");
        }
        else if(exception != null) {
            showError("Error", exception);
        }

    }

    /**
     * Displays WarehouseBusinessLayout on rootLayout center.
     * Sets WarehouseBusinessController.
     */
    public void showWarehouseBusiness() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("view/WarehouseBusiness.fxml"));
            TabPane pane = loader.load();

            this.rootLayout.setCenter(pane);

            WarehouseBusinessController controller = loader.getController();
            controller.setApp(this);
            this.rootLayoutController.setVisible();

        } catch (Exception exception) {

            if(exception instanceof IOException) {
                String error = "IOException: Couldn't load WarehouseBusiness";
                System.out.println(error);
                showError("IOException", error);
            }
            else {
                System.out.println("Error occurred when loading WarehouseBusiness");
                showError("Exception", exception);
            }
        }
    }

    /**
     * Shows alert.ERROR using title and content
     * @param title String
     * @param content String
     */
    public void showError(String title, String content) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.showAndWait();

    }

    /**
     * Shows alert.ERROR using title and exception.
     * @param title String
     * @param exception Exception
     */
    public void showError(String title, Exception exception) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(exception.getMessage());
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Returns app's primaryStage
     * @return Stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Returns app's rootLayoutController.
     * @return RootLayoutController
     */
    public RootLayoutController getRootLayoutController() {
        return rootLayoutController;
    }

    /**
     * Returns app's warehouses.
     * @return ObservableList
     */
    public ObservableList<Warehouse> getWarehouses() {
        return warehouses;
    }

    /**
     * Returns app's workers.
     * @return ObservableList
     */
    public ObservableList<Worker> getWorkers() {
        return workers;
    }
}
