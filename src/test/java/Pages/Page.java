package Pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;
import static support.TestContext.initialize;

public class Page {

    protected String url;

    public Page(){
        //initialize();  // can initialize browser here also by default
        PageFactory.initElements(getDriver(),this);
    }

    public void open(){
        //initialize();  // can initialize browser here also by default
        getDriver().get(url);
    }
}
