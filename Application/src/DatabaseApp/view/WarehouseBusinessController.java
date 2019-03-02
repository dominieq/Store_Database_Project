package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import DatabaseApp.exceptions.WrongDateError;
import DatabaseApp.helpers.DQLHelper;
import DatabaseApp.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class WarehouseBusinessController {

    private DatabaseApp app;

    /**
     * Fields that refer to Tab STOCK:
     *     Stock attributes:
     */
    @FXML private ChoiceBox<Stock> stockBox;
    @FXML private ChoiceBox<String> stockTraitsBox;
    @FXML private Label stockAmountLabel;
    @FXML private Label stockWarehouseLabel;
    @FXML private Label stockMerchandiseLabel;
    @FXML private TextField stockSearchField;
    private DQLHelper stockTraitArg;
    /**
     *     PackDelivery attributes:
     */
    @FXML private ChoiceBox<PackDelivery> packDeliveryBox;
    @FXML private ChoiceBox<String> packDeliveryTraitsBox;
    @FXML private Label packDeliveryNumberLabel;
    @FXML private Label packDeliveryAmountLabel;
    @FXML private Label packDeliveryMerchLabel;
    @FXML private Label packDeliveryWarehouseLabel;
    @FXML private TextField packDeliverySearchField;
    private DQLHelper packDeliveryTraitArg;
    /**
     *     Order attributes:
     */
    @FXML private ChoiceBox<PackOrder> packOrderBox;
    @FXML private ChoiceBox<String> packOrderTraitsBox;
    @FXML private Label packOrderNumberLabel;
    @FXML private Label packOrderAmountLabel;
    @FXML private Label packOrderMerchLabel;
    @FXML private Label packOrderWarehouseLabel;
    @FXML private TextField packOrderSearchField;
    private DQLHelper packOrderTraitArg;

    /**
     * Fields that refer to Tab MERCHANDISE:
     *     Merchandise attributes:
     */
    @FXML private ChoiceBox<Merchandise> merchBox;
    @FXML private ChoiceBox<String> merchTraitsBox;
    @FXML private Label merchLabel;
    @FXML private Label merchNameLabel;
    @FXML private Label merchRetailLabel;
    @FXML private Label merchMarketLabel;
    @FXML private Label merchProducerLabel;
    @FXML private Label merchCategoryLabel;
    @FXML private TextField merchSearchField;
    @FXML private ChoiceBox<Category> merchCategoryBox;
    @FXML private ChoiceBox<Producer> merchProducerBox;
    @FXML private ChoiceBox<String> merchCategoryTraitsBox;
    @FXML private ChoiceBox<String> merchProducerTraitsBox;
    @FXML private TextField merchCategorySearchField;
    @FXML private TextField merchProducerSearchField;
    private DQLHelper merchTraitArg;
    /**
     *     Producer attributes:
     */
    @FXML private ChoiceBox<Producer> producerBox;
    @FXML private ChoiceBox<String> producerTraitsBox;
    @FXML private Label producerLabel;
    @FXML private Label producerNameLabel;
    @FXML private Label producerAddressLabel;
    @FXML private Label producerEmailLabel;
    @FXML private Label producerTelNumLabel;
    @FXML private Label producerWebLabel;
    @FXML private TextField producerSearchField;
    private DQLHelper producerTraitArg;
    /**
     *     Category attributes:
     */
    @FXML private ChoiceBox<Category> categoryBox;
    @FXML private ChoiceBox<String> categoryTraitsBox;
    @FXML private Label categoryLabel;
    @FXML private Label categoryNameLabel;
    @FXML private TextField categorySearchField;
    private DQLHelper categoryTraitArg;

    /**
     * Fields that refer to Tab SUPPLIERS & SUPPLIES:
     *     Supplier attributes:
     */
    @FXML private ChoiceBox<Supplier> supplierBox;
    @FXML private ChoiceBox<String> supplierTraitsBox;
    @FXML private Label supplierLabel;
    @FXML private Label supplierNameLabel;
    @FXML private Label supplierAddressLabel;
    @FXML private Label supplierTelNumLabel;
    @FXML private Label supplierEmailLabel;
    @FXML private TextField supplierSearchField;
    private DQLHelper supplierTraitArg;
    /**
     *     Supply attributes:
     */
    @FXML private ChoiceBox<Supply> supplyBox;
    @FXML private ChoiceBox<String> supplyTraitsBox;
    @FXML private Label supplyLabel;
    @FXML private Label supplyStartLabel;
    @FXML private Label supplyEndLabel;
    @FXML private Label supplySupplierLabel;
    @FXML private TextField supplySearchField;
    private DQLHelper supplyTraitArg;

    /**
     * Fields that refer to Tab ORDERS:
     *     Order attributes:
     */
    @FXML private ChoiceBox<Order> orderBox;
    @FXML private ChoiceBox<String> orderTraitsBox;
    @FXML private Label orderLabel;
    @FXML private Label orderStartLabel;
    @FXML private Label orderEndLabel;
    @FXML private Label orderRecipientLabel;
    @FXML private Label orderCourierLabel;
    @FXML private Label orderRecipientRightLabel;
    @FXML private Label orderRecipientNameLabel;
    @FXML private Label orderRecipientSurnameLabel;
    @FXML private Label orderRecipientAddressLabel;
    @FXML private Label orderRecipientTelNumLabel;
    @FXML private Label orderCourierRightLabel;
    @FXML private Label orderCourierTelNumLabel;
    @FXML private TextField orderSearchField;
    private DQLHelper orderTraitArg;
    /**
     *     Recipient attributes:
     */
    @FXML private ChoiceBox<Recipient> recipientBox;
    @FXML private ChoiceBox<String> recipientTraitsBox;
    @FXML private Label recipientLabel;
    @FXML private Label recipientNameLabel;
    @FXML private Label recipientSurnameLabel;
    @FXML private Label recipientAddressLabel;
    @FXML private Label recipientTelNumLabel;
    @FXML private TextField recipientSearchField;
    private DQLHelper recipientTraitArg;
    /**
     *     Courier attributes:
     */
    @FXML private ChoiceBox<Courier> courierBox;
    @FXML private ChoiceBox<String> courierTraitsBox;
    @FXML private Label courierLabel;
    @FXML private Label courierTelNumLabel;
    @FXML private TextField courierSearchField;
    private DQLHelper courierTraitArg;


    public WarehouseBusinessController() {}

    @FXML private void initialize() {

        this.stockBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showStock(newValue))
        );

        this.packDeliveryBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showPackDelivery(newValue))
        );

        this.packOrderBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showPackOrder(newValue))
        );

        this.merchBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showMerchandise(newValue))
        );

        this.producerBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showProducer(newValue))
        );

        this.categoryBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showCategory(newValue))
        );

        this.supplierBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showSupplier(newValue))
        );

        this.supplyBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showSupply(newValue))
        );

        this.orderBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showOrder(newValue))
        );

        this.courierBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showCourier(newValue))
        );

        this.recipientBox.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showRecipient(newValue))
        );
    }

    /**
     * Opens window to create new Stock.
     */
    @FXML private void handleAddStock() {
       Stock stock = new Stock(0, null, null);
       if(this.app.showStockDialog("Add new stock", stock)) {

           // TODO SQL INSERT INTO
           // refresh stocks
           this.app.sqlDMLInsert("INSERT INTO stock (AMOUNT, MERCHANDISE, WAREHOUSE) VALUES(" +
                   stock.getAmount() + ", " +
                   stock.getMerchandise().getIndex() + ", " +
                   stock.getWarehouse().getIndex() + ")");

           this.app.getStocks().add(stock);
           System.out.println("Stock " + stock.toString() + " added");
           stock.createID();

           refreshStock(stock);
       }
    }

    /**
     * Opens window to edit selected Stock.
     */
    @FXML private void handleEditStock() {
        Stock stock = this.stockBox.getValue();
        if(stock != null) {
            int old_merchandise = stock.getMerchandise().getIndex();
            int old_warehouse = stock.getWarehouse().getIndex();
            if(this.app.showStockDialog("Edit " + stock.toString() + " stock", stock)) {

                // TODO SQL UPDATE
                // refresh stocks
                this.app.sqlDMLUpdate("UPDATE STOCK SET AMOUNT = " + stock.getAmount() +
                        ", MERCHANDISE = " + stock.getMerchandise().getIndex() +
                        ", WAREHOUSE = " + stock.getWarehouse().getIndex() +
                        " WHERE MERCHANDISE = " + old_merchandise +
                        " AND WAREHOUSE = " + old_warehouse);

                stock.createID();
                System.out.println("Stock " + stock.toString() + " edited");

                refreshStock(stock);
            }
        }
        else {
            this.app.showWarning("No selection", "Select stock to proceed.");
        }
    }

    private void refreshStock(Stock stock) {
        this.stockBox.getSelectionModel().select(stock);
        showStock(stock);
    }

    /**
     * Gets selected trait from stockTraitsBox and text from stockSearchField.
     * Then looks for a Stock with specific values.
     * When a stock is found displays it's features on stockLabels and changes stockBox selection
     * to found Stock.
     * When function couldn't find stock then it displays information alert.
     */
    @FXML private void handleSearchStock() {

        String trait = this.stockTraitsBox.getValue();
        String wantedTrait = this.stockSearchField.getText();
        try{
            if (wantedTrait.isEmpty()) {
//                System.out.println("null");
                this.stockBox.setItems(this.app.getStocks());
            }
            else {
                int wantedTraitInt = Integer.parseInt(wantedTrait);
//                System.out.println(wantedTraitInt);

                String trait_pattern = this.stockTraitArg.getAskValue(trait);

                // TODO display stock traits on stockLabels and change stockBox selection
                // TODO or display information alert
                List<Vector<Integer>> results = this.app.sqlSelectMore("SELECT MERCHANDISE, WAREHOUSE FROM stock WHERE LOWER(" + trait_pattern + ") = " + wantedTraitInt, 2);

                if(results != null) {
//                    System.out.println("res " + results);
                    ObservableList<Stock> toShow = FXCollections.observableArrayList();
                    for(Stock stock : this.app.getStocks()) {
                        for(Vector<Integer> vector : results) {
                            if((vector.get(0) == stock.getMerchandise().getIndex()) &&
                                    (vector.get(1) == stock.getWarehouse().getIndex())) {
                                toShow.add(stock);
                            }
                        }
                    }
                    this.stockBox.setItems(toShow);
                }
            }
        }
        catch (NumberFormatException exception) {
            String title = "NumberFormatException";
            String content = "Couldn't parseInt from TexField.\n";
            System.out.println(content);
            this.app.showError(title, content);
        }


    }

    /**
     * Opens window to create new PackDelivery.
     */
    @FXML private void handleAddPackDelivery() {
        PackDelivery packDelivery = new PackDelivery(0,  null,  null);
        if(this.app.showPackDeliveryDialog("Add new package of delivery", packDelivery)) {

            // TODO SQL INSERT INTO
            // refresh packDeliveries
            this.app.sqlDMLInsert("INSERT INTO packdelivery (INVOICENUMBER, MERCHANDISE, WAREHOUSE, AMOUNT) VALUES(" +
                    packDelivery.getSupply().getInvoiceNumber() + ", " +
                    packDelivery.getStock().getMerchandise().getIndex() + ", " +
                    packDelivery.getStock().getWarehouse().getIndex() + ", " +
                    packDelivery.getAmount() + ")");

            this.app.getPackDeliveries().add(packDelivery);
            System.out.println("PackDelivery " + packDelivery.getIndex() + " added");

            refreshPackDelivery(packDelivery);
        }

    }

    /**
     * Gets selected PackDelivery and deletes it from packDeliveries and Database.
     */
    @FXML private void handleDelPackDelivery() {
        PackDelivery packDelivery = this.packDeliveryBox.getValue();
        if(packDelivery != null) {

            // TODO SQL DELETE FROM
            // refresh packDeliveries
            this.app.sqlDMLDelete("DELETE FROM packdelivery WHERE INVOICENUMBER = " +
                    packDelivery.getSupply().getInvoiceNumber() + " AND MERCHANDISE = " +
                    packDelivery.getStock().getMerchandise().getIndex() + " AND WAREHOUSE = " +
                    packDelivery.getStock().getWarehouse().getIndex());

            this.app.getPackDeliveries().remove(packDelivery);
            System.out.println("PackDelivery " + packDelivery.toString() + " removed");

            showPackDelivery(null);
        }
        else {
            this.app.showWarning("No selection", "Select package of deliveries to proceed.");
        }

    }

    /**
     * Opens window to edit selected PackDelivery.
     */
    @FXML private void handleEditPackDelivery() {
        PackDelivery packDelivery = this.packDeliveryBox.getValue();
        if(packDelivery != null) {
            int old_invoicenumber = packDelivery.getSupply().getInvoiceNumber();
            int old_merchandise = packDelivery.getStock().getMerchandise().getIndex();
            int old_warehouse = packDelivery.getStock().getWarehouse().getIndex();
            if(this.app.showPackDeliveryDialog("Edit " + packDelivery.getIndex(), packDelivery)) {

                // TODO SQL UPDATE
                // refresh packDeliveries
                this.app.sqlDMLUpdate("UPDATE packdelivery SET AMOUNT = " + packDelivery.getAmount() +
                        ", INVOICENUMBER = " + packDelivery.getSupply().getInvoiceNumber() +
                        ", MERCHANDISE = " + packDelivery.getStock().getMerchandise().getIndex() +
                        ", WAREHOUSE = " + packDelivery.getStock().getWarehouse().getIndex() +
                        " WHERE INVOICENUMBER = " + old_invoicenumber +
                        " AND MERCHANDISE = " + old_merchandise +
                        " AND WAREHOUSE = " + old_warehouse);

                System.out.println("PackDelivery " + packDelivery.getIndex() + " edited");

                refreshPackDelivery(packDelivery);
            }
        } else {
            this.app.showWarning("No selection", "Select package of deliveries to proceed.");
        }

    }

    private void refreshPackDelivery(PackDelivery packDelivery) {
        this.packDeliveryBox.getSelectionModel().select(packDelivery);
        showPackDelivery(packDelivery);
    }

    /**
     * Gets selected trait from packDeliveryTraitsBox and text from packDeliverySearchField.
     * Then looks for a packDelivery with specific values.
     * When a packDelivery is found displays it's features on packDeliveryLabels and changes packDeliveryBox
     * selection to found packDelivery.
     * When function couldn't find packDelivery then it displays information alert.
     */
    @FXML private void handleSearchPackDelivery() {
        String trait = this.packDeliveryTraitsBox.getValue();
        String wantedTrait = this.packDeliverySearchField.getText();

        try{
            if (wantedTrait.isEmpty()) {
//                System.out.println("null");
                this.packDeliveryBox.setItems(this.app.getPackDeliveries());
            }
            else {
                int wantedTraitInt = Integer.parseInt(wantedTrait);

                String trait_pattern = this.packDeliveryTraitArg.getAskValue(trait);

                // TODO display packDelivery's traits on packDeliveryLabels and change packDeliveryBox selection
                // TODO or display information alert
                List<Integer> results = this.app.sqlSelect("SELECT INVOICENUMBER FROM packdelivery WHERE LOWER(" + trait_pattern + ") = " + wantedTraitInt);

                if(results != null) {
//                    System.out.println("res " + results);
                    ObservableList<PackDelivery> toShow = FXCollections.observableArrayList();
                    for(PackDelivery packDelivery : this.app.getPackDeliveries()) {
                        for(Integer invoicenumber : results) {
                            if(invoicenumber == packDelivery.getSupply().getInvoiceNumber()) {
                                toShow.add(packDelivery);
                            }
                        }
                    }
                    this.packDeliveryBox.setItems(toShow);
                }
            }
        }
        catch (NumberFormatException exception) {
            String title = "NumberFormatException";
            String content = "Couldn't parseInt from TexField or for string in app base.\n";
            System.out.println(content);
            this.app.showError(title, content);
        }

    }

    /**
     * Opens window to create new PackOrder.
     */
    @FXML private void handleAddPackOrder() {
        PackOrder packOrder = new PackOrder(0, null, null);
        if(this.app.showPackOrderDialog("Add new package of orders", packOrder)) {

            // TODO SQL INSERT INTO
            // refresh pack of orders
            this.app.sqlDMLInsert("INSERT INTO packorder (INVOICENUMBER, MERCHANDISE, WAREHOUSE, AMOUNT) VALUES(" +
                    packOrder.getOrder().getInvoiceNumber() + ", " +
                    packOrder.getStock().getMerchandise().getIndex() + ", " +
                    packOrder.getStock().getWarehouse().getIndex() + ", " +
                    packOrder.getAmount() + ")");

            System.out.println("PackOrder " + packOrder.toString() + " added");
            this.app.getPackOrders().add(packOrder);

            refreshPackOrder(packOrder);
        }
    }

    /**
     * Gets selected PackOrder and deletes it from packOrders and Database.
     */
    @FXML private void handleDelPackOrder() {
        PackOrder packOrder = this.packOrderBox.getValue();
        if(packOrder != null) {

            // TODO SQL DELETE FROM
            // refresh packOrders
            this.app.sqlDMLDelete("DELETE FROM packorder WHERE INVOICENUMBER = " +
                    packOrder.getOrder().getInvoiceNumber() + " AND MERCHANDISE = " +
                    packOrder.getStock().getMerchandise().getIndex() + " AND WAREHOUSE = " +
                    packOrder.getStock().getWarehouse().getIndex());

            this.app.getPackOrders().remove(packOrder);
            System.out.println("PackOrder " + packOrder.toString() + " removed");

            showPackOrder(null);
        }
        else {
            this.app.showWarning("No selection", "Select package of orders to proceed.");
        }
    }

    /**
     * Opens window to edit selected PackOrder.
     */
    @FXML private void handleEditPackOrder() {
        PackOrder packOrder = this.packOrderBox.getValue();
        if(packOrder != null) {
            int old_invoicenumber = packOrder.getOrder().getInvoiceNumber();
            int old_merchandise = packOrder.getStock().getMerchandise().getIndex();
            int old_warehouse = packOrder.getStock().getWarehouse().getIndex();
            if(this.app.showPackOrderDialog("Edit " + packOrder.toString() + " package of orders", packOrder)) {

                // TODO SQL UPDATE
                // refresh packOrders
                this.app.sqlDMLUpdate("UPDATE packorder SET AMOUNT = " + packOrder.getAmount() +
                        ", INVOICENUMBER = " + packOrder.getOrder().getInvoiceNumber() +
                        ", MERCHANDISE = " + packOrder.getStock().getMerchandise().getIndex() +
                        ", WAREHOUSE = " + packOrder.getStock().getWarehouse().getIndex() +
                        " WHERE INVOICENUMBER = " + old_invoicenumber +
                        " AND MERCHANDISE = " + old_merchandise +
                        " AND WAREHOUSE = " + old_warehouse);

                System.out.println("PackOrder " + packOrder.toString() + " edited");

                refreshPackOrder(packOrder);
            }
        }
        else {
            this.app.showWarning("No selection", "Select package of orders to proceed.");
        }
    }

    private void refreshPackOrder(PackOrder packOrder) {
        this.packOrderBox.getSelectionModel().select(packOrder);
        showPackOrder(packOrder);
    }

    /**
     * Gets selected trait from packOrderTraitsBox and text from packOrderSearchField.
     * Then looks for a packOrder with specific values.
     * When a packOrder is found displays it's features on packOrderLabels and changes packOrderBox
     * selection to found packOelivery.
     * When function couldn't find packOrder then it displays information alert.
     */
    @FXML private void handleSearchPackOrder() {
        String trait = this.packOrderTraitsBox.getValue();
        String wantedTrait = this.packOrderSearchField.getText();

        try{
            if (wantedTrait.isEmpty()) {
//                System.out.println("null");
                this.packOrderBox.setItems(this.app.getPackOrders());
            }
            else {
                int wantedTraitInt = Integer.parseInt(wantedTrait);

                String trait_pattern = this.packOrderTraitArg.getAskValue(trait);

                // TODO display packOrder's traits on packOrderLabels and change packOrderBox selection
                // TODO or display information alert
                List<Integer> results = this.app.sqlSelect("SELECT INVOICENUMBER FROM packorder WHERE LOWER(" + trait_pattern + ") = " + wantedTraitInt);

                if(results != null) {
//                    System.out.println("res " + results);
                    ObservableList<PackOrder> toShow = FXCollections.observableArrayList();
                    for(PackOrder packOrder : this.app.getPackOrders()) {
                        for(Integer invoicenumber : results) {
                            if(invoicenumber == packOrder.getOrder().getInvoiceNumber()) {
                                toShow.add(packOrder);
                            }
                        }
                    }
                    this.packOrderBox.setItems(toShow);
                }
            }
        }
        catch (NumberFormatException exception) {
            String title = "NumberFormatException";
            String content = "Couldn't parseInt from TexField or for string in app base.\n";
            System.out.println(content);
            this.app.showError(title, content);
        }

    }

    /**
     * Opens window to create new Merchandise.
     */
    @FXML private void handleAddMerch() {
        Merchandise merchandise = new Merchandise(0, "[name]", null, null);
        if(this.app.showMerchandiseDialog("Add new merchandise", merchandise)) {

            // TODO SQL INSERT INTO
            // refresh merchandises
            this.app.sqlDMLInsert("INSERT INTO merchandise (ID, NAME, PRICERETAIL, PRICEMARKET, PRODUCER, CATEGORY) VALUES(" +
                    merchandise.getIndex() + ", '" +
                    merchandise.getName() + "', " +
                    merchandise.getPriceRetail() + ", " +
                    merchandise.getPriceMarket() + ", " +
                    merchandise.getProducer().getIndex() + ", " +
                    merchandise.getCategory().getIndex() + ")");

            this.app.getMerchandise().add(merchandise);
            System.out.println("Merchandise " + merchandise.toString() + " added");

            refreshMerchandise(merchandise);
        }
    }

    /**
     * Gets selected Merchandise and deletes it from merchandises and Database.
     */
    @FXML private void handleDelMerch() {
        Merchandise merchandise = merchBox.getValue();
        if(merchandise != null) {

            // TODO SQL DELETE FROM
            // refresh merchandises
            this.app.sqlDMLDelete("DELETE FROM merchandise WHERE ID = " + merchandise.getIndex());

            this.app.getMerchandise().remove(merchandise);
            System.out.println("Merchandise " + merchandise.toString() + " removed");

            showMerchandise(null);
        } else {
            this.app.showWarning("No selection", "Select merchandise to proceed.");
        }
    }

    /**
     * Opens window to edit selected Merchandise.
     */
    @FXML private void handleEditMerch() {
        Merchandise merchandise = this.merchBox.getValue();
        if(merchandise != null) {
            int old_id = merchandise.getIndex();
            if(this.app.showMerchandiseDialog("Edit " + merchandise.toString() + " merchandise", merchandise)) {

                // TODO SQL UPDATE
                // refresh merchandises
                this.app.sqlDMLUpdate("UPDATE merchandise SET ID = " + merchandise.getIndex() +
                        ", NAME = '" + merchandise.getName() +
                        "', PRICERETAIL = " + merchandise.getPriceRetail() +
                        ", PRICEMARKET = " + merchandise.getPriceMarket() +
                        ", PRODUCER = " + merchandise.getProducer().getIndex() +
                        ", CATEGORY = " + merchandise.getCategory().getIndex() +
                        " WHERE ID = " + old_id);

                System.out.println("Merchandise " + merchandise.toString() + " edited");

                refreshMerchandise(merchandise);
            }
        } else {
            this.app.showWarning("No selection", "Select merchandise to proceed.");
        }
    }

    private void refreshMerchandise(Merchandise merchandise) {
        this.merchBox.getSelectionModel().select(merchandise);
        showMerchandise(merchandise);
    }

    /**
     * Gets selected trait from merchandiseTraitsBox and text from merchandiseSearchField.
     * Then looks for a Merchandise with specific values.
     * When a Merchandise is found, displays it's features on merchandiseLabels and changes merchandiseBox
     * selection to found Merchandise.
     * When function couldn't find Merchandise then it displays information alert.
     */
    @FXML private void handleSearchMerch() {
        String trait = this.merchTraitsBox.getValue();
        String wantedTrait = this.merchSearchField.getText();

        String trait_pattern = this.merchTraitArg.getAskValue(trait);

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.merchBox.setItems(this.app.getMerchandise());
        }
        else {

            // TODO display Merchandise's traits on merchandiseLabels and change merchandiseBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM merchandise " +
                    "WHERE lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Merchandise> toShow = FXCollections.observableArrayList();
                for(Merchandise merchandise : this.app.getMerchandise()) {
                    for(Integer index : results) {
                        if(index == merchandise.getIndex()) {
                            toShow.add(merchandise);
                        }
                    }
                }
                this.merchBox.setItems(toShow);
            }
        }
        System.out.println("End of search");
    }


    @FXML private void handleSearchMerchProducer() {
        String trait = this.merchProducerTraitsBox.getValue();
        String wantedTrait = this.merchProducerSearchField.getText();

        String trait_pattern = this.producerTraitArg.getAskValue(trait);

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.merchProducerBox.setItems(this.app.getProducers());
        }
        else {

            // TODO display Producer's traits on producerLabels and change producerBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM producer " +
                    "WHERE lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Producer> toShow = FXCollections.observableArrayList();
                for(Producer producer : this.app.getProducers()) {
                    for(Integer index : results) {
                        if(index == producer.getIndex()) {
                            toShow.add(producer);
                        }
                    }
                }
                this.merchProducerBox.setItems(toShow);
            }
        }
        System.out.println("End of search");
    }

    @FXML private void handleSearchMerchCategory() {
        String trait = this.merchCategoryTraitsBox.getValue();
        String wantedTrait = this.merchCategorySearchField.getText();

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.merchCategoryBox.setItems(this.app.getCategories());
        }
        else {
            String trait_pattern = this.categoryTraitArg.getAskValue(trait);

            // TODO display Category's traits on categoryLabels and change categoryBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM category WHERE LOWER(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Category> toShow = FXCollections.observableArrayList();
                for (Category category : this.app.getCategories()) {
                    for (Integer index : results) {
                        if (index == category.getIndex()) {
                            toShow.add(category);
                        }
                    }
                }
                this.merchCategoryBox.setItems(toShow);
            }
        }
    }


    /**
     * Gets selection from merchCategoryBox and merchProducerBox.
     * Sets merchBox with items that match selection.
     */
    @FXML private void handleFilterMerch() {
        // TODO get selection from merchCategoryBox and merchProducerBox
        // TODO create temporary merchandise list
        // TODO set merchBox with new list

        Category category = this.merchCategoryBox.getValue();
        Producer producer = this.merchProducerBox.getValue();

        List<Integer> results;
        String askCode = "SELECT ID FROM merchandise";
        if ((category != null) || (producer != null)) {
            if ((category != null) && (producer != null)) {
                askCode += " WHERE CATEGORY = " + category.getIndex() + " AND PRODUCER = " + producer.getIndex();
            } else if (category != null) {
                askCode += " WHERE CATEGORY = " + category.getIndex();
            } else {
                askCode += " WHERE PRODUCER = " + producer.getIndex();
            }

            if (!this.merchSearchField.getText().isEmpty()) {
                String trait = this.merchTraitsBox.getValue();
                String wantedTrait = this.merchSearchField.getText();

                String trait_pattern = this.merchTraitArg.getAskValue(trait);

                askCode += " AND lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')";
            }

            results = this.app.sqlSelect(askCode);

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Merchandise> toShow = FXCollections.observableArrayList();
                for(Merchandise merchandise : this.app.getMerchandise()) {
                    for(Integer index : results) {
                        if(index == merchandise.getIndex()) {
                            toShow.add(merchandise);
                        }
                    }
                }
                this.merchBox.setItems(toShow);
            }
        }
        else {
//            System.out.println("null");
            this.merchProducerBox.setItems(this.app.getProducers());
        }
        System.out.println("End of search");
    }

    /**
     * Opens window to create new Category.
     */
    @FXML private void handleAddCategory() {
        Category category = new Category(0, "[name]");
        boolean isOkClicked = this.app.showCategoryDialog("Add new category", category);
        if(isOkClicked) {

            // TODO SQL INSERT INTO
            // refresh categories
            this.app.sqlDMLInsert("INSERT INTO category (ID, NAME) VALUES(" + category.getIndex() + ", '" + category.getName() + "')");

            this.app.getCategories().add(category);
            System.out.println("Category " + category.toString() + " added");

            refreshCategory(category);
        }
    }

    /**
     * Gets selected Category and deletes it from categories and Database.
     */
    @FXML private void handleDelCategory() {
        Category category = this.categoryBox.getValue();
        if(category != null) {

            // TODO SQL DELETE FROM
            // refresh categories
            this.app.sqlDMLDelete("DELETE FROM category WHERE ID = " + category.getIndex());

            this.app.getCategories().remove(category);
            System.out.println("Category " + category.toString() + " removed");

            showCategory(null);
        } else {
            this.app.showWarning("No selection", "Select category to proceed.");
        }
    }

    /**
     * Opens window to edit selected Category.
     */
    @FXML private void handleEditCategory() {
        Category category = this.categoryBox.getValue();
        if(category != null) {
            int old_id = category.getIndex();
            boolean isOkClicked = this.app.showCategoryDialog(
                    "Edit " + category.toString() + " category", category);
            if(isOkClicked) {

                // TODO SQL UPDATE
                // refresh categories
                this.app.sqlDMLUpdate("UPDATE category SET ID = " + category.getIndex() + ", NAME = '" + category.getName() + "' WHERE ID = " + old_id);

                System.out.println("Category " + category.toString() + " edited");

                refreshCategory(category);
            }
        } else {
            this.app.showWarning("No selection" , "Select category to proceed.");
        }
    }

    private void refreshCategory(Category category) {
        this.categoryBox.getSelectionModel().select(category);
        showCategory(category);
    }

    /**
     * Gets selected trait from categoryTraitsBox and text from categorySearchField.
     * Then looks for a Category with specific values.
     * When a Category is found displays it's features on categoryLabels and changes categoryBox
     * selection to found Category.
     * When function couldn't find Category then it displays information alert.
     */
    @FXML private void handleSearchCategory() {
        String trait = this.categoryTraitsBox.getValue();
        String wantedTrait = this.categorySearchField.getText();

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.categoryBox.setItems(this.app.getCategories());
        }
        else {
            String trait_pattern = this.categoryTraitArg.getAskValue(trait);

            // TODO display Category's traits on categoryLabels and change categoryBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM category WHERE LOWER(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Category> toShow = FXCollections.observableArrayList();
                for (Category category : this.app.getCategories()) {
                    for (Integer index : results) {
                        if (index == category.getIndex()) {
                            toShow.add(category);
                        }
                    }
                }
                this.categoryBox.setItems(toShow);
            }
        }
    }

    /**
     * Opens window to create new Producer.
     */
    @FXML private void handleAddProducer() {
        Producer producer = new Producer(0, "[name]");
        boolean isOkClicked = this.app.showProducerDialog("Add new producer", producer);
        if(isOkClicked) {

            // TODO SQL INSERT INTO
            // refresh producers
            this.app.sqlDMLInsert("INSERT INTO producer (ID, NAME, ADDRESS, MAIL, TELNUM, WEBPAGE) VALUES(" +
                    producer.getIndex() + ", '" +
                    producer.getName() + "', '" +
                    producer.getAddress() + "', '" +
                    producer.getMail() + "', '" +
                    producer.getTelNum() + "', '" +
                    producer.getWebPage() + "')");

            this.app.getProducers().add(producer);
            System.out.println("Producer " + producer.toString() + " added");
            
            refreshProducer(producer);
        }
    }

    /**
     * Gets selected Producer and deletes it from producers and Database.
     */
    @FXML private void handleDelProducer() {
        Producer producer = this.producerBox.getValue();
        if(producer != null) {
            // TODO SQL DELET FROM
            // refresh producers
            this.app.sqlDMLDelete("DELETE FROM producer WHERE ID = " + producer.getIndex());

            this.app.getProducers().remove(producer);
            System.out.println("Producer " + producer.toString() + " removed");

            showProducer(null);
        } else {
            this.app.showWarning("No selection", "Select producer to proceed.");
        }
    }

    /**
     * Opens window to edit selected Producer.
     */
    @FXML private void handleEditProducer() {
        Producer producer = this.producerBox.getValue();
        if(producer != null) {
            int old_id = producer.getIndex();
            boolean isOkClicked = this.app.showProducerDialog(
                    "Edit " + producer.toString() + " producer", producer);
            if(isOkClicked) {

                // TODO SQL UPDATE
                // refresh producers
                this.app.sqlDMLUpdate("UPDATE producer SET ID = " +
                        producer.getIndex() + ", NAME = '" +
                        producer.getName() + "', ADDRESS = '" +
                        producer.getAddress() + "', MAIL = '" +
                        producer.getMail() + "', TELNUM = '" +
                        producer.getTelNum() + "', WEBPAGE = '" +
                        producer.getWebPage() + "' WHERE ID = " +
                        old_id);
                
                System.out.println("Producer " + producer.toString() + " edited");
                
                refreshProducer(producer);
            }
        } else {
            this.app.showWarning("No selection", "Select producer to proceed");
        }
    }

    private void refreshProducer(Producer producer) {
        this.producerBox.getSelectionModel().select(producer);
        showProducer(producer);
    }

    /**
     * Gets selected trait from producerTraitsBox and text from producerSearchField.
     * Then looks for a Producer with specific values.
     * When a Producer is found displays it's features on producerLabels and changes producerBox
     * selection to found Producer.
     * When function couldn't find Producer then it displays information alert.
     */
    @FXML private void handleSearchProducer() {
        String trait = this.producerTraitsBox.getValue();
        String wantedTrait = this.producerSearchField.getText();

        String trait_pattern = this.producerTraitArg.getAskValue(trait);

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.producerBox.setItems(this.app.getProducers());
        }
        else {

            // TODO display Producer's traits on producerLabels and change producerBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM producer " +
                    "WHERE lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Producer> toShow = FXCollections.observableArrayList();
                for(Producer producer : this.app.getProducers()) {
                    for(Integer index : results) {
                        if(index == producer.getIndex()) {
                            toShow.add(producer);
                        }
                    }
                }
                this.producerBox.setItems(toShow);
            }
        }
        System.out.println("End of search");
    }

    /**
     * Opens window to create new Supplier.
     */
    @FXML private void handleAddSupplier() {
        Supplier supplier = new Supplier(0,"[name]", "[address]", "[telephone number]");
        boolean isOkClicked = this.app.showSupplierDialog("Add new supplier", supplier);
        if(isOkClicked) {
            // TODO SQL INSERT INTO
            // refresh suppliers
            this.app.sqlDMLInsert("INSERT INTO supplier (ID, NAME, ADDRESS, TELNUM, MAIL) VALUES(" +
                    supplier.getIndex() + ", '" +
                    supplier.getName() + "', '" +
                    supplier.getAddress() + "', '" +
                    supplier.getTelNum() + "', '" +
                    supplier.getMail() + "')");

            this.app.getSuppliers().add(supplier);
            System.out.println("Supplier " + supplier.toString() + " added");

            refreshSupplier(supplier);
        }
    }

    /**
     * Gets selected Supplier and deletes it from suppliers and Database.
     */
    @FXML private void handleDelSupplier() {
        Supplier supplier = this.supplierBox.getValue();
        if(supplier != null) {
            // TODO SQL DELTE FROM
            // refresh suppliers
            this.app.sqlDMLDelete("DELETE FROM supplier WHERE ID = " + supplier.getIndex());

            this.app.getSuppliers().remove(supplier);
            System.out.println("Supplier " + supplier.toString() + " removed");

            showSupplier(null);
        } else {
            this.app.showWarning("No selection", "Select supplier to proceed");
        }
    }

    /**
     * Opens window to edit selected Supplier.
     */
    @FXML private void handleEditSupplier() {
        Supplier supplier = this.supplierBox.getValue();
        if(supplier != null) {
            int old_id = supplier.getIndex();
            boolean isOkClicked = this.app.showSupplierDialog(
                    "Edit " + supplier.toString() + " supplier", supplier);
            if(isOkClicked) {

                // TODO SQL UPDATE
                // refresh suppliers
                this.app.sqlDMLUpdate("UPDATE supplier SET ID = " +
                        supplier.getIndex() + ", NAME = '" +
                        supplier.getName() + "', ADDRESS = '" +
                        supplier.getAddress() + "', TELNUM = '" +
                        supplier.getTelNum() + "', MAIL = '" +
                        supplier.getMail() + "' WHERE ID = " + old_id);

                System.out.println("Supplier " + supplier.toString() + " edited");

                refreshSupplier(supplier);
            }
        } else {
            this.app.showWarning("No selection", "Select supplier to proceed.");
        }
    }

    private void refreshSupplier(Supplier supplier) {
        this.supplierBox.getSelectionModel().select(supplier);
        showSupplier(supplier);
    }

    /**
     * Gets selected trait from supplierTraitsBox and text from supplierSearchField.
     * Then looks for a Supplier with specific values.
     * When a Supplier is found displays it's features on supplierLabels and changes supplierBox
     * selection to found Supplier.
     * When function couldn't find Supplier then it displays information alert.
     */
    @FXML private void handleSearchSupplier() {
        String trait = this.supplierTraitsBox.getValue();
        String wantedTrait = this.supplierSearchField.getText();

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.supplierBox.setItems(this.app.getSuppliers());
        }
        else {
            String trait_pattern = this.supplierTraitArg.getAskValue(trait);

            // TODO display Supplier's traits on supplierLabels and change supplierBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM supplier WHERE LOWER(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Supplier> toShow = FXCollections.observableArrayList();
                for (Supplier supplier : this.app.getSuppliers()) {
                    for (Integer index : results) {
                        if (index == supplier.getIndex()) {
                            toShow.add(supplier);
                        }
                    }
                }
                this.supplierBox.setItems(toShow);
            }
        }
        
    }

    /**
     * Opens window to create new Supply.
     */
    @FXML private void handleAddSupply() {
        Supply supply = new Supply(0, null);
        boolean isOkClicked = this.app.showSupplyDialog("Add new supply", supply);
        if(isOkClicked) {
            // TODO SQL INSERT INTO
            // refresh supplies
            this.app.sqlDMLInsert("INSERT INTO supply (INVOICENUMBER, STARTDATE, ENDDATE, SUPPLIER) VALUES(" +
                    supply.getInvoiceNumber() + ", DATE '" +
                    supply.getStartDate().toString() + "', DATE '" +
                    supply.getEndDate().toString() + "', " +
                    supply.getSupplier().getIndex() + ")");

            this.app.getSupplies().add(supply);
            System.out.println("Supply " + supply.toString() + " added");
            
            refreshSupply(supply);
        }
    }

    /**
     * Gets selected Supply and deletes it from supplies and Database.
     */
    @FXML private void handleDelSupply() {
        Supply supply = this.supplyBox.getValue();
        if(supply != null) {
            // TODO SQL DELETE FROM
            // refresh supplies
            this.app.sqlDMLDelete("DELETE FROM supply WHERE INVOICENUMBER = " + supply.getInvoiceNumber());

            this.app.getSupplies().remove(supply);
            System.out.println("Supply " + supply.toString() + " removed");

            showSupply(null);
        } else {
            this.app.showWarning("No selection", "Select supply to proceed.");
        }
    }

    /**
     * Opens window to edit selected Supply.
     */
    @FXML private void handleEditSupply() {
        Supply supply = this.supplyBox.getValue();
        if(supply != null) {
            int old_invoicenumber = supply.getInvoiceNumber();
            boolean isOkClicked = this.app.showSupplyDialog(
                    "Edit " + supply.toString() + " supply", supply);
            if(isOkClicked) {

                // TODO SQL UPDATE
                // refresh supplies
                this.app.sqlDMLUpdate("UPDATE supply SET INVOICENUMBER = " + supply.getInvoiceNumber() +
                        ", STARTDATE = DATE '" + supply.getStartDate().toString() +
                        "', ENDDATE = DATE '" + supply.getEndDate().toString() +
                        "', SUPPLIER = " + supply.getSupplier().getIndex() +
                        " WHERE INVOICENUMBER = " + old_invoicenumber);
                
                System.out.println("Supply " + supply.toString() + " edited");
                
                refreshSupply(supply);
            }
        } else {
            this.app.showWarning("No selection", "Select supply to proceed");
        }
    }
    
    private void refreshSupply(Supply supply) {
        this.supplyBox.getSelectionModel().select(supply);
        showSupply(supply);
    }

    /**
     * Gets selected trait from supplyTraitsBox and text from supplySearchField.
     * Then looks for a Supply with specific values.
     * When a Supply is found displays it's features on supplyLabels and changes supplyBox
     * selection to found Supply.
     * When function couldn't find Supply then it displays information alert.
     */
    @FXML private void handleSearchSupply() {
        String trait = this.supplyTraitsBox.getValue();
        String wantedTrait = this.supplySearchField.getText();

        String trait_pattern = this.supplyTraitArg.getAskValue(trait);

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.supplyBox.setItems(this.app.getSupplies());
        }
        else {

            // TODO display Supply's traits on supplyLabels and change supplyBox selection
            // TODO or display information alert
            List<Integer> results;

            if(trait_pattern.contains("DATE")) {
                try {
                    int specTrait = Integer.parseInt(wantedTrait);

                    results = this.app.sqlSelect("SELECT INVOICENUMBER FROM supply " +
                            "WHERE EXTRACT(YEAR FROM " + trait_pattern + ") = " + specTrait +
                            " OR EXTRACT(MONTH FROM " + trait_pattern + ") = " + specTrait +
                            " OR EXTRACT(DAY FROM " + trait_pattern + ") = " + specTrait);

                } catch (Exception e) {

                    results = this.app.sqlSelect("SELECT INVOICENUMBER FROM supply " +
                            "WHERE " + trait_pattern + " = DATE '" + wantedTrait + "'");
                }
            }
            else {
                results = this.app.sqlSelect("SELECT INVOICENUMBER FROM supply " +
                        "WHERE lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");
            }

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Supply> toShow = FXCollections.observableArrayList();
                for(Supply supply : this.app.getSupplies()) {
                    for(Integer index : results) {
                        if(index == supply.getInvoiceNumber()) {
                            toShow.add(supply);
                        }
                    }
                }
                this.supplyBox.setItems(toShow);
            }
        }
        System.out.println("End of search");

    }

    /**
     * Opens window to create new Order.
     */
    @FXML private void handleAddOrder() {
        Order order;
        try {
            order = new Order(0, "01/01/0001", null, null);
            boolean isOkClicked = this.app.showOrderDialog("Add new order", order);
            if (isOkClicked) {
                // TODO SQL INSERT INTO
                // refresh orders
                this.app.sqlDMLInsert("INSERT INTO w_order (INVOICENUMBER, STARTDATE, ENDDATE, COURIER, RECIPIENT) VALUES(" +
                        order.getInvoiceNumber() + ", DATE '" +
                        order.getStartDate().toString() + "', DATE '" +
                        order.getEndDate().toString() + "', " +
                        order.getCourier().getIndex() + ", " +
                        order.getRecipient().getIndex() + ")");

                this.app.getOrders().add(order);
                System.out.println("Order " + order.toString() + " added");
                
                refreshOrder(order);
            }
        } catch (WrongDateError ignored) {
            System.out.println("EARLY STATE: Wrong format when initializing.");
        }
    }

    /**
     * Gets selected Order and deletes it from orders and Database.
     */
    @FXML private void handleDelOrder() {
        Order order = this.orderBox.getValue();
        if(order != null) {
            // TODO SQL DELETE FROM
            // refresh orders
            this.app.sqlDMLDelete("DELETE FROM w_order WHERE INVOICENUMBER = " + order.getInvoiceNumber());

            this.app.getOrders().remove(order);
            System.out.println("Order " + order.toString() + " removed");

            showOrder(null);
        } else {
            this.app.showWarning("No selection",  "Select order to proceed.");
        }
    }

    /**
     * Opens window to edit selected Order.
     */
    @FXML private void handleEditOrder() {
        Order order = this.orderBox.getValue();
        if(order != null) {
            int old_invoicenumber = order.getInvoiceNumber();
            boolean isOkClicked = this.app.showOrderDialog(
                    "Edit " + order.toString() + " order", order);
            if(isOkClicked) {
                // TODO SQL UPDATE
                // refresh orders
                this.app.sqlDMLUpdate("UPDATE w_order SET INVOICENUMBER = " + order.getInvoiceNumber() +
                        ", STARTDATE = DATE '" + order.getStartDate().toString() +
                        "', ENDDATE = DATE '" + order.getEndDate().toString() +
                        "', COURIER = " + order.getCourier().getIndex() +
                        ", RECIPIENT = " + order.getRecipient().getIndex() +
                        " WHERE INVOICENUMBER = " + old_invoicenumber);

                System.out.println("Order " + order.toString() + " edited");
                
                refreshOrder(order);
            }
        } else {
            this.app.showWarning("No selection" , "Select order to proceed.");
        }
    }

    private void refreshOrder(Order order) {
        this.orderBox.getSelectionModel().select(order);
        showOrder(order);
    }

    /**
     * Gets selected trait from orderTraitsBox and text from orderSearchField.
     * Then looks for a Order with specific values.
     * When an Order is found displays it's features on orderLabels and changes orderBox
     * selection to found Order.
     * When function couldn't find Order then it displays information alert.
     */
    @FXML private void handleSearchOrder() {
        String trait = this.orderTraitsBox.getValue();
        String wantedTrait = this.orderSearchField.getText();

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.orderBox.setItems(this.app.getOrders());
        }
        else {
            String trait_pattern = this.orderTraitArg.getAskValue(trait);

            // TODO display Order's traits on orderLabels and change orderBox selection
            // TODO or display information alert

            List<Integer> results;

            if(trait_pattern.contains("DATE")) {
                try {
                    int specTrait = Integer.parseInt(wantedTrait);

                    results = this.app.sqlSelect("SELECT INVOICENUMBER FROM w_order " +
                            "WHERE EXTRACT(YEAR FROM " + trait_pattern + ") = " + specTrait +
                            " OR EXTRACT(MONTH FROM " + trait_pattern + ") = " + specTrait +
                            " OR EXTRACT(DAY FROM " + trait_pattern + ") = " + specTrait);

                } catch (Exception e) {
                    results = this.app.sqlSelect("SELECT INVOICENUMBER FROM w_order " +
                            "WHERE lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

                }
            }
            else {

                    results = this.app.sqlSelect("SELECT INVOICENUMBER FROM w_order WHERE LOWER(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");
            }

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Order> toShow = FXCollections.observableArrayList();
                for (Order order : this.app.getOrders()) {
                    for (Integer index : results) {
                        if (index == order.getInvoiceNumber()) {
                            toShow.add(order);
                        }
                    }
                }
                this.orderBox.setItems(toShow);
            }
        }
        
    }

    /**
     * Opens window to create new Recipient.
     */
    @FXML private void handleAddRecipient() {
        Recipient recipient = new Recipient(0, "[name]", "[surname]",
                "[address]", "[telephone number]");
        if(this.app.showRecipientDialog("Add new recipient", recipient)) {
            // TODO SQL INSERT INTO
            // refresh recipients
            this.app.sqlDMLInsert("INSERT INTO recipient (ID, NAME, SURNAME, ADDRESS, TELNUM) VALUES(" +
                    recipient.getIndex() + ", '" +
                    recipient.getName() + "', '" +
                    recipient.getSurname() + "', '" +
                    recipient.getAddress() + "', '" +
                    recipient.getTelNum() + "')");

            this.app.getRecipients().add(recipient);
            System.out.println("recipient " + recipient.toString() + " added");
            
            refreshRecipient(recipient);
        }
    }

    /**
     * Gets selected Recipient and deletes it from recipients and Database.
     */
    @FXML private void handleDelRecipient() {
        Recipient recipient = this.recipientBox.getValue();
        if(recipient != null) {
            // TODO SQL DELETE FROM
            // refresh recipients
            this.app.sqlDMLDelete("DELETE FROM recipient WHERE ID = " + recipient.getIndex());

            this.app.getRecipients().remove(recipient);
            System.out.println("Recipient " + recipient.toString() + " removed");

            showRecipient(null);
        } else {
            this.app.showWarning("No selection", "Select recipient to proceed.");
        }
    }

    /**
     * Opens window to edit selected Recipient.
     */
    @FXML private void handleEditRecipient() {
        Recipient recipient = this.recipientBox.getValue();
        if(recipient != null) {
            int old_id = recipient.getIndex();
            if(this.app.showRecipientDialog("Edit " + recipient.toString() + " recipient", recipient)) {
                // TODO SQL UPADTE
                // refresh recipients
                this.app.sqlDMLUpdate("UPDATE recipient SET ID = " +
                        recipient.getIndex() + ", NAME = '" +
                        recipient.getName() + "', SURNAME = '" +
                        recipient.getSurname() + "', ADDRESS = '" +
                        recipient.getAddress() + "', TELNUM = '" +
                        recipient.getTelNum() + "' WHERE ID = " + old_id);

                System.out.println("Recipient " + recipient.toString() + " edited");
                
                refreshRecipient(recipient);
            }
        } else {
            this.app.showWarning("No selection", "Select recipient to proceed");
        }

    }
    
    private void refreshRecipient(Recipient recipient) {
        this.recipientBox.getSelectionModel().select(recipient);
        showRecipient(recipient);
    }

    /**
     * Gets selected trait from recipientTraitsBox and text from recipientSearchField.
     * Then looks for a Recipient with specific values.
     * When a Recipient is found displays it's features on recipientLabels and changes recipientBox
     * selection to found Recipient.
     * When function couldn't find Recipient then it displays information alert.
     */
    @FXML private void handleSearchRecipient() {
        String trait = this.recipientTraitsBox.getValue();
        String wantedTrait = this.recipientSearchField.getText();

        String trait_pattern = this.recipientTraitArg.getAskValue(trait);

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.recipientBox.setItems(this.app.getRecipients());
        }
        else {

            // TODO display Recipient's traits on recipientLabels and change recipientBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM recipient " +
                    "WHERE lower(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Recipient> toShow = FXCollections.observableArrayList();
                for(Recipient recipient : this.app.getRecipients()) {
                    for(Integer index : results) {
                        if(index == recipient.getIndex()) {
                            toShow.add(recipient);
                        }
                    }
                }
                this.recipientBox.setItems(toShow);
            }
        }
        System.out.println("End of search");
        
    }

    /**
     * Opens window to create new Courier.
     */
    @FXML private void handleAddCourier() {
        Courier courier = new Courier(0, "[telephone number]");
        if(this.app.showCourier("Add new courier", courier)) {
            // TODO SQL INSERT INTO
            // refresh couriers
            this.app.sqlDMLInsert("INSERT INTO courier (ID, TELNUM) VALUES(" +
                    courier.getIndex() + ", '" +
                    courier.getTelNum() + "')");

            this.app.getCouriers().add(courier);
            System.out.println("Courier " + courier.toString() + " added");

            refreshCourier(courier);
        }
    }

    /**
     * Gets selected Courier and deletes it from couriers and Database.
     */
    @FXML private void handleDelCourier() {
        Courier courier = this.courierBox.getValue();
        if(courier != null) {
            // TODO SQL DELETE FROM
            // refresh couriers
            this.app.sqlDMLDelete("DELETE FROM courier WHERE ID = " + courier.getIndex());

            this.app.getCouriers().remove(courier);
            System.out.println("Courier " + courier.toString() + " removed");

            showCourier(null);
        } else {
            this.app.showWarning("No selection", "Select courier to proceed.");
        }
    }

    /**
     * Opens window to edit selected Courier.
     */
    @FXML private void handleEditCourier() {
        Courier courier = this.courierBox.getValue();
        if(courier != null) {
            int old_id = courier.getIndex();
            if(this.app.showCourier("Edit " + courier.toString() + " courier", courier)){
                // TODO SQL UPDATE
                // refresh
                this.app.sqlDMLUpdate("UPDATE courier SET ID = " +
                        courier.getIndex() + ", TELNUM = '" +
                        courier.getTelNum() + "' WHERE ID = " +
                        old_id);

                System.out.println("Courier " + courier.toString() + " edited");

                refreshCourier(courier);
            }
        } else {
            this.app.showWarning("No selection", "Select courier to proceed.");
        }
    }

    private void refreshCourier(Courier courier) {
        this.courierBox.getSelectionModel().select(courier);
        showCourier(courier);
    }

    /**
     * Gets selected trait from courierTraitsBox and text from courierSearchField.
     * Then looks for a Courier with specific values.
     * When a Courier is found displays it's features on courierLabels and changes courierBox
     * selection to found Courier.
     * When function couldn't find Courier then it displays information alert.
     */
    @FXML private void handleSearchCourier() {
        String trait = this.courierTraitsBox.getValue();
        String wantedTrait = this.courierSearchField.getText();

        if (wantedTrait.isEmpty()) {
//            System.out.println("null");
            this.courierBox.setItems(this.app.getCouriers());
        }
        else {
            String trait_pattern = this.courierTraitArg.getAskValue(trait);

            // TODO display Courier's traits on courierLabels and change courierBox selection
            // TODO or display information alert
            List<Integer> results = this.app.sqlSelect("SELECT ID FROM courier WHERE LOWER(" + trait_pattern + ") like lower('%" + wantedTrait + "%')");

            if(results != null) {
//                System.out.println("res " + results);
                ObservableList<Courier> toShow = FXCollections.observableArrayList();
                for (Courier courier : this.app.getCouriers()) {
                    for (Integer index : results) {
                        if (index == courier.getIndex()) {
                            toShow.add(courier);
                        }
                    }
                }
                this.courierBox.setItems(toShow);
            }
        }

    }

    /**
     * Display stock's traits on Labels.
     * @param stock Stock
     */
    private void showStock(Stock stock) {
        if(stock != null) {
            this.stockAmountLabel.setText(stock.getAmountString());
            this.stockMerchandiseLabel.setText(stock.getMerchandise().getIndexString());
            this.stockWarehouseLabel.setText(stock.getWarehouse().getIndexString());
        } else {
            this.stockAmountLabel.setText("");
            this.stockMerchandiseLabel.setText("");
            this.stockWarehouseLabel.setText("");
        }
    }

    /**
     * Displays packDelivery's traits on Labels.
     * @param packDelivery PackDelivery
     */
    private void showPackDelivery(PackDelivery packDelivery) {
        if(packDelivery != null) {
            this.packDeliveryNumberLabel.setText(packDelivery.getSupply().getInvoiceNumberString());
            this.packDeliveryAmountLabel.setText(packDelivery.getAmountString());
            this.packDeliveryMerchLabel.setText(packDelivery.getStock().getMerchandise().getIndexString());
            this.packDeliveryWarehouseLabel.setText(packDelivery.getStock().getWarehouse().getIndexString());
        }
        else {
            this.packDeliveryNumberLabel.setText("");
            this.packDeliveryAmountLabel.setText("");
            this.packDeliveryMerchLabel.setText("");
            this.packDeliveryWarehouseLabel.setText("");
        }
    }

    /**
     * Displays packOrder's traits on Labels.
     * @param packOrder PackOrder
     */
    private void showPackOrder(PackOrder packOrder) {
        if(packOrder != null) {
            this.packOrderNumberLabel.setText(packOrder.getOrder().getInvoiceString());
            this.packOrderAmountLabel.setText(packOrder.getAmountString());
            this.packOrderMerchLabel.setText(packOrder.getStock().getMerchandise().getIndexString());
            this.packOrderWarehouseLabel.setText(packOrder.getStock().getWarehouse().getIndexString());
        }
        else {
            this.packOrderNumberLabel.setText("");
            this.packOrderAmountLabel.setText("");
            this.packOrderMerchLabel.setText("");
            this.packOrderWarehouseLabel.setText("");
        }
    }

    /**
     * Displays merchandise's traits on Labels.
     * @param merchandise Merchandise
     */
    private void showMerchandise(Merchandise merchandise) {
        if(merchandise != null) {
            this.merchLabel.setText(merchandise.getIndexString());
            this.merchNameLabel.setText(merchandise.getName());
            this.merchRetailLabel.setText(merchandise.getPriceRetailString());
            this.merchMarketLabel.setText(merchandise.getPriceMarketString());
            this.merchProducerLabel.setText(merchandise.getProducer().toString());
            this.merchCategoryLabel.setText(merchandise.getCategory().toString());
        }
        else {
            this.merchLabel.setText("");
            this.merchNameLabel.setText("");
            this.merchRetailLabel.setText("");
            this.merchMarketLabel.setText("");
            this.merchProducerLabel.setText("");
            this.merchCategoryLabel.setText("");
        }
    }

    /**
     * Displays producer's traits on labels.
     * @param producer Producer
     */
    private void showProducer(Producer producer) {
        if(producer != null) {
            this.producerLabel.setText(producer.getIndexString());
            this.producerNameLabel.setText(producer.getName());
            this.producerAddressLabel.setText(producer.getAddress());
            this.producerEmailLabel.setText(producer.getMail());
            this.producerTelNumLabel.setText(producer.getTelNum());
            this.producerWebLabel.setText(producer.getWebPage());
        }
        else {
            this.producerLabel.setText("");
            this.producerNameLabel.setText("");
            this.producerAddressLabel.setText("");
            this.producerEmailLabel.setText("");
            this.producerTelNumLabel.setText("");
            this.producerWebLabel.setText("");
        }
    }

    /**
     * Displays category's traits on Labels.
     * @param category Category
     */
    private void showCategory(Category category) {
        if(category != null) {
            this.categoryLabel.setText(category.getIndexString());
            this.categoryNameLabel.setText(category.getName());
        }
        else {
            this.categoryLabel.setText("");
            this.categoryNameLabel.setText("");
        }
    }

    /**
     * Displays supplier's traits on Labels.
     * @param supplier Supplier
     */
    private void showSupplier(Supplier supplier) {
        if(supplier != null) {
            this.supplierLabel.setText(supplier.getIndexString());
            this.supplierNameLabel.setText(supplier.getName());
            this.supplierAddressLabel.setText(supplier.getAddress());
            this.supplierTelNumLabel.setText(supplier.getTelNum());
            this.supplierEmailLabel.setText(supplier.getMail());
        } else {
            this.supplierLabel.setText("");
            this.supplierNameLabel.setText("");
            this.supplierAddressLabel.setText("");
            this.supplierTelNumLabel.setText("");
            this.supplierEmailLabel.setText("");
        }
    }

    /**
     * Displays supply's traits on Labels.
     * @param supply Supply
     */
    private void showSupply(Supply supply) {
        if(supply != null) {
            this.supplyLabel.setText(supply.getInvoiceNumberString());
            this.supplyStartLabel.setText(supply.getStartDateString());
            this.supplyEndLabel.setText(supply.getEndDateString());
            this.supplySupplierLabel.setText(supply.getSupplier().toString());
        }
        else {
            this.supplyLabel.setText("");
            this.supplyStartLabel.setText("");
            this.supplyEndLabel.setText("");
            this.supplySupplierLabel.setText("");
        }
    }

    /**
     * Displays order's traits on Labels.
     * @param order Order
     */
    private void showOrder(Order order) {
        if(order != null) {
            this.orderLabel.setText(order.getInvoiceString());
            this.orderStartLabel.setText(order.getStartDateString());
            this.orderEndLabel.setText(order.getEndDateString());
            this.orderCourierLabel.setText(order.getCourier().toString());
            this.orderRecipientLabel.setText(order.getRecipient().toString());

            this.orderCourierRightLabel.setText(order.getCourier().getIndexString());
            this.orderCourierTelNumLabel.setText(order.getCourier().getTelNum());

            this.orderRecipientRightLabel.setText(order.getRecipient().getIndexString());
            this.orderRecipientNameLabel.setText(order.getRecipient().getName());
            this.orderRecipientSurnameLabel.setText(order.getRecipient().getSurname());
            this.orderRecipientAddressLabel.setText(order.getRecipient().getAddress());
            this.orderRecipientTelNumLabel.setText(order.getRecipient().getTelNum());
        } else {
            this.orderLabel.setText("");
            this.orderStartLabel.setText("");
            this.orderEndLabel.setText("");
            this.orderCourierLabel.setText("");
            this.orderRecipientLabel.setText("");

            this.orderCourierRightLabel.setText("");
            this.orderCourierTelNumLabel.setText("");

            this.orderRecipientRightLabel.setText("");
            this.orderRecipientNameLabel.setText("");
            this.orderRecipientSurnameLabel.setText("");
            this.orderRecipientAddressLabel.setText("");
            this.orderRecipientTelNumLabel.setText("");
        }
    }

    /**
     * Displays courier's traits on Labels.
     * @param courier Courier
     */
    private void showCourier(Courier courier) {
        if(courier != null) {
            this.courierLabel.setText(courier.getIndexString());
            this.courierTelNumLabel.setText(courier.getTelNum());
        } else {
            this.courierLabel.setText("");
            this.courierTelNumLabel.setText("");
        }
    }

    /**
     * Displays recipient's traits on Labels
     * @param recipient Recipient
     */
    private void showRecipient(Recipient recipient) {
        if(recipient != null) {
            this.recipientLabel.setText(recipient.getIndexString());
            this.recipientNameLabel.setText(recipient.getName());
            this.recipientSurnameLabel.setText(recipient.getSurname());
            this.recipientAddressLabel.setText(recipient.getAddress());
            this.recipientTelNumLabel.setText(recipient.getTelNum());
        } else {
            this.recipientLabel.setText("");
            this.recipientNameLabel.setText("");
            this.recipientSurnameLabel.setText("");
            this.recipientAddressLabel.setText("");
            this.recipientTelNumLabel.setText("");
        }
    }

    /**
     * Sets WarehouseBusinessController's app
     * @param app DatabaseApp
     */
    public void setApp(DatabaseApp app) {

        this.app = app;

        this.stockBox.setItems(app.getStocks());
        this.packDeliveryBox.setItems(app.getPackDeliveries());
        this.packOrderBox.setItems(app.getPackOrders());
        this.merchBox.setItems(app.getMerchandise());
        this.merchCategoryBox.setItems(app.getCategories());
        this.merchProducerBox.setItems(app.getProducers());
        this.producerBox.setItems(app.getProducers());
        this.categoryBox.setItems(app.getCategories());
        this.supplierBox.setItems(app.getSuppliers());
        this.supplyBox.setItems(app.getSupplies());
        this.orderBox.setItems(app.getOrders());
        this.recipientBox.setItems(app.getRecipients());
        this.courierBox.setItems(app.getCouriers());


        //stock
        ObservableList<String> stockTraits = FXCollections.observableArrayList();
        List<String> stockTraitsList = new ArrayList<>(Arrays.asList("Amount", "Merchandise Id", "Warehouse Id"));
        stockTraits.addAll(stockTraitsList);
        this.stockTraitsBox.setItems(stockTraits);
        this.stockTraitsBox.getSelectionModel().selectFirst();
        this.stockTraitArg = new DQLHelper(stockTraitsList, Arrays.asList("AMOUNT", "MERCHANDISE", "WAREHOUSE"));

        //packDelivery
        ObservableList<String> packDeliveryTraits = FXCollections.observableArrayList();
        List<String> packDeliveryTraitsList = new ArrayList<>(Arrays.asList("InvoiceNumber", "Merchandise Id", "Warehouse Id", "Amount"));
        packDeliveryTraits.addAll(packDeliveryTraitsList);
        this.packDeliveryTraitsBox.setItems(packDeliveryTraits);
        this.packDeliveryTraitsBox.getSelectionModel().selectFirst();
        this.packDeliveryTraitArg = new DQLHelper(packDeliveryTraitsList, Arrays.asList("INVOICENUMBER", "MERCHANDISE", "WAREHOUSE", "AMOUNT"));

        //packOrder
        ObservableList<String> packOrderTraits = FXCollections.observableArrayList();
        List<String> packOrderTraitsList = new ArrayList<>(Arrays.asList("Invoice Number", "Merchandise Id", "Warehouse Id", "Amount"));
        packOrderTraits.addAll(packOrderTraitsList);
        this.packOrderTraitsBox.setItems(packOrderTraits);
        this.packOrderTraitsBox.getSelectionModel().selectFirst();
        this.packOrderTraitArg = new DQLHelper(packOrderTraitsList, Arrays.asList("INVOICENUMBER", "MERCHANDISE", "WAREHOUSE", "AMOUNT"));

        //category
        ObservableList<String> categoryTraits = FXCollections.observableArrayList();
        List<String> categoryTraitsList = new ArrayList<>(Arrays.asList("Id", "Name"));
        categoryTraits.addAll(categoryTraitsList);
        this.categoryTraitsBox.setItems(categoryTraits);
        this.categoryTraitsBox.getSelectionModel().selectFirst();
        this.categoryTraitArg = new DQLHelper(categoryTraitsList, Arrays.asList("ID", "NAME"));
        
        //supplier
        ObservableList<String> supplierTraits = FXCollections.observableArrayList();
        List<String> supplierTraitsList = new ArrayList<>(Arrays.asList("Id", "Name", "Address", "Telephone Number", "Mail Address"));
        supplierTraits.addAll(supplierTraitsList);
        this.supplierTraitsBox.setItems(supplierTraits);
        this.supplierTraitsBox.getSelectionModel().selectFirst();
        this.supplierTraitArg = new DQLHelper(supplierTraitsList, Arrays.asList("ID", "NAME", "ADDRESS", "TELNUM", "MAIL"));

        //supply
        ObservableList<String> supplyTraits = FXCollections.observableArrayList();
        List<String> supplyTraitsList = new ArrayList<>(Arrays.asList("Invoice Number", "Start Date", "End Date", "Supplier Id"));
        supplyTraits.addAll(supplyTraitsList);
        this.supplyTraitsBox.setItems(supplyTraits);
        this.supplyTraitsBox.getSelectionModel().selectFirst();
        this.supplyTraitArg = new DQLHelper(supplyTraitsList, Arrays.asList("INVOICENUMBER", "STARTDATE", "ENDDATE", "SUPPLIER"));

        //order
        ObservableList<String> orderTraits = FXCollections.observableArrayList();
        List<String> orderTraitsList = new ArrayList<>(Arrays.asList("Invoice Number", "Start Date", "End Date", "Courier Id", "Recipient Id"));
        orderTraits.addAll(orderTraitsList);
        this.orderTraitsBox.setItems(orderTraits);
        this.orderTraitsBox.getSelectionModel().selectFirst();
        this.orderTraitArg = new DQLHelper(orderTraitsList, Arrays.asList("INVOICENUMBER", "STARTDATE", "ENDDATE", "COURIER", "RECIPIENT"));
        
        //recipient
        ObservableList<String> recipientTraits = FXCollections.observableArrayList();
        List<String> recipientTraitsList = new ArrayList<>(Arrays.asList("Id", "Name", "Surname", "Address", "Telephone Number"));
        recipientTraits.addAll(recipientTraitsList);
        this.recipientTraitsBox.setItems(recipientTraits);
        this.recipientTraitsBox.getSelectionModel().selectFirst();
        this.recipientTraitArg = new DQLHelper(recipientTraitsList, Arrays.asList("ID", "NAME", "SURNAME", "ADDRESS", "TELNUM"));
        
        //courier
        ObservableList<String> courierTraits = FXCollections.observableArrayList();
        List<String> courierTraitsList = new ArrayList<>(Arrays.asList("Id", "Telephone Number"));
        courierTraits.addAll(courierTraitsList);
        this.courierTraitsBox.setItems(courierTraits);
        this.courierTraitsBox.getSelectionModel().selectFirst();
        this.courierTraitArg = new DQLHelper(courierTraitsList, Arrays.asList("ID", "TELNUM"));

        //producer
        ObservableList<String> producerTraits = FXCollections.observableArrayList();
        List<String> producerTraitsList = new ArrayList<>(Arrays.asList("Id", "Name", "Address", "Mail", "Telephone Number", "Web Page"));
        producerTraits.addAll(producerTraitsList);
        this.producerTraitsBox.setItems(producerTraits);
        this.producerTraitsBox.getSelectionModel().selectFirst();
        this.producerTraitArg = new DQLHelper(producerTraitsList, Arrays.asList("ID", "NAME", "ADDRESS", "MAIL", "TELNUM", "WEBPAGE"));

        //merch
        ObservableList<String> merchandiseTraits = FXCollections.observableArrayList();
        List<String> merchandiseTraitsList = new ArrayList<>(Arrays.asList("Id", "Name", "Price Retail", "Price Market", "Producer Id", "Category Id"));
        merchandiseTraits.addAll(merchandiseTraitsList);
        this.merchTraitsBox.setItems(merchandiseTraits);
        this.merchTraitsBox.getSelectionModel().selectFirst();
        this.merchTraitArg = new DQLHelper(merchandiseTraitsList, Arrays.asList("ID", "NAME", "PRICERETAIL", "PRICEMARKET", "PRODUCER", "CATEGORY"));
        this.merchCategoryTraitsBox.setItems(categoryTraits);
        this.merchCategoryTraitsBox.getSelectionModel().selectFirst();
        this.merchProducerTraitsBox.setItems(producerTraits);
        this.merchProducerTraitsBox.getSelectionModel().selectFirst();

    }
}
