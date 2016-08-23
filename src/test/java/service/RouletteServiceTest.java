package service;

import com.skybet.service.NumberGenerator;
import com.skybet.service.RouletteService;
import com.skybet.service.model.BetResult;
import com.skybet.service.model.SingleBet;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

@Test(groups = {"unit"})
public class RouletteServiceTest
{
    private SingleBet singleBet;
    private BetResult actualBetResult;
    private BetResult exceptedBetResult;

    @Mock
    private NumberGenerator numberGenerator;

    @InjectMocks
    private RouletteService rouletteService;

    @BeforeMethod
    public void setup()
    {
        singleBet = null;
        actualBetResult = null;
        exceptedBetResult = null;

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void singleBetTest()
    {
        givenASingleBet(15);
        givenAGeneratedNumber(15);
        givenAnExceptedBetResult(true);
        whenHandleSingleBetCalled();
        thenTheSingleBetHandled();
    }

    private void givenASingleBet(Integer number)
    {
        singleBet = new SingleBet(number);
    }

    private void givenAnExceptedBetResult(boolean winner)
    {
        exceptedBetResult = new BetResult(winner);
    }

    private void givenAGeneratedNumber(Integer number)
    {
        when(numberGenerator.generate())
                .thenReturn(number);
    }

    private void whenHandleSingleBetCalled()
    {
        actualBetResult = rouletteService.handleSingleBet(singleBet);
    }

    private void thenTheSingleBetHandled()
    {
        Assert.assertNotNull(actualBetResult, "Result should not be null!");
        Assert.assertEquals(actualBetResult, exceptedBetResult, "Result is not the excepted!");
    }
}
