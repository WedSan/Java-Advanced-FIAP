package com.project.wedsan.JavaCheckpoint4.controller;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CityResponse;
import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateCityReq;
import com.project.wedsan.JavaCheckpoint4.exception.CityAlreadyExistsByLatitudeAndLongitude;
import com.project.wedsan.JavaCheckpoint4.exception.CityAlreadyExistsByName;
import com.project.wedsan.JavaCheckpoint4.service.CityService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/form")
    public String getFormPage(Model model){
        CreateCityReq req = new CreateCityReq();
        model.addAttribute("cityReq", req);
        return "register_city";
    }

    @GetMapping("/")
    public String getCityListPage(Model model){
        List<CityResponse> cities = cityService.getCities();
        model.addAttribute("city_list", cities);
        return "city_list";
    }

    @PostMapping
    public String registerCity(Model model, @Valid @ModelAttribute CreateCityReq req, BindingResult result){
        model.addAttribute("cityReq", req);
        if(result.hasErrors()){
            return "register_city";
        }
        try{
            cityService.registerCity(req);
        } catch(CityAlreadyExistsByName ex){
            result.rejectValue("name", "city.error.name.exists");
            return "register_city";
        }
        catch (CityAlreadyExistsByLatitudeAndLongitude ex){
            result.reject("city.error.coordinate.exists");
            return "register_city";
        }

        return "success_register_city";
    }

}
