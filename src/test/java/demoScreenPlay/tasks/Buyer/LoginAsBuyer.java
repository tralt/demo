package demoScreenPlay.tasks.Buyer;

import demoScreenPlay.ui.User_Header;
import demoScreenPlay.ui.User_SignIn_Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginAsBuyer implements Task {

    private String email;
    private String password;

    public LoginAsBuyer(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public static LoginBuilder withEmail(String email) {
        return new LoginBuilder(email);
    }

    @Step("{0} login as buyer")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(User_SignIn_Page.EMAIL_FIELD, WebElementStateMatchers.isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(this.email).into(User_SignIn_Page.EMAIL_FIELD),
                Enter.theValue(this.password).into(User_SignIn_Page.PASSWORD_FIELD),
                Click.on(User_SignIn_Page.BUYER_OPTION),
                WaitUntil.the(User_SignIn_Page.SIGNIN_BUTTON, WebElementStateMatchers.isClickable()).forNoMoreThan(100).seconds(),
                Click.on(User_SignIn_Page.SIGNIN_BUTTON),
                WaitUntil.the(User_SignIn_Page.LOADING_BAR, WebElementStateMatchers.isNotVisible()).forNoMoreThan(200).seconds()
        );

        boolean isModal = User_SignIn_Page.I_AGREE.resolveAllFor(actor).size() != 0;
        if (isModal){
            actor.attemptsTo(
                    Click.on(User_SignIn_Page.I_AGREE)
            );
        }

        actor.attemptsTo(
                WaitUntil.the(User_Header.SEARCH_BOX, WebElementStateMatchers.isVisible()).forNoMoreThan(200).seconds()
        );
    }

    public static class LoginBuilder{
        private String email;
        private String password;

        public LoginBuilder(String email)
        {
            this.email = email;
        }

        public LoginBuilder andPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginAsBuyer build() {
            return instrumented(LoginAsBuyer.class, email, password);
        }
    }
}
