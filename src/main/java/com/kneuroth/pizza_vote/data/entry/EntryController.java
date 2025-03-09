package com.kneuroth.pizza_vote.data.entry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    @GetMapping
    public List<Entry> getEntries() {
        return new ArrayList<Entry>();
        // TODO: Get all entries
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEntry(@RequestBody Entry entry) {
        // TODO: Add entry in database
    }

}
