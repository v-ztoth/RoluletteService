package com.skybet.api;

import com.skybet.service.model.BetResult;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class RouletteController
{
    private static final Logger LOGGER = Logger.getLogger(RouletteController.class);

    @RequestMapping(value = "/single", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BetResult> handleSingleBet(Integer number)
    {
        return new ResponseEntity<>(new BetResult(), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception)
    {
        LOGGER.error(exception);

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
