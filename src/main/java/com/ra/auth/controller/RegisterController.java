package com.ra.auth.controller;

import com.ra.auth.dto.UserDto;
import com.ra.auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {
    private UserService userService;
    @ModelAttribute("userDto")
    public UserDto userRegistrationDto(){
        return new UserDto();
    }
    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userDto") UserDto userDto){
        if(userService.checkUserByEmail(userDto.getEmail())){
            return "redirect:/registration?emailExist";
        }
        if(!userDto.getPassword().equals(userDto.getCheckPass())){
            return "redirect:/registration?checkPass";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
