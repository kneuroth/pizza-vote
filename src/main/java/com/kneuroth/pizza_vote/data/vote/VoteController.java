package com.kneuroth.pizza_vote.data.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    VoteService voteService;

    @GetMapping
    public ResponseEntity<List<Vote>> get() throws SQLException {
        List<Vote> votes = voteService.getVotes();
        return ResponseEntity.status(HttpStatus.OK).body(votes);
    }

    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody VoteRequest voteRequest) throws SQLException {
        int savedVoteCount = voteService.castVote(voteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVoteCount);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam(value="id") int id) throws SQLException {
        voteService.deleteVote(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
