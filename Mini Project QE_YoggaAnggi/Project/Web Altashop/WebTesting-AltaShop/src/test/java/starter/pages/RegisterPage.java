package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    private By emailField() {
        return By.xpath("/html/body/div/div/main/div/div/div/div[2]/form/div[2]/div/div[1]/div/input");
    }

    private By usernameField() {
        return By.xpath("/html/body/div/div/main/div/div/div/div[2]/form/div[1]/div/div[1]/div/input");
    }

    private By passwordField() {
        return By.xpath("/html/body/div/div/main/div/div/div/div[2]/form/div[3]/div/div[1]/div/input");
    }

    private By registerButton() {
        return By.xpath("/html/body/div/div/main/div/div/div/div[2]/form/div[4]/button");
    }

    @Step
    public boolean validateOnRegisterPage() {
        return $(registerButton()).isDisplayed();
    }

    @Step
    public void inputUsernameRegister(String username) {
        $(usernameField()).type(username);
    }
    @Step
    public void inputEmailRegister(String email) {
        $(emailField()).type(email);
    }
    @Step
    public void inputPasswordRegister(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void clickRegisterButton() {
        $(registerButton()).click();
    }


}
