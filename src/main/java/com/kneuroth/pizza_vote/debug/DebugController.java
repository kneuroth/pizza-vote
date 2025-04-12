package com.kneuroth.pizza_vote.debug;

@RestController
public class DebugController {

    @RequestMapping("/**")
    public ResponseEntity<Void> logOrigin(HttpServletRequest request) {
        String origin = request.getHeader("Origin");
        System.out.println("Origin header received: " + origin);
        return ResponseEntity.ok().build();
    }
}