package com.skybet.service;

import com.skybet.service.model.Color;
import com.skybet.service.model.ColorBetResult;
import com.skybet.service.model.SingleBet;
import com.skybet.service.model.SingleBetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteService implements IRouletteService
{
    private INumberGenerator numberGenerator;
    private IColorProvider colorProvider;

    @Autowired
    public RouletteService(INumberGenerator numberGenerator, IColorProvider colorProvider)
    {
        this.numberGenerator = numberGenerator;
        this.colorProvider = colorProvider;
    }

    @Override
    public SingleBetResult handleSingleBet(SingleBet singleBet)
    {
        Integer bettedNumber = singleBet.getNumber();
        Integer generatedNumber = numberGenerator.generate();

        if (generatedNumber.equals(bettedNumber))
        {
            return new SingleBetResult(true, generatedNumber);
        }

        return new SingleBetResult(false, generatedNumber);
    }

    @Override
    public ColorBetResult handleColorBet(Color colorBet)
    {
        Integer generatedNumber = numberGenerator.generate();

        Color color = getColor(generatedNumber);

        if (color.equals(colorBet))
        {
            return new ColorBetResult(true, color);
        }

        return new ColorBetResult(false, color);
    }

    private Color getColor(Integer number)
    {
        return colorProvider.getColor(number);
    }
}
