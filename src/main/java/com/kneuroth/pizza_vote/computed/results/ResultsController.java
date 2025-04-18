package com.kneuroth.pizza_vote.computed.results;

import com.kneuroth.pizza_vote.data.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsController {

    @Autowired
    private ResultsLogic resultsLogic;

    @GetMapping()
    public List<Results> getYearResults(@RequestParam(value="year", required=false, defaultValue="0") int year) throws SQLException {
        if (year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        }
        return resultsLogic.buildEntryVotes(year);
    }

    @GetMapping("scott")
    public List<Entry> getScottResults(@RequestParam(value="year", required = false, defaultValue = "0") int year) throws SQLException {
        if (year == 0) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        }
        return resultsLogic.getScottWinner(year);
    }

}
