package com.qa.pages;

import com.qa.base.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends base
{

    //Page Factory - Object Repository using Page Factory

    //User's Email ID on Dashboard
    @FindBy(xpath = "//span[@class='email-col']")
    WebElement userEmailID;

    //Dashboard Tiles Labels
    @FindBy(xpath = "//h3[contains(text(),'Contractor Registered')]")
    WebElement contractorRegisteredLabel;
    @FindBy(xpath = "//h3[contains(text(),'Lead Posted')]")
    WebElement leadPostedLabel;
    @FindBy(xpath = "//h3[contains(text(),'Payment Transaction')]")
    WebElement paymentTrasactionLabel;
    @FindBy(xpath = "//h3[contains(text(),'Payment Amount')]")
    WebElement paymentAmountLabel;

    //UserManagement Menu's
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementMenu;
    @FindBy(xpath = "//span[contains(text(),'Contractor List')]")
    WebElement contractorListMenu;
    @FindBy(xpath = "//span[contains(text(),'Expired Docs')]")
    WebElement expiredDocsMenu;
    @FindBy(xpath = "//span[contains(text(),'Pending Docs')]")
    WebElement pendingDocsMenu;


    //Initializing the Page Objects by define Constructor:
    public DashboardPage()
    {
        PageFactory.initElements(driver, this);
    }


    //Actions or Methods on the Dashboard Page:
    public String validateDashboardPageTitle()
    {
        return driver.getTitle();
    }

    public String validateEmailID()
    {
        return userEmailID.getText();

    }

    public void clickOnUserManagementLink()
    {
        userManagementMenu.click();
    }

    public ContractorListPage clickOnContractorMenuLink()
    {
        contractorListMenu.click();
        return new ContractorListPage();
    }

    public ExpiredDocsPage clickOnExpiredDocsMenuLink()
    {
        expiredDocsMenu.click();
        return new ExpiredDocsPage();
    }

    public PendingDocsPage clickOnPendingDocsMenuLink()
    {
        pendingDocsMenu.click();
        return new PendingDocsPage();
    }





}
