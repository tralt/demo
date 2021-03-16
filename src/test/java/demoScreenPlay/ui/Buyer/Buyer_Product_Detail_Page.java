package demoScreenPlay.ui.Buyer;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Buyer_Product_Detail_Page {

    public static Target LOADING_BAR = Target.the("The loading bar")
            .located(net.serenitybdd.core.annotations.findby.By.cssSelector(".loading-bar"));

    public static Target QUANTITY_BOX = Target.the("Quantity box")
            .located(By.cssSelector("div.ordering .rb-number >input"));

    public static Target ADD_TO_CART_BUTTON = Target.the("Add To Cart button")
            .located(By.cssSelector("label.rb-send >button.btn"));
}
