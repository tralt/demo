package demoScreenPlay.actions.Buyer.Checkout;

import demoScreenPlay.ui.Buyer.Buyer_Product_Detail_Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ChooseQuantity implements Interaction {
    private String quantity;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Buyer_Product_Detail_Page.QUANTITY_BOX.resolveFor(actor).clear();
        Buyer_Product_Detail_Page.QUANTITY_BOX.resolveFor(actor).sendKeys(this.quantity);
    }

    public ChooseQuantity(String quantity)
    {
        this.quantity = quantity;
    }
}
