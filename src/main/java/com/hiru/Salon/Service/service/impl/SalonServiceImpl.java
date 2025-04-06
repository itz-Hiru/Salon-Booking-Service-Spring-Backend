package com.hiru.Salon.Service.service.impl;

import com.hiru.Salon.Service.modal.Salon;
import com.hiru.Salon.Service.payload.dto.SalonDTO;
import com.hiru.Salon.Service.payload.dto.UserDTO;
import com.hiru.Salon.Service.repository.SalonRepository;
import com.hiru.Salon.Service.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO salonDTO, UserDTO userDTO) {
        Salon salon = new Salon();
        salon.setName(salonDTO.getName());
        salon.setEmail(salonDTO.getEmail());
        salon.setAddress(salonDTO.getAddress());
        salon.setCity(salonDTO.getCity());
        salon.setPhoneNumber(salonDTO.getPhoneNumber());
        salon.setImages(salonDTO.getImages());
        salon.setOwnerId(userDTO.getId());
        salon.setOpenTime(salonDTO.getOpenTime());
        salon.setCloseTime(salonDTO.getCloseTime());

        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salonDTO, UserDTO userDTO, Long salonId) throws Exception {
        Salon existingSalon = salonRepository.findById(salonId).orElse(null);
        if (existingSalon != null && salonDTO.getOwnerId().equals(userDTO.getId())) {
            existingSalon.setName(salonDTO.getName());
            existingSalon.setEmail(salonDTO.getEmail());
            existingSalon.setAddress(salonDTO.getAddress());
            existingSalon.setCity(salonDTO.getCity());
            existingSalon.setPhoneNumber(salonDTO.getPhoneNumber());
            existingSalon.setImages(salonDTO.getImages());
            existingSalon.setOpenTime(salonDTO.getOpenTime());
            existingSalon.setCloseTime(salonDTO.getCloseTime());
            existingSalon.setOwnerId(userDTO.getId());

            return salonRepository.save(existingSalon);
        }
        throw new Exception("Salon nos exist");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon == null) {
            throw new Exception("Salon not exists");
        }
        return salon;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
