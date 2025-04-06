package com.hiru.Salon.Service.mapper;

import com.hiru.Salon.Service.modal.Salon;
import com.hiru.Salon.Service.payload.dto.SalonDTO;

public class SalonMapper {
    public static SalonDTO mapToDTO(Salon salon) {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(salon.getId());
        salonDTO.setName(salon.getName());
        salonDTO.setEmail(salon.getEmail());
        salonDTO.setPhoneNumber(salon.getPhoneNumber());
        salonDTO.setAddress(salon.getAddress());
        salonDTO.setCity(salon.getCity());
        salonDTO.setImages(salon.getImages());
        salonDTO.setOwnerId(salon.getOwnerId());
        salonDTO.setOpenTime(salon.getOpenTime());
        salonDTO.setCloseTime(salon.getCloseTime());

        return salonDTO;
    }
}
