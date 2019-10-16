package com.qa.pages;

import com.qa.base.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractorListPage extends base
{

    //Page Factory - Object Repository using Page Factory

    //Page Header on the Contractor Listing Page
    @FindBy(xpath = "//h4[@class='text-themecolor']")
    WebElement pageHeader;
    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    WebElement braadCrumb;

    //Click on Add new Contractor
    @FindBy(xpath = "//a[@title='Add New User']")
    WebElement addNewContractor;


    //Initializing the Page Objects by define Constructor:
    public ContractorListPage()
    {
        PageFactory.initElements(driver, this);
    }


    //Actions or Methods on the Contractor Listing Page:
    public String validatePageHeader()
    {
       return pageHeader.getText();
    }

    public boolean validatePageHeaderisDisplay()
    {
        return pageHeader.isDisplayed();
    }

    public AddContractorPage addNewContractorBtn()
    {
        addNewContractor.click();
        return new AddContractorPage();
    }

}
