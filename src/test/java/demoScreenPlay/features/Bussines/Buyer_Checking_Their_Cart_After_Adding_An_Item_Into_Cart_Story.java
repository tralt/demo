package demoScreenPlay.features.Bussines;

import demoScreenPlay.questions.Buyer.Checkout.CartInfo;
import demoScreenPlay.tasks.Buyer.Buyer_Adding_Item_Into_Cart;
import demoScreenPlay.tasks.Buyer.Buyer_Go_To_Their_Cart;
import demoScreenPlay.tasks.Buyer.Buyer_Make_Sure_That_Their_Cart_Has_Not_Got_Any_Item;
import demoScreenPlay.tasks.Buyer.LoginAsBuyer;
import demoScreenPlay.tasks.User.Open_User_SignIn_Page;
import demoScreenPlay.tasks.User.User_Access_To_Product;
import demoScreenPlay.tasks.User.User_Search_Item;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("checkout_flow")
})
public class Buyer_Checking_Their_Cart_After_Adding_An_Item_Into_Cart_Story {

    Actor tra = Actor.named("Tra");

    @Managed
    WebDriver traDriver;

    @Before
    public void Get_The_Stage(){
        tra.can(BrowseTheWeb.with(traDriver));
    }

    @Steps
    Open_User_SignIn_Page open_user_signIn_page;

    @Steps
    Buyer_Make_Sure_That_Their_Cart_Has_Not_Got_Any_Item buyer_make_sure_that_their_cart_has_not_got_any_item;

    @Steps
    Buyer_Go_To_Their_Cart buyer_go_to_their_cart;

    @Test
    public void Buyer_Checking_Their_Cart_After_Adding_An_Item_Into_Cart(){
            tra.attemptsTo(
                    open_user_signIn_page,
                    LoginAsBuyer.withEmail("doanthanh@gmail.com").andPassword("tra19009595").build(),
                    buyer_make_sure_that_their_cart_has_not_got_any_item,
                    User_Search_Item.withTerm("Function09"),
                    User_Access_To_Product.hasName("Function09"),
                    Buyer_Adding_Item_Into_Cart.withSKUName("sku1_fun09").andQty("5"),
                    buyer_go_to_their_cart
            );

        tra.should(
                seeThat("SKU Name of Pod Express SKU", CartInfo.show_SKU_Name_Of_Warehouse_Item(), equalTo("sku1_only_express_item")),

                seeThat("Current Price Total of Pod Express SKU", CartInfo.showTotalPriceOfItem(), equalTo("$6.00")),

                seeThat("Order Value of the order", CartInfo.summaryOrderValue(), equalTo("$11.00")),

                seeThat("Small Order Surcharge", CartInfo.show_Small_Order_Surcharge(), equalTo("$30.00")),

                seeThat("Total Price of the order", CartInfo.summaryTotalPrice(), equalTo("$41.00"))
        );
    }

}
