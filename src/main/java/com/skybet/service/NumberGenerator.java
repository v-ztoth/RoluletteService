package com.skybet.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberGenerator implements INumberGenerator
{
    @Override
    public Integer generate()
    {
        return new Random().nextInt(37);
    }
}
