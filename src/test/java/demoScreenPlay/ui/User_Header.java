package demoScreenPlay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class User_Header {

    public static Target SEARCH_BOX = Target.the("Search box")
            .located(By.cssSelector(".search-input input"));

    public static Target CATALOG = Target.the("Catalog")
            .located(By.xpath("//a[@href='/products']"));

    public static Target BRANDS = Target.the("Brands")
            .located(By.xpath("//a[@href='/brands']"));

    public static Target PROMOTIONS = Target.the("Promotions")
            .located(By.xpath("//a[@href='/promotions']"));

    public static Target ORDER_GUIDE = Target.the("Order Guide")
            .located(By.xpath("//a[contains(text(), 'Order Guide')]"));

    public static Target RECOMMENDED_PRODUCTS = Target.the("Recommended Products")
            .located(By.xpath("//a[@href='/recommended_products']"));

    public static Target AUTHORIZED_PRODUCTS = Target.the("Authorized Products")
            .located(By.xpath("//a[@href=\"/authorized_products\"]"));

    public static Target FAVORITES_PRODUCTS = Target.the("The Favorites Page")
            .located(By.xpath("//a[@href=\"/favorites\"]"));

    public static Target CART_ICON = Target.the("Icon Cart")
            .located(By.cssSelector("i.fas.fa-shopping-cart"));

    public static Target DASHBOARD = Target.the("Dashboard icon")
            .located(By.cssSelector("div.actions .dashboard"));

    public static Target COUNTER_OF_CART = Target.the("Counter of Cart")
            .located(By.cssSelector(".top-bar .actions div.cart .counter"));

    public static Target TOTAL_VALUE_OF_CART = Target.the("Total value on the cart icon")
            .located(By.cssSelector(".top-bar .actions div.cart .caption"));

    public static Target LOADING_BAR = Target.the("The loading bar")
            .located(net.serenitybdd.core.annotations.findby.By.cssSelector(".loading-bar"));
}
