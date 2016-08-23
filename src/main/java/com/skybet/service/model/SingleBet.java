package com.skybet.service.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SingleBet
{
    private final Integer number;

    public SingleBet(Integer number)
    {
        this.number = number;
    }

    public Integer getNumber()
    {
        return number;
    }
}
