package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import config.Settings;

public class FrameworkIntialize {
    public Page IntializePlaywright() {

        //Intialize the Browser
        BrowserIntialize browserIntialize = new BrowserIntialize();

        //Set the Launchoptions
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = Settings.Headless;
        launchOptions.setChannel(Settings.SetChannel);


        //Get Browser
        var browser = browserIntialize.GetBrowser(Settings.BrowserName, launchOptions);

        //Get BrowserContext
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        //contextOptions.locale = "en/US";
        contextOptions.setBaseURL("https://www.amazon.com");

        var context = browserIntialize.GetBrowserContext(browser,contextOptions);

        //Get Page
        return browserIntialize.GetPage(context);
    }
}
