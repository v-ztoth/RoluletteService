package com.skybet.service.model;

public class BetResult
{
    protected final boolean winner;

    public BetResult(boolean winner)
    {
        this.winner = winner;
    }

    public boolean isWinner()
    {
        return winner;
    }
}
