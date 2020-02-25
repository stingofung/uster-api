package com.hiberus.uster.service;

import com.hiberus.uster.dto.DriverDTO;
import com.hiberus.uster.entity.Driver;
import com.hiberus.uster.exception.DriverNotFoundException;
import com.hiberus.uster.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<DriverDTO> findAll() {
        return driverRepository.findAll().stream()
                .map(entity -> new DriverDTO(entity.getId(), entity.getName(), entity.getSurName(), entity.getLicense()))
                .collect(Collectors.toList());
    }

    public DriverDTO findById(Long id) {
        Driver driver = findOneSafe(id);
        return new DriverDTO(driver.getId(), driver.getName(), driver.getSurName(), driver.getLicense());
    }

    @Transactional
    public DriverDTO create(DriverDTO driverDTO) {
        Driver driver = new Driver();
        driver.setName(driverDTO.getName());
        driver.setSurName(driverDTO.getSurName());
        driver.setLicense(driverDTO.getLicense());

        Driver savedDriver = driverRepository.saveAndFlush(driver);
        return new DriverDTO(savedDriver.getId(), savedDriver.getName(), savedDriver.getSurName(), savedDriver.getLicense());
    }

    @Transactional
    public DriverDTO update(Long id, DriverDTO driverDTO) {
        Driver driver = findOneSafe(id);
        driver.setName(driverDTO.getName());
        driver.setSurName(driverDTO.getSurName());
        driver.setLicense(driverDTO.getLicense());
        return new DriverDTO(driver.getId(), driver.getName(), driver.getSurName(), driver.getLicense());
    }

    @Transactional
    public void delete(Long id) {
        Driver driver = findOneSafe(id);
        driverRepository.delete(driver);
    }

    private Driver findOneSafe(Long id) {
        //return driverRepository.findById(id).orElse(new Driver());
        return driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException());
    }
}
