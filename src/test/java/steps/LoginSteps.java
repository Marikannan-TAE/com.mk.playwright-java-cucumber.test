package steps;

import base.FrameworkConfig;
import base.FrameworkIntialize;
import config.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    HomePage homePage=new HomePage();
    LoginPage loginPage = new LoginPage();


    @Given("I navigate to the application")
    public void iNavigateToTheApplication() {

        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com/");
    }

    @And("I click Login link")
    public void iClickLoginLink() {
        loginPage = homePage.ClickLogin();
    }

    @And("I enter following login details")
    public void iEnterFollowingLoginDetails(DataTable loginData) {
        homePage = loginPage.Login(loginData.cell(1,0),loginData.cell(1,1));
        homePage.ClickEmployeeList();
    }

    @Then("I click Log off")
    public void iClickLogOff() {
        homePage.ClickLogoff();
    }
}
