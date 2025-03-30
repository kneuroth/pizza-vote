package com.kneuroth.pizza_vote.data.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kneuroth.pizza_vote.Constants.SCOTT_DB_NAME;

@Service
public class VoteService {

    @Autowired
    VoteDao voteDao;

    @Autowired
    DataSource dataSource;

    public List<Vote> getVotes() throws SQLException {
        return voteDao.getAll();
    }

    public int castVote(VoteRequest voteRequest) throws SQLException {
        // TODO: Check if vote is ok
        return voteDao.save(voteRequest);
    }

    public int castScottVote(VoteRequest voteRequest) throws SQLException {
        // Force Scott name
        VoteRequest scottVote = new VoteRequest(SCOTT_DB_NAME, voteRequest.entryId());
        return voteDao.save(scottVote);
    }

    public int deleteVote(int id) throws SQLException {
        return voteDao.delete(id);
    }
}
