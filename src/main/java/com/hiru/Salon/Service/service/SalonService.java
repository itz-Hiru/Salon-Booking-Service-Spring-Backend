package com.hiru.Salon.Service.service;

import com.hiru.Salon.Service.modal.Salon;
import com.hiru.Salon.Service.payload.dto.SalonDTO;
import com.hiru.Salon.Service.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salonDTO, UserDTO userDTO);
    Salon updateSalon(SalonDTO salonDTO, UserDTO userDTO, Long salonId) throws Exception;
    List<Salon> getAllSalons();
    Salon getSalonById(Long salonId) throws Exception;
    Salon getSalonByOwnerId(Long ownerId);
    List<Salon> searchSalonByCity(String city);
}
