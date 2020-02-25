package com.hiberus.uster.service;


import com.hiberus.uster.dto.VehicleDTO;
import com.hiberus.uster.entity.Vehicle;
import com.hiberus.uster.exception.VehicleNotFoundException;
import com.hiberus.uster.repository.TripRepository;
import com.hiberus.uster.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private TripRepository tripRepository;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public List<VehicleDTO> findAll() {
        return vehicleRepository.findAll().stream()
                .map(entity -> new VehicleDTO(entity.getId(), entity.getBranch(), entity.getModel(), entity.getPlate(), entity.getLicense()))
                .collect(Collectors.toList());
    }

    public VehicleDTO findById(Long id) {
        Vehicle vehicle = findOneSafe(id);
        return new VehicleDTO(vehicle.getId(), vehicle.getBranch(), vehicle.getModel(), vehicle.getPlate(), vehicle.getLicense());
    }

    @Transactional
    public VehicleDTO create(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBranch(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setPlate(vehicleDTO.getPlate());
        vehicle.setLicense(vehicleDTO.getLicense());

        Vehicle savedVehicle = vehicleRepository.saveAndFlush(vehicle);
        return new VehicleDTO(savedVehicle.getId(), savedVehicle.getBranch(), savedVehicle.getModel(), savedVehicle.getPlate(), savedVehicle.getLicense());
    }

    @Transactional
    public VehicleDTO update(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = findOneSafe(id);
        vehicle.setBranch(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setPlate(vehicleDTO.getPlate());
        vehicle.setLicense(vehicleDTO.getLicense());
        return new VehicleDTO(vehicle.getId(), vehicle.getBranch(), vehicle.getModel(), vehicle.getPlate(), vehicle.getLicense());
    }

    @Transactional
    public void delete(Long id) {
        Vehicle vehicle = findOneSafe(id);
        vehicleRepository.delete(vehicle);
    }

    private Vehicle findOneSafe(Long id) {
        //return vehicleRepository.findById(id).orElse(new Vehicle()); //25885257-5; 74289223; mariangelica.movistar26@gmail.com
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException());
    }

	public List<VehicleDTO> findAllByDate(String date) {
        /*final LocalDate objDate = LocalDate.parse(date,formatter);

        final List<Vehicle> availableVehicles = vehicleRepository.findAllByTripTripDateIsNot(objDate);
        return availableVehicles.stream()
                .map(entity -> new VehicleDTO(entity.getId(), entity.getBranch(), entity.getModel(), entity.getPlate(), entity.getLicense()))
                .collect(Collectors.toList());*/
return null;

        //vehicleRepository.findAllByDate(objDate);
		
		
		
	}
}
