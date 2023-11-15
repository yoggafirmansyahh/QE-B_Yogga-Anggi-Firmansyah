package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {
    private By title() {
        return By.xpath("/html/body/div/div/header/div/div[1]/h3");
    }

    private By beliButton() {
        return By.xpath("/html/body/div/div/main/div/div/div[2]/div/div[1]/div/div[3]/div[2]/button[2]");
    }

    private By cartCounter() {
        return By.xpath("/html/body/div/div/header/div/button[1]/span/span/span/span");
    }
    @Step
    public boolean validateOnProductPage() {
        return $(title()).isDisplayed();
    }

    @Step
    public boolean beliButtonIsDisplayed() {
        return $(beliButton()).isDisplayed();
    }

    @Step
    public void clickBeliButton() {
        $(beliButton()).click();
    }

    @Step
    public boolean validateCartCounterIsDisplayed() {
        return $(cartCounter()).isDisplayed();
    }
    @Step
    public boolean validateCartCounter() {
        return $(cartCounter()).getText().equals("1");
    }
}
