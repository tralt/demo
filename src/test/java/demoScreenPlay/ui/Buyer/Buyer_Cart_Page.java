package demoScreenPlay.ui.Buyer;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://beta.podfoods.co/cart")
public class Buyer_Cart_Page extends PageObject {

    public static Target CLOSE_MSG_BUTTON = Target.the("close Msg button")
            .located(By.cssSelector(".rb-notification .x"));

    public static Target REMOVE_ITEM_BUTTON = Target.the("Remove item button")
            .located(By.cssSelector(".summary .danger.rb-send"));

    public static Target CHECKOUT_BUTTON = Target.the("Checkout button")
            .located(By.cssSelector("button.btn"));

    // Payment method
    public static Target PAYMENT_METHOD_OPTION = Target.the("Payment method list")
            .located(By.cssSelector("select.input-payment-method"));

    // Thank You Modal
    public static Target THANK_YOU_MODAL = Target.the("Thank You Modal")
            .located(By.cssSelector(".thank-you-modal"));

    public static Target VIEW_YOUR_ORDER_BUTTON = Target.the("View York Order button")
            .located(By.cssSelector(".thank-you-modal .modal-footer >a:nth-child(1)"));


    // cart item

    public static Target TRUCK_ICON = Target.the("Truck icon")
            .located(By.cssSelector("span.pfd-region-icon"));

    public static Target POD_DIRECT_ITEM = Target.the("Pod Direct Item")
            .located(By.cssSelector("span.pod-direct-items-title"));

    public static Target HELP_TEXT_POD_DIRECT_ITEM = Target.the("Help text of Pod Direct Item")
            .located(By.cssSelector("p.pod-direct-items-description"));

    public static Target ITEM_COUNTER = Target.the("Quantity box of item")
            .located(By.cssSelector(".top-bar .actions div.cart .counter"));

    public static Target POD_EXPRESS_ITEM = Target.the("Pod Express Items")
            .located(By.cssSelector("span.pod-express-items-title"));

    public static Target POD_EXPRESS_MSG = Target.the("Pod Express Message")
            .located(By.cssSelector("p.pod-express-items-description"));

    // Summary
    public static Target ORDER_VALUE = Target.the("Summary Order value")
            .located(By.cssSelector("table.summary .order-value"));

    public static Target TAXES = Target.the("Value of Taxes")
            .located(By.cssSelector("table.summary .order-taxes"));

    public static Target PROMOTION_DISCOUNT = Target.the("Value of Promotion Discount")
            .located(By.cssSelector("table.summary .order-promotion"));

    public static Target SMALL_ORDER_SURCHARGE = Target.the("Value of Shipping Fee")
            .located(By.cssSelector(".summary tr.small_order_surcharge >td:nth-child(2)"));

    public static Target TOTAL = Target.the("Total value of order")
            .located(By.cssSelector("table.summary .total >td:nth-child(2):not(.order-value)"));

    public static Target SPECIFIC_STORE_NAME = Target.the("Specific Store Name")
            .located(By.cssSelector("input.form-input-custom-store-name"));

    public static Target LOADING_BAR = Target.the("The loading bar")
            .located(net.serenitybdd.core.annotations.findby.By.cssSelector(".loading-bar"));
}
