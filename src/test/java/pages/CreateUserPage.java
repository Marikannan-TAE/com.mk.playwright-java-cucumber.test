package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class CreateUserPage {
    Page page = FrameworkConfig.LocalPage;

    String txtName = "input[name=\"Name\"]";
    String txtSalary = "input[name=\"Salary\"]";
    String txtDuration = "input[name=\"DurationWorked\"]";
    String txtGrade = "input[name=\"Grade\"]";
    String txtEmail = "#Email";
    String btnCreate = "input[type=\"submit\"]";

    public HomePage CreateUser(String name, String Salary, String Duration,String Grade, String Email)
    {
        page.fill(txtName,name);
        page.fill(txtSalary, Salary);
        page.fill(txtDuration, Duration);
        page.fill(txtGrade, Grade);
        page.fill(txtEmail,Email);

        page.click(btnCreate);
        return new HomePage();
    }

}
