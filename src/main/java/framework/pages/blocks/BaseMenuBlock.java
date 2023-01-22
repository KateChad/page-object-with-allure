package framework.pages.blocks;

import framework.pages.BasePage;
import framework.pages.MortgagePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BaseMenuBlock extends BasePage{
    @FindBy(xpath = ".//button[@class='kitt-cookie-warning__close']")
    WebElement closeCookie;
    @FindBy(xpath = ".//nav[@aria-label='Основное меню']")
    WebElement mainMenu;
    @FindBy(xpath = ".//a[contains(@class,' kitt-top-menu__link_first kitt-top-menu__link_icons')]")
    List<WebElement> listOfIcon;
    @FindBy(xpath = ".//li/a[contains(@class,'menu__link_second')]")
    List<WebElement> listOfSecondMenu;

    public BaseMenuBlock closeCookie() {
        waitUntilElementToBeClicable(closeCookie).click();
        return this;
    }

    public BaseMenuBlock checkMainMenu() {
        Assertions.assertTrue(waitUntilElementToBeVisible(mainMenu).isDisplayed(),"Гланая старничка не открылась");
        return this;
    }

    public BaseMenuBlock findElementOfBaseMenu(String nameOfElement) {
          for (WebElement icon: listOfIcon) {
            if (icon.getText().contains(nameOfElement)){
                waitUntilElementToBeClicable(icon).click();
                Assertions.assertTrue(waitUntilElementToBeVisible(icon
                        .findElement(By.xpath("./..//a[contains(@aria-label,'Закрыть меню')]")))
                        .isDisplayed(),"Меню иконки не открылось");
                return this;
            }
        }
        Assertions.fail("Элемент из базового меню не найден");
        return this;
    }

    public MortgagePage findElementOfSecondBaseMenu(String nameOfElementSecond) {

        for (WebElement element: listOfSecondMenu) {
            if (element.getText().contains(nameOfElementSecond)){
                waitUntilElementToBeClicable(element).click();
                return pageManager.getMortgagePage();
            }
        }
        Assertions.fail("Элемент из подменю не найден");
        return pageManager.getMortgagePage();
    }

}
