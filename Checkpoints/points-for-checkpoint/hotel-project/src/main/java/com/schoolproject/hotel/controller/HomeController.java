package com.schoolproject.hotel.controller;

import com.schoolproject.hotel.controller.dto.HotelResponse;
import com.schoolproject.hotel.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private HotelService hotelService;

    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String home(Model model) {
        List<HotelResponse> hotelList = hotelService.getHotels();
        model.addAttribute("hotelList", hotelList);
        return "home";
    }
}
