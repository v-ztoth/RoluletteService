package service;

import com.skybet.service.NumberGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"unit"})
public class NumberGeneratorTest
{
    private NumberGenerator numberGenerator;
    private Integer result;

    @BeforeMethod
    public void setup()
    {
        numberGenerator = null;
        result = null;
    }

    @Test
    public void generateTest()
    {
        givenANumberGenerator();
        whenGenerateCalled();
        thenAValidNumberGenerated();
    }

    private void givenANumberGenerator()
    {
        numberGenerator = new NumberGenerator();
    }

    private void whenGenerateCalled()
    {
        result = numberGenerator.generate();
    }

    private void thenAValidNumberGenerated()
    {
        Assert.assertNotNull(result, "Result should not be null!");
        Assert.assertTrue(result >= 0, "Result should be equal or greater than zero");
        Assert.assertTrue(result <=36, "Result should be equal or less than 36");
    }
}
