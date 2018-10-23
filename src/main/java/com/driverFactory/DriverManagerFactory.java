package com.driverFactory;

import com.driverFactory.ChromeDriverManager;
import com.driverFactory.DriverManager;
import com.driverFactory.FirefoxDriverManager;
import com.driverFactory.SafariDriverManager;

public class DriverManagerFactory {
	
	public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new SafariDriverManager();
                break;
        }
        return driverManager;

    }
	
	public enum DriverType {
	    CHROME,
	    FIREFOX,
	    IE,
	    SAFARI;
	}

}
