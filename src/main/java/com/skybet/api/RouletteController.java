package com.skybet.api;

import com.skybet.api.model.ColorBet;
import com.skybet.api.model.SingleBet;
import com.skybet.service.IRouletteService;
import com.skybet.service.model.Color;
import com.skybet.service.model.ColorBetResult;
import com.skybet.service.model.SingleBetResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bet")
public class RouletteController
{
    private static final Logger LOGGER = Logger.getLogger(RouletteController.class);

    private IRouletteService rouletteService;

    @Autowired
    public RouletteController(IRouletteService rouletteService)
    {
        this.rouletteService = rouletteService;
    }

    @RequestMapping(value = "/single", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SingleBetResult> handleSingleBet(@Valid SingleBet singleBet)
    {
        com.skybet.service.model.SingleBet domainSingleBet = new com.skybet.service.model.SingleBet(
                singleBet.getNumber());

        SingleBetResult singleBetResult = rouletteService.handleSingleBet(domainSingleBet);

        return new ResponseEntity<>(singleBetResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/color", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ColorBetResult> handleColorBet(@Valid ColorBet colorBet)
    {
        Color domainColor = Color
                .valueOf(colorBet.getColor().toUpperCase());

        ColorBetResult colorBetResult = rouletteService.handleColorBet(domainColor);

        return new ResponseEntity<>(colorBetResult, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception)
    {
        LOGGER.error(exception);

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
