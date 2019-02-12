package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
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
    @FXML private Label prodcuerAddressLabel;
    @FXML private Label producerEmailLabel;
    @FXML private Label prodcuerTelNumLabel;
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

    @FXML private void initialize() {}

    /**
     * Opens window to create new Stock.
     */
    @FXML private void handleAddStock() {

        // TODO open new window to add new Stock

    }

    /**
     * Opens window to edit selected Stock.
     */
    @FXML private void handleEditStock() {

        // TODO get selected Stock and open new window to edit selection

    }

    /**
     * Gets selected trait from stockTraitsBox and text from stockSearchField.
     * Then looks for a Stock with specific values.
     * When a stock is found displays it's features on stockLabels and changes stockBox selection
     * to found Stock.
     * When function couldn't find stock then it displays information alert.
     */
    @FXML private void handleSearchStock() {

        // TODO get selected trait and text
        // TODO search observableStockList
        // TODO display stock traits on stockLabels and change stockBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new PackDelivery.
     */
    @FXML private void handleAddPackDelivery() {

        // TODO open new window to add new PackDelivery

    }

    /**
     * Gets selected PackDelivery and deletes it from packDeliveries and Database.
     */
    @FXML private void handleDelPackDelivery() {

        // TODO get selection and delete it from packDeliveries and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected PackDelivery.
     */
    @FXML private void handleEditPackDelivery() {

        // TODO get selected PackDelivery and open new window to edit selection

    }

    /**
     * Gets selected trait from packDeliveryTraitsBox and text from packDeliverySearchField.
     * Then looks for a packDelivery with specific values.
     * When a packDelivery is found displays it's features on packDeliveryLabels and changes packDeliveryBox
     * selection to found packDelivery.
     * When function couldn't find packDelivery then it displays information alert.
     */
    @FXML private void handleSearchPackDelivery() {

        // TODO get selected trait and text
        // TODO search packDeliveries
        // TODO display packDelivery's traits on packDeliveryLabels and change packDeliveryBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new PackOrder.
     */
    @FXML private void handleAddPackOrder() {

        // TODO open new window to add new PackOrder

    }

    /**
     * Gets selected PackOrder and deletes it from packOrders and Database.
     */
    @FXML private void handleDelPackOrder() {

        // TODO get selection and delete it from packOrders and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected PackOrder.
     */
    @FXML private void handleEditPackOrder() {

        // TODO get selected PackOrder and open new window to edit selection

    }

    /**
     * Gets selected trait from packOrderTraitsBox and text from packOrderSearchField.
     * Then looks for a packOrder with specific values.
     * When a packOrder is found displays it's features on packOrderLabels and changes packOrderBox
     * selection to found packDelivery.
     * When function couldn't find packOrder then it displays information alert.
     */
    @FXML private void handleSearchPackOrder() {

        // TODO get selected trait and text
        // TODO search packOrders
        // TODO display packOrder's traits on packOrderLabels and change packOrderBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Merchandise.
     */
    @FXML private void handleAddMerch() {

        // TODO open new window to add new Merchandise

    }

    /**
     * Gets selected Merchandise and deletes it from merchandises and Database.
     */
    @FXML private void handleDelMerch() {

        // TODO get selection and delete it from merchandises and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Merchandise.
     */
    @FXML private void handleEditMerch() {

        // TODO get selected Merchandise and open new window to edit selection

    }

    /**
     * Gets selected trait from merchandiseTraitsBox and text from merchandiseSearchField.
     * Then looks for a Merchandise with specific values.
     * When a Merchandise is found, displays it's features on merchandiseLabels and changes merchandiseBox
     * selection to found Merchandise.
     * When function couldn't find Merchandise then it displays information alert.
     */
    @FXML private void handleSearchMerch() {

        // TODO get selected trait and text
        // TODO search Merchandise
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

        // TODO open new window to add new Category

    }

    /**
     * Gets selected Category and deletes it from categories and Database.
     */
    @FXML private void handleDelCategory() {

        // TODO get selection and delete it from categories and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Category.
     */
    @FXML private void handleEditCategory() {

        // TODO get selected Category and open new window to edit selection

    }

    /**
     * Gets selected trait from categoryTraitsBox and text from categorySearchField.
     * Then looks for a Category with specific values.
     * When a Category is found displays it's features on categoryLabels and changes categoryBox
     * selection to found Category.
     * When function couldn't find Category then it displays information alert.
     */
    @FXML private void handleSearchCategory() {

        // TODO get selected trait and text
        // TODO search Category
        // TODO display Category's traits on categoryLabels and change categoryBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Producer.
     */
    @FXML private void handleAddProducer() {

        // TODO open new window to add new Producer

    }

    /**
     * Gets selected Producer and deletes it from producers and Database.
     */
    @FXML private void handleDelProducer() {

        // TODO get selection and delete it from producers and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Producer.
     */
    @FXML private void handleEditProducer() {

        // TODO get selected Producer and open new window to edit selection

    }

    /**
     * Gets selected trait from producerTraitsBox and text from producerSearchField.
     * Then looks for a Producer with specific values.
     * When a Producer is found displays it's features on producerLabels and changes producerBox
     * selection to found Producer.
     * When function couldn't find Producer then it displays information alert.
     */
    @FXML private void handleSearchProducer() {

        // TODO get selected trait and text
        // TODO search Producer
        // TODO display Producer's traits on producerLabels and change producerBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Supplier.
     */
    @FXML private void handleAddSupplier() {

        // TODO open new window to add new Supplier

    }

    /**
     * Gets selected Supplier and deletes it from suppliers and Database.
     */
    @FXML private void handleDelSupplier() {

        // TODO get selection and delete it from suppliers and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Supplier.
     */
    @FXML private void handleEditSupplier() {

        // TODO get selected Supplier and open new window to edit selection

    }

    /**
     * Gets selected trait from supplierTraitsBox and text from supplierSearchField.
     * Then looks for a Supplier with specific values.
     * When a Supplier is found displays it's features on supplierLabels and changes supplierBox
     * selection to found Supplier.
     * When function couldn't find Supplier then it displays information alert.
     */
    @FXML private void handleSearchSupplier() {

        // TODO get selected trait and text
        // TODO search Supplier
        // TODO display Supplier's traits on supplierLabels and change supplierBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Supply.
     */
    @FXML private void handleAddSupply() {

        // TODO open new window to add new Supply

    }

    /**
     * Gets selected Supply and deletes it from supplies and Database.
     */
    @FXML private void handleDelSupply() {

        // TODO get selection and delete it from supplies and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Supply.
     */
    @FXML private void handleEditSupply() {

        // TODO get selected Supply and open new window to edit selection

    }

    /**
     * Gets selected trait from supplyTraitsBox and text from supplySearchField.
     * Then looks for a Supply with specific values.
     * When a Supply is found displays it's features on supplyLabels and changes supplyBox
     * selection to found Supply.
     * When function couldn't find Supply then it displays information alert.
     */
    @FXML private void handleSearchSupply() {

        // TODO get selected trait and text
        // TODO search Supply
        // TODO display Supply's traits on supplyLabels and change supplyBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Order.
     */
    @FXML private void handleAddOrder() {

        // TODO open new window to add new Order

    }

    /**
     * Gets selected Order and deletes it from orders and Database.
     */
    @FXML private void handleDelOrder() {

        // TODO get selection and delete it from orders and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Order.
     */
    @FXML private void handleEditOrder() {

        // TODO get selected Order and open new window to edit selection

    }

    /**
     * Gets selected trait from orderTraitsBox and text from orderSearchField.
     * Then looks for a Order with specific values.
     * When an Order is found displays it's features on orderLabels and changes orderBox
     * selection to found Order.
     * When function couldn't find Order then it displays information alert.
     */
    @FXML private void handleSearchOrder() {

        // TODO get selected trait and text
        // TODO search Order
        // TODO display Order's traits on orderLabels and change orderBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Recipient.
     */
    @FXML private void handleAddRecipient() {

        // TODO open new window to add new Recipient

    }

    /**
     * Gets selected Recipient and deletes it from recipients and Database.
     */
    @FXML private void handleDelRecipient() {

        // TODO get selection and delete it from recipients and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Recipient.
     */
    @FXML private void handleEditRecipient() {

        // TODO get selected Recipient and open new window to edit selection

    }

    /**
     * Gets selected trait from recipientTraitsBox and text from recipientSearchField.
     * Then looks for a Recipient with specific values.
     * When a Recipient is found displays it's features on recipientLabels and changes recipientBox
     * selection to found Recipient.
     * When function couldn't find Recipient then it displays information alert.
     */
    @FXML private void handleSearchRecipient() {

        // TODO get selected trait and text
        // TODO search Recipient
        // TODO display Recipient's traits on recipientLabels and change recipientBox selection
        // TODO or display information alert

    }

    /**
     * Opens window to create new Courier.
     */
    @FXML private void handleAddCourier() {

        // TODO open new window to add new Courier

    }

    /**
     * Gets selected Courier and deletes it from couriers and Database.
     */
    @FXML private void handleDelCourier() {

        // TODO get selection and delete it from couriers and Database
        // TODO when no selection display warning alert

    }

    /**
     * Opens window to edit selected Courier.
     */
    @FXML private void handleEditCourier() {

        // TODO get selected Courier and open new window to edit selection

    }

    /**
     * Gets selected trait from courierTraitsBox and text from courierSearchField.
     * Then looks for a Courier with specific values.
     * When a Courier is found displays it's features on courierLabels and changes courierBox
     * selection to found Courier.
     * When function couldn't find Courier then it displays information alert.
     */
    @FXML private void handleSearchCourier() {

        // TODO get selected trait and text
        // TODO search Courier
        // TODO display Courier's traits on courierLabels and change courierBox selection
        // TODO or display information alert

    }

    /**
     * Sets WarehouseBusinessController's app
     * @param app DatabaseApp
     */
    public void setApp(DatabaseApp app) {
        this.app = app;
    }
}
