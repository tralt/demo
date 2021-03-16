package demoScreenPlay.features.Bussines;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("checkout_flow")
})
public class Buyer_Checkout_With_A_Distribution_Center_Item_Story {

    Actor tra = Actor.named("Tra");

    @Managed
    WebDriver traDriver;

    @Before
    public void Get_The_Stage(){
        tra.can(BrowseTheWeb.with(traDriver));
    }

    @Test
    public void Buyer_Checkout_With_A_Distribution_Center_Item_(){

    }

}
