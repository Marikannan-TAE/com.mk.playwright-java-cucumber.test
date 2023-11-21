package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings()
    {
        ConfigReader reader = new ConfigReader();
        try {
            reader.ReadProperty();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void ReadProperty() throws IOException {
        Properties p = new Properties();
        InputStream inputStream = new FileInputStream("src/test/java/config/GlobalConfig.properties");
        p.load(inputStream);

        Settings.BrowserName = p.getProperty("BrowserName");
        Settings.Headless = Boolean.getBoolean(p.getProperty("Headless"));
        Settings.SetChannel = p.getProperty("SetChannel");
    }


}
