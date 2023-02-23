package com.petvax.petvaxServices.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;

@RestController
@RequestMapping(path="/health")
public class HealthController {
    @GetMapping
    public void health(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/actuator/health").forward(request, response);
    }
}
