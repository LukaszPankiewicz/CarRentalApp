package com.crud.carRental.mapper;

import com.crud.carRental.domain.Vehicle;
import com.crud.carRental.domain.dto.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleMapper {

    public Vehicle mapToVehicle(final VehicleDto vehicleDto) {
        return new Vehicle(
                vehicleDto.getId(),
                vehicleDto.getRegistration(),
                vehicleDto.getBrand(),
                vehicleDto.getModel(),
                vehicleDto.getDailyPrice(),
                vehicleDto.getVehicleAvailability()
        );
    }

    public VehicleDto mapToVehicleDto(final Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getRegistration(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getDailyPrice(),
                vehicle.getVehicleAvailability(),
                vehicle.getVehicleLocation(),
                vehicle.getReservation(),
                vehicle.getVehicleParams()
        );
    }

    public List<VehicleDto> mapToVehicleDtoList(final List<Vehicle> vehicleList) {
        return vehicleList.stream()
                .map(this::mapToVehicleDto)
                .collect(Collectors.toList());
    }
}
