package com.hiberus.uster.controller;

import com.hiberus.uster.dto.DriverDTO;
import com.hiberus.uster.dto.MessageDTO;
import com.hiberus.uster.exception.ResourceNotFoundException;
import com.hiberus.uster.service.DriverService;

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
public class DriverController {

    @Autowired
    private DriverService driverService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/drivers")
    //@RequestMapping(value = "/drivers",  method =  RequestMethod.GET)
    public List<DriverDTO> getAllDrivers(DriverDTO driverDTO) {
        return driverService.findAll();
    }

    @GetMapping("/drivers/{id}")
    public DriverDTO getDriverById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return driverService.findById(id);
    }

    @PostMapping("/drivers/add")
    public DriverDTO addDriver(@Valid @RequestBody DriverDTO driver) {
        return driverService.create(driver);
    }

    @PutMapping("/drivers/{id}")
    public DriverDTO updateDriver(@PathVariable(value = "id") Long id, @Valid @RequestBody DriverDTO driverDTO) throws ResourceNotFoundException {
        return driverService.update(id, driverDTO);
    }

    //@DeleteMapping("/drivers/{id}")
    @RequestMapping(value = "/drivers/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        driverService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new MessageDTO(messageSource.getMessage(code, null, locale));
    }
}
