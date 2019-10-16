package com.qa.testcases;

import com.qa.base.base;
import com.qa.pages.AddContractorPage;
import com.qa.pages.ContractorListPage;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddContractorPageTest extends base
{
    LoginPage loginpage;
    DashboardPage dashboardPage;
    ContractorListPage contractorListPage;
    AddContractorPage addcontractorpage;
    String sheetName = "addContractor";

    public AddContractorPageTest()
    {
        super();
    }

   @BeforeMethod
    public void setUp()
    {
        initialization();
        loginpage = new LoginPage();
        dashboardPage = new DashboardPage();
        contractorListPage = new ContractorListPage();
        addcontractorpage = new AddContractorPage();

        dashboardPage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage.clickOnUserManagementLink();
        dashboardPage.clickOnContractorMenuLink();
        contractorListPage.addNewContractorBtn();

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }


    @DataProvider
    public Object[][] getContractorTestData()
    {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }


    @Test(dataProvider = "getContractorTestData")
    public void validateCreateNewContractor(String flname, String usName,String email, String contNo, String passwd, String cpasswd, String cname, String cDetail, String exp)
    {
        addcontractorpage.addNewContractor(flname,usName,email,contNo,passwd,cpasswd,cname,cDetail,exp);
    }

}
