package com.skybet.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGenerator implements INumberGenerator
{
    @Override
    public Integer generate()
    {
        return new Random().nextInt(37);
    }
}
