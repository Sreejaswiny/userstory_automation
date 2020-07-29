import Pages.TestingWorldRegPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static support1.TestContext.getDriver;
import static support1.TestContext.initialize;

public class TestingWorldRegisterationTest {

    @Before
    public void setup(){
        initialize();
        new TestingWorldRegPage().open();
    }

    @Test
    public void registerationTest() throws InterruptedException {
        new TestingWorldRegPage().fillRegisterationDetails();
        new TestingWorldRegPage().selectHomeRadioButton();
        new TestingWorldRegPage().selectGender();
        new TestingWorldRegPage().selectCountry();
        new TestingWorldRegPage().selectState();
        new TestingWorldRegPage().selectCity();
        new TestingWorldRegPage().zipcode();
        new TestingWorldRegPage().selectCheckbox();
        System.out.println("Testing world Page");
    }

    @After
    public void tearDown(){
        getDriver().quit();
    }
}
