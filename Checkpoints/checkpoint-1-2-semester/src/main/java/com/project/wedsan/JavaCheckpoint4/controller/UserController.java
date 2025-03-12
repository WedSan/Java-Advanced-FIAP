package com.project.wedsan.JavaCheckpoint4.controller;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateUserReq;
import com.project.wedsan.JavaCheckpoint4.exception.UserEmailAlreadyExistsException;
import com.project.wedsan.JavaCheckpoint4.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/form")
    public String getRegisterUserForm(Model model){
        CreateUserReq request = new CreateUserReq();
        model.addAttribute("createUserReq", request);
        return "register_user";
    }


    @PostMapping
    public String registerUser(@Valid @ModelAttribute CreateUserReq req, BindingResult result){
        if(result.hasErrors()){
            return "register_user";
        }
        try{
            userService.registerUser(req);
        } catch(UserEmailAlreadyExistsException ex){
            System.out.println("erro no e-mail");
            result.rejectValue("email", "error.email.exists");
            return "register_user";
        }
        System.out.println("Foi adicionado o usuário");
        return "success_register";
    }

}
