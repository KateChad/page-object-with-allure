package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MortgagePage extends BasePage{
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();

    @FindBy(xpath = ".//div[contains(@class,'product-teaser-full-width__image_md')]")
    WebElement firstBlock;
    @FindBy(xpath = ".//a[contains(@class,'kit-button_type_big analytics-button')]")
    WebElement clockGoToFormPage;


    public MortgagePage checkPage(){
        Assertions.assertTrue(waitUntilElementToBeVisible(firstBlock).isDisplayed(), "Страничка ипотеки не прогрузилась");
        return this;
    }

    public FormPage goToFormPage(){
        waitUntilElementToBeClicable(clockGoToFormPage).click();
        return pageManager.getFormPage();
    }



    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }
}
