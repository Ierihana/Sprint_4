import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TopButtonOrderTest extends BaseUITest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String lease;
    private final String scooterColor;

    public TopButtonOrderTest(
            String name , String surname, String address, String metro,
            String phone, String date, String lease, String scooterColor) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.lease = lease;
        this.scooterColor = scooterColor;
    }


    @Parameterized.Parameters
    public static Object[][] getParameters(){
        return new Object[][]{
                {"Олег","Петров","Вернисажная улица, 13","Черкизовская","89212121212", "20.05.2026", "двое суток", "black"},
                {"Анфиса","Васильева","улица Вавилова, 6","Ленинский проспект","89213434343","28.05.2026", "пятеро суток", "grey"}
        };
    }


    @Test
    public void test(){
        mainPage.open();
        mainPage.acceptCookie();
        mainPage.clickTopOrderButton();
        assertTrue(orderPage.isOpened());
        orderPage.fillDeliveryFields(name,surname,address,metro,phone);
        orderPage.clickNextPageButton();
        orderPage.fillLeaseFields(date,lease,scooterColor);
        assertTrue(orderPage.checkingTheOrder());


    }

}
