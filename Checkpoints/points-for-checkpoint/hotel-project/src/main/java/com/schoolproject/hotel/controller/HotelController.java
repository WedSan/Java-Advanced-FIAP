package com.schoolproject.hotel.controller;

import com.schoolproject.hotel.controller.dto.HotelCreationRequest;
import com.schoolproject.hotel.controller.dto.HotelResponse;
import com.schoolproject.hotel.controller.dto.HotelUpdateRequest;
import com.schoolproject.hotel.model.HotelEntity;
import com.schoolproject.hotel.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/register")
    public String getFormRegister(Model model) {
        model.addAttribute("hotel", new HotelCreationRequest("", null, 0));
        return "register";
    }

    @GetMapping("/{id}/edit")
    public String updateHotel(Model model, @PathVariable("id") Long hotelId){
        HotelResponse hotel = hotelService.getHotel(hotelId);
        if (hotel == null){
            return "not_found";
        }
        model.addAttribute("hotel", hotel);
        return "update_hotel";
    }

    @GetMapping("/{id}")
    public String getHotelDetails(@PathVariable("id") Long hotelId, Model model) {
        HotelResponse hotelResponse = hotelService.getHotel(hotelId);
        if (hotelResponse == null) {
            return "not_found";
        }

        model.addAttribute("hotel", hotelResponse);
        return "hotel_details";
    }

    @PutMapping("/{id}")
    public String updateHotelInfo(@ModelAttribute HotelUpdateRequest req,
                                  @PathVariable("id") Long hotelId,
                                  Model model){
        System.out.println("Chegou aqui o id: " + hotelId);
        hotelService.updateHotel(req, hotelId, model);
        return "redirect:/home";
    }

    @PostMapping("/register")
    public String getFormRegister(@ModelAttribute HotelCreationRequest req, Model model) {
        hotelService.registerHotel(req);
        return "redirect:/home";
    }
}
