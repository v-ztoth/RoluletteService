package com.skybet.service.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class BetResult
{
    private final boolean winner;

    public BetResult(boolean winner)
    {
        this.winner = winner;
    }

    public boolean isWinner()
    {
        return winner;
    }
}
