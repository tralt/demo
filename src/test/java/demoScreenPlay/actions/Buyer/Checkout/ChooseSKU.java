package demoScreenPlay.actions.Buyer.Checkout;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseSKU implements Interaction {
    String sku;

    @Step("{0} choose #sku as an SKU")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> lst_Small_Iamge = driver.findElements(By.cssSelector(".slick-list div.slick-slide"));
        for (WebElement small_image : lst_Small_Iamge)
        {
            small_image.click();
            try{Thread.sleep(2000);} catch (Exception e){e.printStackTrace();}

            String current_SKU_Name = driver.findElement(By.cssSelector(".css-bg1rzq-control .css-1hwfws3 .css-dvua67-singleValue")).getText();
            boolean is_Expected_SKU = current_SKU_Name.equalsIgnoreCase(this.sku);
            if (is_Expected_SKU)
            {
                break;
            }
        }
    }

    public ChooseSKU(String sku)
    {
        this.sku = sku;
    }
}
