package com.skybet.service.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ColorBetResult extends BetResult
{
    private final Color winnerColor;

    public ColorBetResult(boolean winner, Color winnerColor)
    {
        super(winner);
        this.winnerColor = winnerColor;
    }

    public Color getWinnerColor()
    {
        return winnerColor;
    }
}
