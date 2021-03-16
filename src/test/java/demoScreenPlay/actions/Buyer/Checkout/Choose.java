package demoScreenPlay.actions.Buyer.Checkout;

import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Choose {
    public static Interaction aSKU(String sku) {
        return instrumented(ChooseSKU.class, sku);
    }

    public static Interaction aQuantity(String quantity) {
        return instrumented(ChooseQuantity.class, quantity);
    }
}
