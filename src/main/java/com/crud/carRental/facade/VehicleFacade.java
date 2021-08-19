package com.crud.carRental.facade;

import com.crud.carRental.domain.dto.VehicleDto;
import com.crud.carRental.exception.VehicleNotFoundException;
import com.crud.carRental.mapper.VehicleMapper;
import com.crud.carRental.repository.VehicleRepository;
import com.crud.carRental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class VehicleFacade {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleFacade(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleService = vehicleService;
    }

    public List<VehicleDto> getVehicles() {
        return vehicleMapper.mapToVehicleDtoList(vehicleService.findAllVehicles());
    }

    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        return vehicleMapper.mapToVehicleDto(vehicleService.saveVehicle(vehicleMapper.mapToVehicle(vehicleDto)));
    }

    public VehicleDto getVehicleById(Long id) throws VehicleNotFoundException {
        return vehicleMapper.mapToVehicleDto(vehicleService.getVehicleById(id));
    }

    public VehicleDto getVehicleByRegistration(String registration) throws VehicleNotFoundException {
        return vehicleMapper.mapToVehicleDto(vehicleService.getVehicleByRegistration(registration));
    }

    public List<VehicleDto> getVehicleByModel(String model) {
        return vehicleMapper.mapToVehicleDtoList(vehicleService.getVehicleByModel(model));
    }

    public List<VehicleDto> getVehicleByDailyCost(BigDecimal dailyPrice) {
        return vehicleMapper.mapToVehicleDtoList(vehicleService.getVehicleByDailyCost(dailyPrice));
    }

    public void deleteVehicle(Long id) {
        vehicleService.deleteCar(id);
    }

}
