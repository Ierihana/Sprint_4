import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BottomButtonOrderTest extends BaseUITest{

    @Test
    public void test(){
        mainPage.open();
        mainPage.acceptCookie();
        mainPage.clickBottomOrderButton();
        assertEquals(true, orderPage.isOpened());
    }
}
