package com.schoolproject.hotel.controller;

import com.schoolproject.hotel.controller.dto.HotelCreationRequest;
import com.schoolproject.hotel.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public String getFormRegister(@ModelAttribute HotelCreationRequest req, Model model) {

    }
}
