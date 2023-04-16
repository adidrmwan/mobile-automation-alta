package starter.screen;

import io.appium.java_client.AppiumBy;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import test.automation.pageobject.BasePageObject;

public class LoginScreen extends BasePageObject {
    private By emailFiled() {
        return AppiumBy.id("textInputEditTextEmail");
    }

    private By passwordField() {
        return AppiumBy.id("textInputEditTextPassword");
    }

    private By loginButton() {
        return AppiumBy.id("appCompatButtonLogin");
    }

    private By errorMessage() {
        return AppiumBy.id("snackbar_text");
    }

    @Step
    public void onLoginPage() {
        Assert.assertTrue(waitUntilVisible(loginButton()).isDisplayed());
    }

    @Step
    public void inputEmail(String email) {
        onType(emailFiled(), email);
    }

    @Step
    public void inputPassword(String password) {
        onType(passwordField(), password);
    }

    @Step
    public void tapLoginButton() {
        onClick(loginButton());
    }

    @Step
    public String getErrorMessage() {
        return waitUntilVisible(errorMessage()).getText();
    }

}
