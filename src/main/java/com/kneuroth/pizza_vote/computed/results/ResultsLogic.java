package com.kneuroth.pizza_vote.computed.results;

import com.kneuroth.pizza_vote.data.entry.Entry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultsLogic {

    public List<EntryVotes> buildEntryVotes(int year)  {
        // TODO: Get entries from this year and all votes for it
        return new ArrayList<EntryVotes>();
    }

    public Entry getScottWinner(int year) {
        return new Entry(1, "Best pizza", "Kelly", 1);
    }
}
