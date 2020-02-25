package com.hiberus.uster.controller;

import com.hiberus.uster.dto.TripDTO;
import com.hiberus.uster.dto.MessageDTO;
import com.hiberus.uster.exception.ResourceNotFoundException;
import com.hiberus.uster.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1")
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/trips")
    //@RequestMapping(value = "/trips",  method =  RequestMethod.GET)
    public List<TripDTO> getAllTrips(TripDTO tripDTO) {
        return tripService.findAll();
    }

    @GetMapping("/trips/{id}")
    public TripDTO getTripById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return tripService.findById(id);
    }

    @PostMapping("/trips/add")
    public TripDTO addTrip(@Valid @RequestBody TripDTO trip) {
        return tripService.create(trip);
    }

    @PutMapping("/trips/{id}")
    public TripDTO updateTrip(@PathVariable(value = "id") Long id, @Valid @RequestBody TripDTO tripDTO) throws ResourceNotFoundException {
        return tripService.update(id, tripDTO);
    }

    //@DeleteMapping("/trips/{id}")
    @RequestMapping(value = "/trips/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.DELETE)
    public void deleteTrip(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        tripService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new MessageDTO(messageSource.getMessage(code, null, locale));
    }
}
