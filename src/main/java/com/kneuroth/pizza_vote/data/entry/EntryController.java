package com.kneuroth.pizza_vote.data.entry;

import com.kneuroth.pizza_vote.data.vote.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping
    public  ResponseEntity<List<Entry>> getEntries() throws SQLException {
        List<Entry> votes = entryService.getEntries();
        return ResponseEntity.status(HttpStatus.OK).body(votes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Integer> addEntry(@RequestBody EntryRequest entryRequest) throws SQLException {
        int savedEntryCount = entryService.addEntry(entryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntryCount);
    }

}
