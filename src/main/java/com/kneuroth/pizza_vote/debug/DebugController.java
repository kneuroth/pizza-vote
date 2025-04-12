package com.kneuroth.pizza_vote.debug;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @RequestMapping("/**")
    public ResponseEntity<Void> logOrigin(HttpServletRequest request) {
        String origin = request.getHeader("Origin");
        System.out.println("Origin header received: " + origin);
        return ResponseEntity.ok().build();
    }
}