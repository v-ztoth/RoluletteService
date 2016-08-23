package com.skybet.service;

import com.skybet.service.model.Color;
import org.springframework.stereotype.Component;

@Component
public class ColorProvider implements IColorProvider
{
    @Override
    public Color getColor(Integer number)
    {
        if (number.equals(0))
        {
            return  Color.GREEN;
        }
        else if (isNumberInRange1To10(number) && isNumberEven(number))
        {
            return Color.BLACK;
        }
        else if (isNumberInRange1To10(number) && !isNumberEven(number))
        {
            return Color.RED;
        }
        else if (isNumberInRange19To28(number) && isNumberEven(number))
        {
            return Color.BLACK;
        }
        else if (isNumberInRange19To28(number) && !isNumberEven(number))
        {
            return Color.RED;
        }
        else if (isNumberInRange11To18(number) && isNumberEven(number))
        {
            return Color.RED;
        }
        else if (isNumberInRange11To18(number) && !isNumberEven(number))
        {
            return Color.BLACK;
        }
        else if (isNumberInRange29To36(number) && isNumberEven(number))
        {
            return Color.RED;
        }
        else
        {
            return Color.BLACK;
        }
    }

    private boolean isNumberEven(Integer number)
    {
        return ((number % 2) == 0);
    }

    private boolean isNumberInRange1To10(Integer number)
    {
        return number >= 1 && number <= 10;
    }

    private boolean isNumberInRange11To18(Integer number)
    {
        return number >= 11 && number <= 18;
    }

    private boolean isNumberInRange19To28(Integer number)
    {
        return number >= 19 && number <= 28;
    }

    private boolean isNumberInRange29To36(Integer number)
    {
        return number >= 29 && number <= 36;
    }
}
