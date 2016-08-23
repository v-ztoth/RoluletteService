package com.skybet.service;

import com.skybet.service.model.BetResult;
import com.skybet.service.model.SingleBet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouletteService implements IRoluletteService
{
    private INumberGenerator numberGenerator;

    @Autowired
    public RouletteService(INumberGenerator numberGenerator)
    {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public BetResult handleSingleBet(SingleBet singleBet)
    {
        Integer bettedNumber = singleBet.getNumber();
        Integer generatedNumber = numberGenerator.generate();

        if (generatedNumber.equals(bettedNumber))
        {
            return new BetResult(true);
        }

        return new BetResult(false);
    }
}
