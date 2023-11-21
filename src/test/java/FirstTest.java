import base.FrameworkConfig;
import base.FrameworkIntialize;
import com.microsoft.playwright.*;
import config.ConfigReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class FirstTest {

    @BeforeTest
    public void setupPlaywright()
    {
        ConfigReader.PopulateSettings();
        FrameworkConfig.LocalPage=new FrameworkIntialize().IntializePlaywright();
    }

    @Test
    public void testNavigation()
    {
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com/");
    }

  @Test
    public void testLogin()
    {
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com/");
        HomePage homePage=new HomePage();
        homePage.ClickLogin();

       // LoginPage loginPage = new LoginPage();
        var loginPage = homePage.ClickLogin();
        homePage = loginPage.Login("admin","password");
        homePage.ClickEmployeeList();

        //Create new user

        var createUserPage = homePage.ClickCreateNew();
        homePage = createUserPage.CreateUser("AutoTestusr1","10000","45","2","testemail@gmail.com");
        //Delete created user
        homePage.DeleteCreateduser("AutoTestusr1");

        homePage.ClickLogoff();
    }

    @Test
    public void tesCreateAndDeleteuser()
    {
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com/");
        HomePage homePage=new HomePage();
        homePage.ClickLogin();

        // LoginPage loginPage = new LoginPage();
        var loginPage = homePage.ClickLogin();
        homePage = loginPage.Login("admin","password");
        homePage.ClickEmployeeList();

        //Create new user

        var createUserPage = homePage.ClickCreateNew();
        homePage = createUserPage.CreateUser("mkAutoTestusr2","10001","40","3","testemail2@test.com");
        //Delete created user
        homePage.DeleteCreateduser("mkAutoTestusr2");
        //logg off
        homePage.ClickLogoff();
    }

    @AfterTest
    public void cleanup() throws Exception
    {
        FrameworkConfig.LocalPage.close();
       // FrameworkConfig.Browser.close();
        FrameworkConfig.Playwright.close();
    }

}
