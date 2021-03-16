package demoScreenPlay.tasks.User;

import demoScreenPlay.ui.Buyer.Buyer_Catalog_Page;
import demoScreenPlay.ui.User_Header;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class User_Search_Item implements Task
{
    private String term;

    public User_Search_Item(String term)
    {
        this.term = term;
    }

    public static Performable withTerm(String term) {
        return instrumented(User_Search_Item.class, term);
    }

    @Step("{0} searching with '#term' as a term")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(User_Header.SEARCH_BOX, WebElementStateMatchers.isVisible()).forNoMoreThan(400).seconds(),
                Enter.theValue(this.term).into(User_Header.SEARCH_BOX),
                Hit.the(Keys.ENTER).into(User_Header.SEARCH_BOX),
                WaitUntil.the(Buyer_Catalog_Page.LOADING_BAR, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds()
        );
    }
}
