package com.weather.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.http.MediaType.TEXT_HTML;

/**
 * Created by arthur on 16/05/16.
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
