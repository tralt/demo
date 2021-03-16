package demoScreenPlay.ui.Buyer;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Buyer_Catalog_Page {

    public static Target LOADING_BAR = Target.the("The loading bar")
            .located(net.serenitybdd.core.annotations.findby.By.cssSelector(".loading-bar"));

    public static Target PRODUCT_NAME = Target.the("Product Name")
            .located(By.cssSelector("div.info .head .name"));
}
