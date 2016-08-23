package service;

import com.skybet.service.ColorProvider;
import com.skybet.service.NumberGenerator;
import com.skybet.service.RouletteService;
import com.skybet.service.model.Color;
import com.skybet.service.model.ColorBetResult;
import com.skybet.service.model.SingleBet;
import com.skybet.service.model.SingleBetResult;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@Test(groups = {"unit"})
public class RouletteServiceTest
{
    private SingleBet singleBet;
    private SingleBetResult actualSingleBetResult;
    private SingleBetResult expectedSingleBetResult;
    private Color color;
    private ColorBetResult actualColorBetResult;
    private ColorBetResult expectedColorBetResult;

    @Mock
    private NumberGenerator numberGenerator;

    @Mock
    private ColorProvider colorProvider;

    @InjectMocks
    private RouletteService rouletteService;

    @BeforeMethod
    public void setup()
    {
        singleBet = null;
        actualSingleBetResult = null;
        expectedSingleBetResult = null;
        color = null;
        actualColorBetResult = null;
        expectedColorBetResult = null;

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void singleBetWinnerTest()
    {
        givenASingleBet(15);
        givenAGeneratedNumber(15);
        givenAnExceptedSingleBetResult(true, 15);
        whenHandleSingleBetCalled();
        thenTheSingleBetHandled();
    }

    @Test
    public void singleBetNotWinnerTest()
    {
        givenASingleBet(14);
        givenAGeneratedNumber(15);
        givenAnExceptedSingleBetResult(false, 15);
        whenHandleSingleBetCalled();
        thenTheSingleBetHandled();
    }

    @Test
    public void colorBetWinnerTest()
    {
        givenAColorBet(Color.BLACK);
        givenAColor(Color.BLACK);
        givenAGeneratedNumber(2);
        givenAnExceptedColorBetResult(true, Color.BLACK);
        whenHandleColorBetCalled();
        thenTheColorBetHandled();
    }

    @Test
    public void colorBetNotWinnerTest()
    {
        givenAColorBet(Color.BLACK);
        givenAColor(Color.RED);
        givenAGeneratedNumber(1);
        givenAnExceptedColorBetResult(false, Color.RED);
        whenHandleColorBetCalled();
        thenTheColorBetHandled();
    }

    private void givenASingleBet(Integer number)
    {
        singleBet = new SingleBet(number);
    }

    private void givenAColorBet(Color bet)
    {
        color = bet;
    }

    private void givenAnExceptedSingleBetResult(boolean winner, Integer winnerNumber)
    {
        expectedSingleBetResult = new SingleBetResult(winner, winnerNumber);
    }

    private void givenAnExceptedColorBetResult(boolean winner, Color color)
    {
        expectedColorBetResult = new ColorBetResult(winner, color);
    }

    private void givenAGeneratedNumber(Integer number)
    {
        when(numberGenerator.generate())
                .thenReturn(number);
    }

    private void givenAColor(Color color)
    {
        when(colorProvider.getColor(any(Integer.class)))
                .thenReturn(color);
    }

    private void whenHandleSingleBetCalled()
    {
        actualSingleBetResult = rouletteService.handleSingleBet(singleBet);
    }

    private void whenHandleColorBetCalled()
    {
        actualColorBetResult = rouletteService.handleColorBet(color);
    }

    private void thenTheSingleBetHandled()
    {
        Assert.assertNotNull(actualSingleBetResult, "Result should not be null!");
        Assert.assertEquals(actualSingleBetResult, expectedSingleBetResult, "Result is not the excepted!");
    }

    private void thenTheColorBetHandled()
    {
        Assert.assertNotNull(actualColorBetResult, "Result should not be null!");
        Assert.assertEquals(actualColorBetResult, expectedColorBetResult, "Result is not the excepted!");
    }
}
