package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormPage extends BasePage{
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();
    @FindBy(xpath = ".//input[contains(@class,'inpt-root')]")
    List<WebElement> listOfFormFields;
    @FindBy(xpath = ".//div[contains(@class,'styles_togglerWrap__BhLEJ')]")
    List<WebElement> listOfCheckbox;
    @FindBy(xpath = ".//div[contains(@class,'styles_calculationMediumScreen__v5qRd')]//span[@class='style_label__egHS1']")
    List<WebElement> listOfPrise;
    @FindBy(xpath = ".//div[@class='styles_value__8Inxn']/span[contains(@class,'styles_value__8Inxn')]/span")
    WebElement requiredIncome;
    public FormPage findForm(String nameOfForm, String parametersToFill){
        for (WebElement form : listOfFormFields) {
            if (form.findElement(By.xpath("./..//label")).getText().contains(nameOfForm)){
                waitUntilElementToBeClicable(form).sendKeys(parametersToFill);
                Assertions.assertEquals(parametersToFill,form.getAttribute("value").replaceAll("[^0-9]", ""),
                        "Поле зполнилось не корректно");
                return this;
            }
        }
        Assertions.fail("Форма не найдена");
        return this;
    }

    public FormPage findCheckbox(String nameOfCheckbox){
        for (WebElement form : listOfCheckbox) {
            scrollToElementJs(form);
            if (form.findElement(By.xpath("./span")).getText().contains(nameOfCheckbox)){
                waitUntilElementToBeClicable(form.findElement(By.xpath(".//input"))).click();
                return this;
            }
        }
        Assertions.fail("Checkbox не найден");
        return this;
    }

    public FormPage checkParameters(String nameOfParameter, String meaning){
        for (WebElement parameter : listOfPrise) {
            if (parameter.getText().contains(nameOfParameter)){
                String parameterInString = parameter
                        .findElement(By.xpath("./..//span[contains(@class,'styles_value__8Inxn')]/span")).getText()
                        .replaceAll("[^0-9.,]", "");
                Assertions.assertEquals(meaning, parameterInString,
                        "Параметр " + nameOfParameter + " не верный");
                return this;
            }
        }
        Assertions.fail("Параметр не найден");
        return this;
    }

    public FormPage checkRequiredIncome(String meaning){
                String requiredIncomeInString = requiredIncome.getText()
                        .replaceAll("[^0-9]", "");
                Assertions.assertEquals(meaning, requiredIncomeInString,
                        "Необходимый доход не верный");
                return this;
    }

    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }
}
