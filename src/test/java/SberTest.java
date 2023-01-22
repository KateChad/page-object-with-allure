import org.junit.jupiter.api.Test;

public class SberTest extends BaseTests {
    @Test
    public void sberTest() {
        pageManager.getStartPage()
                .getBaseMenuBlock()
                .closeCookie()
                .checkMainMenu()
                .findElementOfBaseMenu("Ипотека")
                .findElementOfSecondBaseMenu("Ипотека на вторичное жильё")
                .checkPage()
                .goToFormPage()
                .findForm("Стоимость недвижимости","5180000")
                .findForm("Первоначальный взнос", "3058000")
                .findForm("Срок кредита","30")
                .findCheckbox("Страхование жизни и здоровья")
                .checkParameters("Ежемесячный платеж", "21664")
                .checkParameters("Сумма кредита","2122000")
                .checkRequiredIncome("36829")
                .checkParameters("Процентная ставка","11");
    }
}
