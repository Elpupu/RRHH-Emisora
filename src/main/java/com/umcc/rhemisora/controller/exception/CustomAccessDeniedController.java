package com.umcc.rhemisora.controller.exception;

import com.umcc.rhemisora.config.Routes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomAccessDeniedController {

    @GetMapping("/access-denied")
    public ModelAndView getAccessDenied(){
        return new ModelAndView(Routes.ACCESS_DENIED);
    }
}
