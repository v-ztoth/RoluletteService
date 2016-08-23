package com.skybet.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SingleBet
{
    @NotNull(message = "The number you are betting cannot be null")
    @Size(min = 0, max = 36, message = "The number you are betting has to be in the range 0 - 36")
    private Integer number;

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }
}
