package com.hiru.Salon.Service.controller;

import com.hiru.Salon.Service.mapper.SalonMapper;
import com.hiru.Salon.Service.modal.Salon;
import com.hiru.Salon.Service.payload.dto.SalonDTO;
import com.hiru.Salon.Service.payload.dto.UserDTO;
import com.hiru.Salon.Service.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salons")
@RequiredArgsConstructor
public class SalonController {
    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO, userDTO);
        SalonDTO salonDT01 = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDT01);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalonDTO> updateSalon(
            @PathVariable("id") Long salonId,
            @RequestBody SalonDTO salonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);
        SalonDTO salonDT01 = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDT01);
    }

    @GetMapping
    public ResponseEntity<List<SalonDTO>> getSalons(){
        List<Salon> salons = salonService.getAllSalons();
        List<SalonDTO> salonDTOS = salons.stream().map((salon) ->
        {
            SalonDTO salonDT0 = SalonMapper.mapToDTO(salon);
            return salonDT0;
        }).toList();

        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable Long salonId) throws Exception {
        Salon salon = salonService.getSalonById(salonId);
        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(
            @RequestParam("city") String city
    ){
        List<Salon> salons = salonService.searchSalonByCity(city);
        List<SalonDTO> salonDTOS = salons.stream().map((salon) ->
        {
            SalonDTO salonDT0 = SalonMapper.mapToDTO(salon);
            return salonDT0;
        }).toList();

        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<SalonDTO> getSalonByOwnerId(@PathVariable String ownerId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }
}
