package com.umcc.rhemisora.controller;
import com.umcc.rhemisora.config.Routes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")

public class DefaultController {
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView(Routes.HOME);
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView(Routes.LOGIN);
    }

}
