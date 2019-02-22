package DatabaseApp;

import DatabaseApp.helpers.SQLHelper;
import DatabaseApp.models.*;
import DatabaseApp.view.*;
import DatabaseApp.viewExtended.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TODO comments
 */
public class DatabaseApp extends Application {

    private SQLHelper sqlhelper;
    private boolean emergencyStart;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController rootLayoutController;
    private volatile ObservableList<Warehouse> warehouses;
    private volatile ObservableList<Worker> workers;
    private volatile ObservableList<Category> categories;
    private volatile ObservableList<Courier> couriers;
    private volatile ObservableList<Merchandise> merchandises;
    private volatile ObservableList<Order> orders;
    private volatile ObservableList<PackDelivery> packDeliveries;
    private volatile ObservableList<PackOrder> packOrders;
    private volatile ObservableList<Producer> producers;
    private volatile ObservableList<Recipient> recipients;
    private volatile ObservableList<Stock> stocks;
    private volatile ObservableList<Supplier> suppliers;
    private volatile ObservableList<Supply> supplies;


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
            this.categories = FXCollections.observableArrayList();
            this.couriers = FXCollections.observableArrayList();
            this.merchandises = FXCollections.observableArrayList();
            this.orders = FXCollections.observableArrayList();
            this.packDeliveries = FXCollections.observableArrayList();
            this.packOrders = FXCollections.observableArrayList();
            this.producers = FXCollections.observableArrayList();
            this.recipients = FXCollections.observableArrayList();
            this.stocks = FXCollections.observableArrayList();
            this.suppliers = FXCollections.observableArrayList();
            this.supplies = FXCollections.observableArrayList();

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

            this.warehouses.clear();
            this.workers.clear();
            this.categories.clear();
            this.couriers.clear();
            this.merchandises.clear();
            this.orders.clear();
            this.packDeliveries.clear();
            this.packOrders.clear();
            this.producers.clear();
            this.recipients.clear();
            this.stocks.clear();
            this.suppliers.clear();
            this.supplies.clear();

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
            if(!emergencyStart) {
                handleSQLExceptions(this.sqlhelper.fillWarehouses(), "Warehouses");
                handleSQLExceptions(this.sqlhelper.fillWorkers(), "Workers");
            }
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
        } finally {
            if(!emergencyStart) {
                handleSQLExceptions(this.sqlhelper.fillWarehouses(), "Warehouse");
                handleSQLExceptions(this.sqlhelper.fillProducers(), "Producers");
                handleSQLExceptions(this.sqlhelper.fillCategories(), "Categories");
                handleSQLExceptions(this.sqlhelper.fillMerchandises(), "Merchandises");
                handleSQLExceptions(this.sqlhelper.fillSuppliers(), "Suppliers");
                handleSQLExceptions(this.sqlhelper.fillSupplies(), "Supplies");
                handleSQLExceptions(this.sqlhelper.fillRecipients(), "Recipients");
                handleSQLExceptions(this.sqlhelper.fillCouriers(), "Couriers");
                handleSQLExceptions(this.sqlhelper.fillOrders(), "Orders");
                handleSQLExceptions(this.sqlhelper.fillStocks(), "Stocks");
                handleSQLExceptions(this.sqlhelper.fillPackDeliveries(), "PackDeliveries");
                handleSQLExceptions(this.sqlhelper.fillPackOrders(), "PackOrders");
            }
        }
    }

    /**
     * Handles some exceptions that may occur when using SQL queries.
     * @param exception Exception
     */
    private void handleSQLExceptions(Exception exception, String table) {

        if(exception instanceof SQLException) {
            showError("SQLError", "Error while executing SELECT FROM " + table);
            System.out.println("#####--------#####");
            System.out.println(exception.getMessage());
            System.out.println("#####--------#####");
        }
        else if(exception instanceof NullPointerException) {
            showError("Database empty", "Couldn't select " + table + " from database.");
            System.out.println("#####--------#####");
            System.out.println(exception.getMessage());
            System.out.println("#####--------#####");
        }
        else if(exception != null) {
            showError("Error", exception);
        }

    }

    /**
     * Displays EditWorkerLayout in new Stage. Sets EditWorkerLayoutController.
     * @param title String: The title of the stage.
     * @param worker Worker: New or old worker.
     * @return Boolean: When worker was edited or created without error, function returns true
     *     otherwise returns false.
     */
    public boolean showWorkerEditDialog(String title, Worker worker) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditWorkerLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditWorkerLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setWorker(worker, this.warehouses);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditWorkerDialog");
            return false;
        }
    }

    /**
     * Displays EditWarehouseLayout in new Stage. Sets EditWarehouseLayoutController.
     * @param title String: The title of the stage.
     * @param warehouse Warehouse: New or old warehouse.
     * @return Boolean: When warehouse was edited or created without error, function returns true
     *     otherwise returns false.
     */
    public boolean showWarehouseDialog(String title, Warehouse warehouse) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditWarehouseLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditWarehouseLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setWarehouse(warehouse);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditWarehouseDialog");
            return false;
        }
    }

    public boolean showStockDialog(String title, Stock stock) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditStockLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditStockLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStock(stock, this.merchandises, this.warehouses);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch(Exception exception) {
            handleEditDialogExceptions(exception, "EditStockDialog");
            return false;
        }
    }

    public boolean showPackOrderDialog(String title, PackOrder packOrder) {
        try {
            FXMLLoader loader =  new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditPackOrderLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditPackOrderLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPackOrder(packOrder, this.stocks, this.orders);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditPackOrderDialog");
            return false;
        }
    }

    public boolean showPackDeliveryDialog(String title, PackDelivery packDelivery) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditPackDeliveryLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditPackDeliveryLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPackDelivery(packDelivery, this.stocks, this.supplies);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditPackDeliveryDialog");
            return false;
        }
    }

    public boolean showMerchandiseDialog(String title, Merchandise merchandise) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditMerchandiseLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditMerchandiseLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMerchandise(merchandise, this.producers, this.categories);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditMerchandiseDialog");
            return false;
        }
    }

    public boolean showProducerDialog(String title, Producer producer) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditProducerLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditProducerLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProducer(producer);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditProducerDialog");
            return false;
        }
    }

    public boolean showCategoryDialog(String title, Category category) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditCategoryLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditCategoryLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCategory(category);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditCategoryDialog");
            return false;
        }
    }

    public boolean showSupplierDialog(String title, Supplier supplier) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditSupplierLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditSupplierLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setSupplier(supplier);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditSupplierDialog");
            return false;
        }
    }


    public boolean showSupplyDialog(String title, Supply supply) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditSupplyLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditSupplyLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setSupply(supply, this.suppliers);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditSupplyDialog");
            return false;
        }
    }

    public boolean showOrderDialog(String title, Order order) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditOrderLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditOrderLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setOrder(order, this.couriers, this.recipients);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditOrderDialog");
            return false;
        }
    }

    public boolean showRecipientDialog(String title, Recipient recipient) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditRecipientLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditRecipientLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setRecipient(recipient);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditRecipientDialog");
            return false;
        }
    }

    public boolean showCourier(String title, Courier courier) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatabaseApp.class.getResource("viewExtended/EditCourierLayout.fxml"));
            SplitPane pane = loader.load();

            Stage dialogStage = setDialogStage(title, pane);

            EditCourierLayoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCourier(courier);

            dialogStage.showAndWait();

            return controller.isAcceptClicked();
        } catch (Exception exception) {
            handleEditDialogExceptions(exception, "EditCourierDialog");
            return false;
        }
    }

    /**
     * Creates Stage for editing objects.
     * @param title String
     * @param pane SplitPane
     * @return Stage
     */
    private Stage setDialogStage(String title, SplitPane pane) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(this.primaryStage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);

        return dialogStage;
    }

    private void handleEditDialogExceptions(Exception exception, String dialog) {
        if(exception instanceof IOException) {
            String error = "IOException: Couldn't load " + dialog;
            System.out.println(error);
            showError("IOException", error);
        }
        else {
            System.out.println("Error occurred when loading " + dialog);
            showError("Exception", exception);
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
    private void showError(String title, Exception exception) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(exception.getMessage());
        alert.showAndWait();
    }

    /**
     * Show alert.WARNING using title and content
     * @param title String
     * @param content String
     */
    public void showWarning(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }



    public void setEmergencyStart(boolean start) {
        this.emergencyStart = start;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
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

    public ObservableList<Category> getCategories() {
        return categories;
    }

    public ObservableList<Merchandise> getMerchandise() {
        return merchandises;
    }

    public ObservableList<Courier> getCouriers() {
        return couriers;
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public ObservableList<PackDelivery> getPackDeliveries() {
        return packDeliveries;
    }

    public ObservableList<PackOrder> getPackOrders() {
        return packOrders;
    }

    public ObservableList<Producer> getProducers() {
        return producers;
    }

    public ObservableList<Recipient> getRecipients() {
        return recipients;
    }

    public ObservableList<Stock> getStocks() {
        return stocks;
    }

    public ObservableList<Supplier> getSuppliers() {
        return suppliers;
    }

    public ObservableList<Supply> getSupplies() {
        return supplies;
    }

    public void sqlDMLInsert(String sqlDLMInsertCode) {
        this.sqlhelper.insertInto(sqlDLMInsertCode);
    }

    public void sqlDMLDelete(String sqlDMLDeleteCode) {
        this.sqlhelper.deleteFrom(sqlDMLDeleteCode);
    }

    public void sqlDMLUpdate(String sqlDMLUpdateCode) {
        this.sqlhelper.updateWhere(sqlDMLUpdateCode);
    }

    public ArrayList<Integer> sqlSelect(String sqlSelectCode) {
        return this.sqlhelper.searchWhere(sqlSelectCode);
    }
}
