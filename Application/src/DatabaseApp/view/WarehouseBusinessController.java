package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import DatabaseApp.exceptions.WrongDateError;
import DatabaseApp.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WarehouseBusinessController {

    private DatabaseApp app;

    /**
     * Fields that refer to Tab STOCK:
     *     Stock attributes:
     */
    @FXML private ChoiceBox<Stock> stockBox;
    @FXML private ChoiceBox<String> stockTraitsBox;
    @FXML private Label stockLabel;
    @FXML private Label stockAmountLabel;
    @FXML private Label stockWarehouseLabel;
    @FXML private Label stockMerchandiseLabel;
    @FXML private TextField stockSearchField;
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
    /**
     *     Category attributes:
     */
    @FXML private ChoiceBox<Category> categoryBox;
    @FXML private ChoiceBox<String> categoryTraitsBox;
    @FXML private Label categoryLabel;
    @FXML private Label categoryNameLabel;
    @FXML private TextField categorySearchField;

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
    /**
     *     Courier attributes:
     */
    @FXML private ChoiceBox<Courier> courierBox;
    @FXML private ChoiceBox<String> courierTraitsBox;
    @FXML private Label courierLabel;
    @FXML private Label courierTelNumLabel;
    @FXML private TextField courierSearchField;


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
           System.out.println("Stock " + stock.toString() + " added");
           stock.createID();
           this.app.getStocks().add(stock);

           // TODO SQL INSERT INTO
           // refresh stocks
       }
    }

    /**
     * Opens window to edit selected Stock.
     */
    @FXML private void handleEditStock() {
        Stock stock = this.stockBox.getValue();
        if(stock != null) {
            if(this.app.showStockDialog("Edit " + stock.toString() + " stock", stock)) {
                stock.createID();
                System.out.println("Stock " + stock.toString() + " edited");

                // TODO SQL UPDATE
                // refresh stocks
            }
        }
        else {
            this.app.showWarning("No selection", "Select stock to proceed.");
        }
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
        // TODO display stock traits on stockLabels and change stockBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new PackDelivery.
     */
    @FXML private void handleAddPackDelivery() {
        PackDelivery packDelivery = new PackDelivery(0,  null,  null);
        if(this.app.showPackDeliveryDialog("Add new package of delivery", packDelivery)) {
            System.out.println("PackDelivery " + packDelivery.getIndex() + " added");
            this.app.getPackDeliveries().add(packDelivery);

            // TODO SQL INSERT INTO
            // refresh packDeliveries
        }

    }

    /**
     * Gets selected PackDelivery and deletes it from packDeliveries and Database.
     */
    @FXML private void handleDelPackDelivery() {
        PackDelivery packDelivery = this.packDeliveryBox.getValue();
        if(packDelivery != null) {
            this.app.getPackDeliveries().remove(packDelivery);

            // TODO SQL DELETE FROM
            // refresh packDeliveries
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
            if(this.app.showPackDeliveryDialog("Edit " + packDelivery.getIndex(), packDelivery)) {
                System.out.println("PackDelivery " + packDelivery.getIndex() + " edited");

                // TODO SQL UPDATE
                // refresh packDeliveries
            }
        } else {
            this.app.showWarning("No selection", "Select package of deliveries to proceed.");
        }

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
        // TODO display packDelivery's traits on packDeliveryLabels and change packDeliveryBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new PackOrder.
     */
    @FXML private void handleAddPackOrder() {
        PackOrder packOrder = new PackOrder(0, null, null);
        if(this.app.showPackOrderDialog("Add new package of orders", packOrder)) {
            System.out.println("PackOrder " + packOrder.toString() + " added");
            this.app.getPackOrders().add(packOrder);

            // TODO SQL INSERT INTO
            // refresh pack of orders
        }
    }

    /**
     * Gets selected PackOrder and deletes it from packOrders and Database.
     */
    @FXML private void handleDelPackOrder() {
        PackOrder packOrder = this.packOrderBox.getValue();
        if(packOrder != null) {
            System.out.println("PackOrder " + packOrder.toString() + " removed");
            this.app.getPackOrders().remove(packOrder);

            // TODO SQL DELETE FROM
            // refresh packOrders
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
            if(this.app.showPackOrderDialog("Edit " + packOrder.toString() + " package of orders", packOrder)) {
                System.out.println("PackOrder " + packOrder.toString() + " edited");

                // TODO SQL UPDATE
                // refresh packOrders
            }
        }
        else {
            this.app.showWarning("No selection", "Select package of orders to proceed.");
        }
    }

    /**
     * Gets selected trait from packOrderTraitsBox and text from packOrderSearchField.
     * Then looks for a packOrder with specific values.
     * When a packOrder is found displays it's features on packOrderLabels and changes packOrderBox
     * selection to found packDelivery.
     * When function couldn't find packOrder then it displays information alert.
     */
    @FXML private void handleSearchPackOrder() {
        String trait = this.packOrderTraitsBox.getValue();
        String wantedTrait = this.packOrderSearchField.getText();

        // TODO display packOrder's traits on packOrderLabels and change packOrderBox selection
        // TODO or display information alert
    }

    /**
     * Opens window to create new Merchandise.
     */
    @FXML private void handleAddMerch() {
        Merchandise merchandise = new Merchandise(0, "[name]", null, null);
        if(this.app.showMerchandiseDialog("Add new merchandise", merchandise)) {
            System.out.println("Merchandise " + merchandise.toString() + " added");
            this.app.getMerchandise().add(merchandise);

            // TODO SQL INSERT INTO
            // refresh merchandises
        }
    }

    /**
     * Gets selected Merchandise and deletes it from merchandises and Database.
     */
    @FXML private void handleDelMerch() {
        Merchandise merchandise = merchBox.getValue();
        if(merchandise != null) {
            System.out.println("Merchandise " + merchandise.toString() + " removed");
            this.app.getMerchandise().remove(merchandise);

            // TODO SQL DELETE FROM
            // refresh merchandises
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
            if(this.app.showMerchandiseDialog("Edit " + merchandise.toString() + " merchandise", merchandise)) {
                System.out.println("Merchandise " + merchandise.toString() + " edited");

                // TODO SQL UPDATE
                // refresh merchandises
            }
        } else {
            this.app.showWarning("No selection", "Select merchandise to proceed.");
        }
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
        String wanted = this.merchSearchField.getText();

        // TODO display Merchandise's traits on merchandiseLabels and change merchandiseBox selection
        // TODO or display information alert
    }

    /**
     * Gets selection from merchCategoryBox and merchProducerBox.
     * Sets merchBox with items that match selection.
     */
    @FXML private void handleFilterMerch() {

        // TODO get selection from merchCategoryBox and merchProducerBox
        // TODO create temporary merchandise list
        // TODO set merchBox with new list

    }

    /**
     * Opens window to create new Category.
     */
    @FXML private void handleAddCategory() {
        Category category = new Category(0, "[name]");
        boolean isOkClicked = this.app.showCategoryDialog("Add new category", category);
        if(isOkClicked) {
            System.out.println("Category " + category.toString() + " added");
            this.app.getCategories().add(category);

            // TODO SQL INSERT INTO
            // refresh categories
        }
    }

    /**
     * Gets selected Category and deletes it from categories and Database.
     */
    @FXML private void handleDelCategory() {
        Category category = this.categoryBox.getValue();
        if(category != null) {
            System.out.println("Category " + category.toString() + " removed");
            this.app.getCategories().remove(category);

            // TODO SQL DELETE FROM
            // refresh categories
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
            boolean isOkClicked = this.app.showCategoryDialog(
                    "Edit " + category.toString() + " category", category);
            if(isOkClicked) {
                System.out.println("Category " + category.toString() + " edited");

                // TODO SQL UPDATE
                // refresh categories
            }
        } else {
            this.app.showWarning("No selection" , "Select category to proceed.");
        }
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

        // TODO display Category's traits on categoryLabels and change categoryBox selection
        // TODO or display information alert
    }

    /**
     * Opens window to create new Producer.
     */
    @FXML private void handleAddProducer() {
        Producer producer = new Producer(0, "[name]");
        boolean isOkClicked = this.app.showProducerDialog("Add new producer", producer);
        if(isOkClicked) {
            System.out.println("Producer " + producer.toString() + " added");
            this.app.getProducers().add(producer);

            // TODO SQL INSERT INTO
            // refresh producers
        }
    }

    /**
     * Gets selected Producer and deletes it from producers and Database.
     */
    @FXML private void handleDelProducer() {
        Producer producer = this.producerBox.getValue();
        if(producer != null) {
            System.out.println("Producer " + producer.toString() + " removed");
            this.app.getProducers().remove(producer);

            // TODO SQL DELET FROM
            // refresh producers
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
            boolean isOkClicked = this.app.showProducerDialog(
                    "Edit " + producer.toString() + " producer", producer);
            if(isOkClicked) {
                System.out.println("Producer " + producer.toString() + " edited");

                // TODO SQL UPDATE
                // refresh producers
            }
        } else {
            this.app.showWarning("No selection", "Select producer to proceed");
        }
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

        // TODO display Producer's traits on producerLabels and change producerBox selection
        // TODO or display information alert
    }

    /**
     * Opens window to create new Supplier.
     */
    @FXML private void handleAddSupplier() {
        Supplier supplier = new Supplier(0,"[name]", "[address]", "[telephone number]");
        boolean isOkClicked = this.app.showSupplierDialog("Add new supplier", supplier);
        if(isOkClicked) {
            System.out.println("Supplier " + supplier.toString() + " added");
            this.app.getSuppliers().add(supplier);

            // TODO SQL INSERT INTO
            // refresh suppliers
        }
    }

    /**
     * Gets selected Supplier and deletes it from suppliers and Database.
     */
    @FXML private void handleDelSupplier() {
        Supplier supplier = this.supplierBox.getValue();
        if(supplier != null) {
            System.out.println("Supplier " + supplier.toString() + " removed");
            this.app.getSuppliers().remove(supplier);

            // TODO SQL DELTE FROM
            // refresh suppliers
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
            boolean isOkClicked = this.app.showSupplierDialog(
                    "Edit " + supplier.toString() + " supplier", supplier);
            if(isOkClicked) {
                System.out.println("Supplier " + supplier.toString() + " edited");

                // TODO SQL UPDATE
                // refresh suppliers
            }
        } else {
            this.app.showWarning("No selection", "Select supplier to proceed.");
        }
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

        // TODO display Supplier's traits on supplierLabels and change supplierBox selection
        // TODO or display information alert
    }

    /**
     * Opens window to create new Supply.
     */
    @FXML private void handleAddSupply() {
        Supply supply = new Supply(0, null);
        boolean isOkClicked = this.app.showSupplyDialog("Add new supply", supply);
        if(isOkClicked) {
            System.out.println("Supply " + supply.toString() + " added");
            this.app.getSupplies().add(supply);

            // TODO SQL INSERT INTO
            // refresh supplies
        }
    }

    /**
     * Gets selected Supply and deletes it from supplies and Database.
     */
    @FXML private void handleDelSupply() {
        Supply supply = this.supplyBox.getValue();
        if(supply != null) {
            System.out.println("Supply " + supply.toString() + " removed");
            this.app.getSupplies().remove(supply);

            // TODO SQL DELETE FROM
            // refresh supplies
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
            boolean isOkClicked = this.app.showSupplyDialog(
                    "Edit " + supply.toString() + " supply", supply);
            if(isOkClicked) {
                System.out.println("Supply " + supply.toString() + " edited");

                // TODO SQL UPDATE
                // refresh supplies
            }
        } else {
            this.app.showWarning("No selection", "Select supply to proceed");
        }
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

        // TODO display Supply's traits on supplyLabels and change supplyBox selection
        // TODO or display information alert
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
                System.out.println("Order " + order.toString() + " added");
                this.app.getOrders().add(order);

                // TODO SQL INSERT INTO
                // refresh orders
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
            System.out.println("Order " + order.toString() + " removed");
            this.app.getOrders().remove(order);

            // TODO SQL DELETE FROM
            // refresh orders
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
            boolean isOkClicked = this.app.showOrderDialog(
                    "Edit " + order.toString() + " order", order);
            if(isOkClicked) {
                System.out.println("Order " + order.toString() + " edited");

                // TODO SQL UPDATE
                // refresh orders
            }
        } else {
            this.app.showWarning("No selection" , "Select order to proceed.");
        }
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

        // TODO display Order's traits on orderLabels and change orderBox selection
        // TODO or display information alert
    }

    /**
     * Opens window to create new Recipient.
     */
    @FXML private void handleAddRecipient() {
        Recipient recipient = new Recipient(0, "[name]", "[surname]",
                "[address]", "[telephone number]");
        if(this.app.showRecipientDialog("Add new recipient", recipient)) {
            System.out.println("recipient " + recipient.toString() + " added");
            this.app.getRecipients().add(recipient);

            // TODO SQL INSERT INTO
            // refresh recipients
        }
    }

    /**
     * Gets selected Recipient and deletes it from recipients and Database.
     */
    @FXML private void handleDelRecipient() {
        Recipient recipient = this.recipientBox.getValue();
        if(recipient != null) {
            System.out.println("Recipient " + recipient.toString() + " removed");
            this.app.getRecipients().remove(recipient);

            // TODO SQL DELETE FROM
            // refresh recipients
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
            if(this.app.showRecipientDialog("Edit " + recipient.toString() + " recipient", recipient)) {
                System.out.println("Recipient " + recipient.toString() + " edited");

                // TODO SQL UPADTE
                // refresh recipients
            }
        } else {
            this.app.showWarning("No selection", "Select recipient to proceed");
        }

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

        // TODO display Recipient's traits on recipientLabels and change recipientBox selection
        // TODO or display information alert
    }

    /**
     * Opens window to create new Courier.
     */
    @FXML private void handleAddCourier() {
        Courier courier = new Courier(0, "[telephone number]");
        if(this.app.showCourier("Add new courier", courier)) {
            System.out.println("Courier " + courier.toString() + " added");
            this.app.getCouriers().add(courier);

            // TODO SQL INSERT INTO
            // refresh couriers
        }
    }

    /**
     * Gets selected Courier and deletes it from couriers and Database.
     */
    @FXML private void handleDelCourier() {
        Courier courier = this.courierBox.getValue();
        if(courier != null) {
            System.out.println("Courier " + courier.toString() + " removed");
            this.app.getCouriers().remove(courier);

            // TODO SQL DELETE FROM
            // refresh couriers
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
            if(this.app.showCourier("Edit " + courier.toString() + " courier", courier)){
                System.out.println("Courier " + courier.toString() + " edited");

                // TODO SQL UPDATE
                // refresh
            }
        } else {
            this.app.showWarning("No selection", "Select courier to proceed.");
        }
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
        String wantedTrait = this.categorySearchField.getText();

        // TODO display Courier's traits on courierLabels and change courierBox selection
        // TODO or display information alert
    }

    /**
     * Display stock's traits on Labels.
     * @param stock Stock
     */
    private void showStock(Stock stock) {
        if(stock != null) {
            this.stockLabel.setText(stock.getIndex());
            this.stockAmountLabel.setText(stock.getAmountString());
            this.stockMerchandiseLabel.setText(stock.getMerchandise().getIndexString());
            this.stockWarehouseLabel.setText(stock.getWarehouse().getIndexString());
        } else {
            this.stockLabel.setText("");
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
            this.orderCourierLabel.setText(order.getCourier().getIndexString());
            this.orderRecipientLabel.setText(order.getRecipient().getIndexString());

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
    }
}
