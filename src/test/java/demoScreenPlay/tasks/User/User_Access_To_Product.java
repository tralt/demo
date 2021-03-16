package demoScreenPlay.tasks.User;

import demoScreenPlay.ui.Buyer.Buyer_Catalog_Page;
import demoScreenPlay.ui.Buyer.Buyer_Product_Detail_Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class User_Access_To_Product implements Task {

    private String productName;

    public User_Access_To_Product (String productName)
    {
        this.productName = productName;
    }

    @Step("{0} access to product with name is '#productName'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean isProduct = Buyer_Catalog_Page.PRODUCT_NAME.resolveFor(actor).getText().equalsIgnoreCase(this.productName);
        if (isProduct){
            actor.attemptsTo(
                    Click.on(Buyer_Catalog_Page.PRODUCT_NAME),
                    WaitUntil.the(Buyer_Product_Detail_Page.LOADING_BAR, WebElementStateMatchers.isNotVisible()).forNoMoreThan(500).seconds()
            );
        }

    }

    public static User_Access_To_Product hasName(String productName) {
        return instrumented(User_Access_To_Product.class, productName);
    }
}
