package com.skybet.api.model;

import javax.validation.constraints.Pattern;

public class ColorBet
{
    @Pattern(regexp = "red|black|green", flags = Pattern.Flag.CASE_INSENSITIVE,
             message = "color parameter is invalid. Valid values are red, black or green")
    private String color;

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
}
