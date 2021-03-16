package demoScreenPlay.tasks.User;

import demoScreenPlay.ui.User_SignIn_Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Open_User_SignIn_Page implements Task {
    User_SignIn_Page user_signIn_page;

    @Step("{0} open the Sign In Page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(user_signIn_page)
        );
    }
}
