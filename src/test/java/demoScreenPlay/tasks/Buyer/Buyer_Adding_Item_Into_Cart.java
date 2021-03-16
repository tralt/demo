package demoScreenPlay.tasks.Buyer;

import demoScreenPlay.actions.Buyer.Checkout.Choose;
import demoScreenPlay.ui.Buyer.Buyer_Product_Detail_Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Buyer_Adding_Item_Into_Cart implements Task {
    private String sku;
    private String quantity;

    public Buyer_Adding_Item_Into_Cart(String sku, String quantity)
    {
        this.sku = sku;
        this.quantity = quantity;
    }

    public static AddCartBuilder withSKUName(String sku) {
        return new AddCartBuilder(sku);
    }

    @Step("{0} add to cart with '#sku' and quantity is '#quantity'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Choose.aSKU(this.sku),
                Choose.aQuantity(this.quantity),
                Click.on(Buyer_Product_Detail_Page.ADD_TO_CART_BUTTON),
                WaitUntil.the(Buyer_Product_Detail_Page.LOADING_BAR, WebElementStateMatchers.isNotVisible()).forNoMoreThan(500).seconds()
        );
    }

    public static class AddCartBuilder{
        private String sku;
        private int quantity;

        public AddCartBuilder(String sku)
        {
            this.sku = sku;
        }

        public Buyer_Adding_Item_Into_Cart andQty(String quantity) {
            return instrumented(Buyer_Adding_Item_Into_Cart.class, sku, quantity);
        }
    }
}
