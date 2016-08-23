package com.skybet.api.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SingleBet
{
    @NotNull(message = "The number you are betting cannot be null")
    @Min(value = 0, message = "Number parameter cannot be less than 0")
    @Max(value = 36, message = "Number parameter cannot be greater than 36")
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
