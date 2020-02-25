package com.hiberus.uster.service;

import com.hiberus.uster.dto.TripDTO;
import com.hiberus.uster.entity.Trip;
import com.hiberus.uster.exception.TripNotFoundException;
import com.hiberus.uster.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<TripDTO> findAll() {
        return tripRepository.findAll().stream()
                .map(entity -> new TripDTO(entity.getId(), entity.getTripDate(), 
                		entity.getDriverId(), entity.getDriverName(), entity.getDriverSurname(), entity.getDriverLicense(), 
                		entity.getVehicleId(), entity.getVehicleBranch(), entity.getVehicleModel(), entity.getVehiclePlate(), entity.getVehicleLicense()))
                .collect(Collectors.toList());
    }

    public TripDTO findById(Long id) {
        Trip trip = findOneSafe(id);
        return new TripDTO(trip.getId(), trip.getTripDate(), 
        		trip.getDriverId(), trip.getDriverName(), trip.getDriverSurname(), trip.getDriverLicense(),
        		trip.getVehicleId(), trip.getVehicleBranch(), trip.getVehicleModel(), trip.getVehiclePlate(), trip.getVehicleLicense());
    }

    @Transactional
    public TripDTO create(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setTripDate(tripDTO.getTripDate());
        trip.setDriverId(tripDTO.getDriverId());
        trip.setDriverName(tripDTO.getDriverName());
        trip.setDriverSurname(tripDTO.getDriverSurname());
        trip.setDriverLicense(tripDTO.getDriverLicense());
        trip.setVehicleId(tripDTO.getVehicleId());
        trip.setVehicleBranch(tripDTO.getVehicleBranch());
        trip.setVehicleModel(tripDTO.getVehicleModel());
        trip.setVehiclePlate(tripDTO.getVehiclePlate());
        trip.setVehicleLicense(tripDTO.getVehicleLicense());

        Trip savedTrip = tripRepository.saveAndFlush(trip);
        return new TripDTO(savedTrip.getId(), savedTrip.getTripDate(), 
        		savedTrip.getDriverId(), savedTrip.getDriverName(), savedTrip.getDriverSurname(), savedTrip.getDriverLicense(),
        		savedTrip.getVehicleId(), savedTrip.getVehicleBranch(), savedTrip.getVehicleModel(), savedTrip.getVehiclePlate(), savedTrip.getVehicleLicense());
    }

    @Transactional
    public TripDTO update(Long id, TripDTO tripDTO) {
        Trip trip = findOneSafe(id);
        trip.setTripDate(tripDTO.getTripDate());
        trip.setDriverId(tripDTO.getDriverId());
        trip.setDriverName(tripDTO.getDriverName());
        trip.setDriverSurname(tripDTO.getDriverSurname());
        trip.setDriverLicense(tripDTO.getDriverLicense());
        trip.setVehicleId(tripDTO.getVehicleId());
        trip.setVehicleBranch(tripDTO.getVehicleBranch());
        trip.setVehicleModel(tripDTO.getVehicleModel());
        trip.setVehiclePlate(tripDTO.getVehiclePlate());
        trip.setVehicleLicense(tripDTO.getVehicleLicense());
        return new TripDTO(trip.getId(), trip.getTripDate(), 
        		trip.getDriverId(), trip.getDriverName(), trip.getDriverSurname(), trip.getDriverLicense(),
        		trip.getVehicleId(), trip.getVehicleBranch(), trip.getVehicleModel(), trip.getVehiclePlate(), trip.getVehicleLicense());
    }

    @Transactional
    public void delete(Long id) {
        Trip trip = findOneSafe(id);
        tripRepository.delete(trip);
    }

    private Trip findOneSafe(Long id) {
        //return tripRepository.findById(id).orElse(new Trip());
        return tripRepository.findById(id)
                .orElseThrow(() -> new TripNotFoundException());
    }
}
