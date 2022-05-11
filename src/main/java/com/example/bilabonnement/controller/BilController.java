package com.example.bilabonnement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BilController {

    @GetMapping("/")
    public String index(){return "index";}



}
