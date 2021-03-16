package demoScreenPlay.tasks.Buyer;

import demoScreenPlay.ui.Buyer.Buyer_Cart_Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Buyer_Go_To_Their_Cart implements Task {

    Buyer_Cart_Page buyer_cart_page;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(buyer_cart_page),
                WaitUntil.the(Buyer_Cart_Page.PAYMENT_METHOD_OPTION, WebElementStateMatchers.isVisible()).forNoMoreThan(400).seconds()
        );
    }
}
