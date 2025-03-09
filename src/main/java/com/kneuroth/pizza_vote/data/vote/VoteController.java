package com.kneuroth.pizza_vote.data.vote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @GetMapping
    public List<Vote> get(){
        return new ArrayList<Vote>();
    }
}
