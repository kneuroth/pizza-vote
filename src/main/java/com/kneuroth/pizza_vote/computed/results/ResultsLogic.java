package com.kneuroth.pizza_vote.computed.results;

import com.kneuroth.pizza_vote.data.entry.Entry;
import com.kneuroth.pizza_vote.data.entry.EntryDao;
import com.kneuroth.pizza_vote.data.vote.VoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultsLogic {
    @Autowired
    VoteDao voteDao;

    @Autowired
    EntryDao entryDao;
    @Autowired
    private ResultsDao resultsDao;

    public List<Results> buildEntryVotes(int year) throws SQLException {
        // TODO: Get entries from this year and all votes for it
        return resultsDao.getResults(year);
    }

    public Entry getScottWinner(int year) {
        return new Entry(1, "Best pizza", "Kelly", 1);
    }
}
