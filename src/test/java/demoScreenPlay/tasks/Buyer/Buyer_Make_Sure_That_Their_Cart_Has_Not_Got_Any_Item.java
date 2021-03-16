package demoScreenPlay.tasks.Buyer;

import demoScreenPlay.ui.Buyer.Buyer_Cart_Page;
import demoScreenPlay.ui.User_Header;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Buyer_Make_Sure_That_Their_Cart_Has_Not_Got_Any_Item implements Task
{
    @Step("{0} remove all items in the cart (if there is)")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(User_Header.CART_ICON, WebElementStateMatchers.isVisible()).forNoMoreThan(100).seconds(),
                Click.on(User_Header.CART_ICON),
                WaitUntil.the(Buyer_Cart_Page.PAYMENT_METHOD_OPTION, WebElementStateMatchers.isVisible()).forNoMoreThan(100).seconds()
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> lstItem2Delete = driver.findElements(By.cssSelector(".cart-item-card"));
        if (lstItem2Delete.size() != 0)
        {
            for(WebElement item2Delete: lstItem2Delete)
            {
                item2Delete.findElement(By.cssSelector(".summary .danger.rb-send")).click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
                driver.findElement(By.cssSelector(".rb-notification .x")).click();
            }
        }
    }
}
