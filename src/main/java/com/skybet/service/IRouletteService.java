package com.skybet.service;

import com.skybet.service.model.Color;
import com.skybet.service.model.ColorBetResult;
import com.skybet.service.model.SingleBet;
import com.skybet.service.model.SingleBetResult;

public interface IRouletteService
{
    SingleBetResult handleSingleBet(SingleBet singleBet);

    ColorBetResult handleColorBet(Color color);
}
