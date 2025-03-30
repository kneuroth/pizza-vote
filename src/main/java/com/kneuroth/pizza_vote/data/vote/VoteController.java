package com.kneuroth.pizza_vote.data.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
        // TODO: If we think it's scott's vote, castScottVote
        Pattern SCOTT_PATTERN = Pattern.compile(
                "(?i)s\\s*c\\s*o\\s*t\\s*t|c\\s*h\\s*e\\s*p"
        );
        int savedVoteCount = 0;
        if (SCOTT_PATTERN.matcher(voteRequest.name()).find()) {
            savedVoteCount = voteService.castScottVote(voteRequest);
        } else {
            savedVoteCount = voteService.castVote(voteRequest);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVoteCount);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam(value="id") int id) throws SQLException {
        voteService.deleteVote(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
