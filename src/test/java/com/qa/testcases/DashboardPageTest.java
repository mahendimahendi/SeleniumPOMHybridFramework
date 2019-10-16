package com.qa.testcases;

import com.qa.base.base;
import com.qa.pages.ContractorListPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends base
{
    LoginPage loginpage;
    DashboardPage dashboardPage;
    ContractorListPage contractorListPage;

    public DashboardPageTest()
    {
        super();
    }

    //Best Practice to Follow as Below
        //Testcase should be Separated - Independent with each other
        //Then execute the @Test
        //After each test case "Close the Browser"

    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginpage = new LoginPage();
        contractorListPage = new ContractorListPage();
        dashboardPage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }

    @Test(priority = 1)
    public void verifyDashboardPageTitleTest()
    {
        String dashboardTitle = dashboardPage.validateDashboardPageTitle();
        Assert.assertEquals(dashboardTitle,"Starkforce Admin");

    }

    @Test(priority = 2)
    public void verifyUserEmailIDTest()
    {
        String EmailID = dashboardPage.validateEmailID();
        Assert.assertEquals(EmailID,"admin@starkforce.com");
    }

    @Test(priority = 3)
    public void verifyClickOnContractorLink()
    {
        dashboardPage.clickOnUserManagementLink();
        contractorListPage = dashboardPage.clickOnContractorMenuLink();
    }


}
