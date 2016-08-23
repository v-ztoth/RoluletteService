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
        return null;
    }
}
