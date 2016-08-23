package com.skybet.service;

import com.skybet.service.model.BetResult;
import com.skybet.service.model.SingleBet;

public interface IRouletteService
{
    BetResult handleSingleBet(SingleBet singleBet);
}
