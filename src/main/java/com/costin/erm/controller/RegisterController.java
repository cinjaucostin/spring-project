package com.costin.erm.controller;

import com.costin.erm.entity.User;
import com.costin.erm.service.UserService;
import com.costin.erm.usermodel.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/showFormForRegister")
    public String showFormForRegister(Model model) {
        model.addAttribute("registrationUserModel", new RegisterUserModel());

        return "registration/registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processFormForRegister(
            @Valid @ModelAttribute("registrationUserModel") RegisterUserModel userModel,
            BindingResult result,
            Model model) {

        if(result.hasErrors()) {
            return "registration/registration-form";
        }

        User existing = userService.findByUsername(userModel.getUsername());

        if(existing != null) {
            model.addAttribute("registrationUserModel", userModel);
            model.addAttribute("registrationError", "Username already exists.");

            return "registration/registration-form";
        }

        existing = userService.findByEmail(userModel.getEmail());
        if(existing != null) {
            model.addAttribute("registrationUserModel", userModel);
            model.addAttribute("registrationError", "Email already used.");

            return "registration/registration-form";
        }

        userService.save(userModel);

        return "registration/registration-confirmation";
    }

}
