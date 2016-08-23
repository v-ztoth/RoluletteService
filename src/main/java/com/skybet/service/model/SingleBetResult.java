package com.skybet.service.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SingleBetResult extends BetResult
{
    private final Integer winnerNumber;

    public SingleBetResult(boolean winner, Integer winnerNumber)
    {
        super(winner);
        this.winnerNumber = winnerNumber;
    }

    public boolean isWinner()
    {
        return winner;
    }

    public Integer getWinnerNumber()
    {
        return winnerNumber;
    }
}
