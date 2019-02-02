package DatabaseApp;

import DatabaseApp.classes.Warehouse;
import DatabaseApp.classes.Worker;
import DatabaseApp.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DatabaseApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController rootLayoutController;
    private ObservableList<Warehouse> warehouses;
    private ObservableList<Worker> workers;

    @Override public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Database Project");
        initRootLayout();
    }

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
        } catch (IOException exception) {

            /* TODO Handle exception */

        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public RootLayoutController getRootLayoutController() {
        return rootLayoutController;
    }

    public ObservableList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public ObservableList<Worker> getWorkers() {
        return workers;
    }
}
