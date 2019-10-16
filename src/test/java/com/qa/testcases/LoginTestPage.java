package com.qa.testcases;

import com.qa.base.base;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestPage extends base
{

    LoginPage loginpage;
    DashboardPage dashboardPage;

    public LoginTestPage()
    {
        super();
    }


    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginpage = new LoginPage();

    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }

    @Test(priority = 1)
    public void loginPageTitleTest()
    {
        String title = loginpage.validatePageTitle();
        Assert.assertEquals(title, "Starkforce Admin");

    }

    @Test(priority = 2)
    public void logoImageTest()
    {
       boolean flag = loginpage.validateLogoImage();
       Assert.assertTrue(flag);
    }


    @Test(priority = 3)
    public void loginTest()
    {
        dashboardPage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

    }



}
