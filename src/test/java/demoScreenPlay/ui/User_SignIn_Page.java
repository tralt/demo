package demoScreenPlay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://beta.podfoods.co/signin")
public class User_SignIn_Page extends PageObject {

    public static Target EMAIL_FIELD = Target.the("Email field")
            .located(By.xpath("//input[@name='email']"));

    public static Target PASSWORD_FIELD = Target.the("Password field")
            .located(By.xpath("//input[@name='password']"));

    public static Target VENDOR_OPTION = Target.the("Vendor option")
            .located(By.xpath("//input[@value='vendor']"));

    public static Target BUYER_OPTION = Target.the("Buyer option")
            .located(By.xpath("//input[@value='buyer']"));

    public static Target SIGNIN_BUTTON = Target.the("SignIn button")
            .located(By.xpath("//button[@type=\"submit\"]"));

    public static Target TERM_OF_SERVICE_MODAL = Target.the("Term of service modal")
            .located(By.cssSelector("div.terms-modal .modal-content"));

    public static Target I_AGREE = Target.the("I Agree button")
            .located(By.cssSelector("div.terms-modal .modal-content button"));

    public static Target LOADING_BAR = Target.the("The loading bar")
            .located(net.serenitybdd.core.annotations.findby.By.cssSelector(".loading-bar"));

    public static Target WARNING_MESSAGE = Target.the("The Warning message")
            .located(By.cssSelector("ul.messages li"));
}
