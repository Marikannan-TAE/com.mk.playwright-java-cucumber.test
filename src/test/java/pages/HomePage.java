package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class HomePage {

    Page page = FrameworkConfig.LocalPage;

    String lnkLogin = "#loginLink";
    String lnkEmployee = "text='Employee List'";
    String btnCreateNew = "text='Create New'";
    String lnkLogoff = "text='Log off'";
    String btnDelete = "input[type=\"submit\"]";

    public LoginPage ClickLogin() {
        page.click(lnkLogin);
        return new LoginPage();
    }

    public CreateUserPage ClickEmployeeList() {page.click(lnkEmployee);
        return new CreateUserPage();
    }

    public CreateUserPage ClickCreateNew() {
        page.click(btnCreateNew);
        return new CreateUserPage();
    }

    public void ClickLogoff() {page.click(lnkLogoff);
    }

    public void DeleteCreateduser(String userName)
    {
        String locator = String.format("//td[normalize-space(.)='%s']/parent::tr//td/a[normalize-space(.)='Delete']",userName);    /* //td[normalize-space(.)='%s']/parent::tr//td[normalize-space(.)='Delete']*/

        page.click(locator);
        page.click(btnDelete);
    }
}
