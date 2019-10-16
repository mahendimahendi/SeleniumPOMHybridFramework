package com.qa.pages;

import com.qa.base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddContractorPage extends base
{

    //Page Factory - Object Repository using Page Factory

    //Page Elements on the Add Contractor Page
    @FindBy(xpath = "//input[@id='name']")
    WebElement firstLastName;
    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailID;
    @FindBy(xpath = "//input[@id='cno']")
    WebElement contactNo;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='password_confirmation']")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@id='cname']")
    WebElement companyName;
    @FindBy(xpath = "//textarea[@id='detail']")
    WebElement companyDetail;
    @FindBy(xpath = "//select[@id='experience']")
    WebElement experience;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    WebElement createBtn;
    @FindBy(xpath = "//a[contains(@class,'btn btn-secondary')]")
    WebElement cancelBtn;


    //Initializing the Page Objects by define Constructor:
    public AddContractorPage()
    {
        PageFactory.initElements(driver, this);
    }


    //Actions or Methods on the Contractor Listing Page:
    public void addNewContractor(String flname, String usName,String email, String contNo, String passwd, String cpasswd, String cname, String cDetail, String exp)
    {

        Select select = new Select(driver.findElement(By.xpath("experience")));
        select.selectByVisibleText(String.valueOf(experience));

        firstLastName.sendKeys(flname);
        userName.sendKeys(usName);
        emailID.sendKeys(email);
        contactNo.sendKeys(contNo);
        password.sendKeys(passwd);
        confirmPassword.sendKeys(cpasswd);
        companyName.sendKeys(cname);
        companyDetail.sendKeys(cDetail);

        createBtn.click();

    }

}
