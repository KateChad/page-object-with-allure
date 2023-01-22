package framework.managers;

import framework.pages.FormPage;
import framework.pages.MortgagePage;
import framework.pages.StartPage;

public class PageManager {
    private static PageManager INSTANCE = null;
    private StartPage startPage;
    private MortgagePage mortgagePage;
    private FormPage formPage;

    private PageManager() {

    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }

    public FormPage getFormPage() {
        if (formPage == null) {
            formPage = new FormPage();
        }
        return formPage;
    }

}
