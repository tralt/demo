package demoScreenPlay.questions.Buyer.Checkout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartInfo {

    public static Question<String> show_SKU_Name_Of_Warehouse_Item() {
        return new SKU_Name_Of_Warehouse_Item();
    }

    public static Question<String> showTotalPriceOfItem() {
        return new DisplayTotalPriceOfItem();
    }

    public static Question<String> summaryOrderValue() {
        return new OrderValue();
    }

    public static Question<String> show_Small_Order_Surcharge() {
        return new Small_Order_Surcharge();
    }

    public static Question<String> summaryTotalPrice() {
        return new TotalPrice();
    }

    public static class SKU_Name_Of_Warehouse_Item implements Question<String>{
        @Override
        public String answeredBy(Actor actor) {
            Target SKU_NAME_OF_WAREHOUSE_ITEM = Target.the("SKU Name").located(By.cssSelector(".cart-item-card.warehouse-item div.variant:not(.unit-upc)"));
            String sku_name = SKU_NAME_OF_WAREHOUSE_ITEM.resolveFor(actor).getText();
            return sku_name;
        }
    }

    public static class DisplayTotalPriceOfItem implements Question<String>
    {
        @Override
        public String answeredBy(Actor actor) {
            Target CURRENT_TOTAL_PRICE = Target.the("Current Price Total of Item").located(By.cssSelector(".cart-item-card.warehouse-item div.summary .total"));
            String current_price = CURRENT_TOTAL_PRICE.resolveFor(actor).getText();
            return current_price;
        }
    }

    public static class OrderValue implements Question<String>{
        @Override
        public String answeredBy(Actor actor) {
            Target ORDER_VALUE = Target.the("Summary Order value")
                    .located(By.cssSelector("table.summary .order-value"));

            String order_value = ORDER_VALUE.resolveFor(actor).getText();
            return order_value;
        }
    }

    public static class Small_Order_Surcharge implements Question<String>
    {
        @Override
        public String answeredBy(Actor actor) {
            Target SMALL_ORDER_SURCHARGE = Target.the("Value of Shipping Fee")
                    .located(By.cssSelector(".summary tr.small_order_surcharge >td:nth-child(2)"));

            String small_order_surcharge = SMALL_ORDER_SURCHARGE.resolveFor(actor).getText();
            return small_order_surcharge;
        }
    }

    public static class TotalPrice implements Question<String>
    {
        @Override
        public String answeredBy(Actor actor) {
            Target TOTAL = Target.the("Total value of order")
                    .located(By.cssSelector("table.summary .total >td:nth-child(2):not(.order-value)"));

            String total = TOTAL.resolveFor(actor).getText();
            return total;
        }
    }
}
