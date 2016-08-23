package service;

import com.skybet.service.ColorProvider;
import com.skybet.service.model.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {"unit"})
public class ColorProviderTest
{
    private ColorProvider colorProvider;
    private Color color;

    @BeforeMethod
    public void setup()
    {
        colorProvider = null;
        color = null;
    }

    @DataProvider(name = "getColorDataProvider")
    public static Object[][] numbersAndColors() {
        return new Object[][] {
                {0, Color.GREEN},
                {1, Color.RED},
                {2, Color.BLACK},
                {19, Color.RED},
                {20, Color.BLACK},
                {11, Color.BLACK},
                {12, Color.RED},
                {29, Color.BLACK},
                {30, Color.RED}
        };
    }

    @Test(dataProvider = "getColorDataProvider")
    public void getColorTest(Integer number, Color exceptedColor)
    {
        givenAColorProvider();
        whenGetColorCalled(number);
        thenTheRightColorReturned(exceptedColor);
    }

    private void givenAColorProvider()
    {
        colorProvider = new ColorProvider();
    }

    private void whenGetColorCalled(Integer number)
    {
        color = colorProvider.getColor(number);
    }

    private void thenTheRightColorReturned(Color exceptedColor)
    {
        Assert.assertEquals(color, exceptedColor);
    }
}
