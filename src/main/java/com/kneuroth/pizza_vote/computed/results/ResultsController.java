package com.kneuroth.pizza_vote.computed.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsController {

    @Autowired
    private ResultsLogic resultsLogic;

    @GetMapping()
    public List<EntryVotes> getYearResults(@RequestParam(value="year", required=false, defaultValue="0") int year) {
        if (year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        }
        return resultsLogic.buildEntryVotes(year);
    }

}
