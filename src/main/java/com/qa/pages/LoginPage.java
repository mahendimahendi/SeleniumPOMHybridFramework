package com.qa.pages;

import com.qa.base.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends base
{
    //Page Factory - Object Repository using Page Factory:
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    WebElement forgotLink;
    @FindBy(xpath = "//div[@class='login-logo']//a//img")
    WebElement logo;
    @FindBy(xpath = "//p[@class='login-account']")
    WebElement pageHeader;
    @FindBy(xpath = "//strong[contains(text(),'Please enter email address')]")
    WebElement validationEmailMsg;
    @FindBy(xpath = "//strong[contains(text(),'Please enter password')]")
    WebElement validationPassMsg;


    //Initializing the Page Objects by define Constructor:
    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    //Actions or Methods on the LoginPage:
    public String validatePageTitle()
    {
        return driver.getTitle();
    }

    public boolean validateLogoImage()
    {
        return logo.isDisplayed();
    }

    public DashboardPage login(String emailID, String pwd)
    {
        email.sendKeys(emailID);
        password.sendKeys(pwd);
        loginBtn.click();

        return new DashboardPage();
    }


}
