package com.hiberus.uster.controller;

import com.hiberus.uster.dto.VehicleDTO;
import com.hiberus.uster.dto.MessageDTO;
import com.hiberus.uster.exception.ResourceNotFoundException;
import com.hiberus.uster.service.VehicleService;

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
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private MessageSource messageSource;

    //@GetMapping("/vehicles")
    @RequestMapping(value = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE, method =  RequestMethod.GET)
    public List<VehicleDTO> getAllVehicles(VehicleDTO vehicleDTO) {
        return vehicleService.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public VehicleDTO getVehicleById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return vehicleService.findById(id);
    }
    /*@GetMapping("/vehicles/filter/byDate/{date}")
    public List<VehicleDTO> getVehiclesByDate(@PathVariable(value = "date") String date) {
    	return vehicleService.findAllByDate(date);
    }*/

    @PostMapping("/vehicles/add")
    public VehicleDTO addVehicle(@Valid @RequestBody VehicleDTO vehicle) {
        return vehicleService.create(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public VehicleDTO updateVehicle(@PathVariable(value = "id") Long id, @Valid @RequestBody VehicleDTO vehicleDTO) throws ResourceNotFoundException {
        return vehicleService.update(id, vehicleDTO);
    }

    //@DeleteMapping("/vehicles/{id}")
    @RequestMapping(value = "/vehicles/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        vehicleService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new MessageDTO(messageSource.getMessage(code, null, locale));
    }
}
