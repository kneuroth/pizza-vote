package com.kneuroth.pizza_vote.data.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    VoteDao voteDao;

    @Autowired
    DataSource dataSource;
    public List<Vote> getVotes() throws SQLException {
        return voteDao.getAll();
    }

    public int castVote(Vote vote) throws SQLException {
        // TODO: Check if vote is ok
        return voteDao.save(vote);
    }
}
