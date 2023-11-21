package steps;

import base.FrameworkConfig;
import base.FrameworkIntialize;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    @Before
    public void Setup()
    {
        ConfigReader.PopulateSettings();
        FrameworkConfig.LocalPage=new FrameworkIntialize().IntializePlaywright();
    }

    @After
    public void cleanup() throws Exception
    {
        FrameworkConfig.LocalPage.close();
        // FrameworkConfig.Browser.close();
        FrameworkConfig.Playwright.close();
    }
}
