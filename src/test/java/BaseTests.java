import framework.managers.DriverManager;
import framework.managers.InitManager;
import framework.managers.PageManager;
import framework.managers.TestPropManager;
import framework.utils.MyAllureListener;
import framework.utils.PropsConst;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyAllureListener.class)
public class BaseTests {
    private DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    private TestPropManager propManager = TestPropManager.getInstance();
    @BeforeAll
    public static void beforeClass(){
       InitManager.initFramework();
    }
    @BeforeEach
    public void before() {
        driverManager.getDriver().get(propManager.getProperty(PropsConst.BASE_URL));
    }
    @AfterAll
    public static void after() {
        InitManager.quitFramework();
    }


}
