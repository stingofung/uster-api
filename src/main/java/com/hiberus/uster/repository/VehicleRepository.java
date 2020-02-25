package com.hiberus.uster.repository;

import com.hiberus.uster.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
     List<Vehicle> findAllByIdNotIn(final List<Long> ids);
}
