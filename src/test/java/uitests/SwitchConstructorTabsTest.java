package uitests;

import org.junit.Test;
import pageobject.HomePage;

import static org.junit.Assert.assertEquals;

public class SwitchConstructorTabsTest extends  BaseTest {

    private final String expectedTabClassName = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @Test
    public void checkConstructorTabs() {
        String sauceTub = new HomePage(driver)
                .open()
                .clickSauceTab()
                .getClassNameSauceTub();
        assertEquals("Open wrong tab", sauceTub, expectedTabClassName);

        sauceTub = new HomePage(driver)
                .clickFillingTab()
                .getClassNameFillingTub();
        assertEquals("Open wrong tab", sauceTub, expectedTabClassName);

        sauceTub = new HomePage(driver)
                .clickBunTab()
                .getClassNameBunTub();
        assertEquals("Open wrong tab", sauceTub, expectedTabClassName);
    }
}
