package com.kneuroth.pizza_vote.data.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VoteDao {

    @Autowired
    DataSource dataSource;

    public List<Vote> getAll() throws SQLException {
        String sql = "SELECT * FROM PUBLIC.votes;";
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)){

            List<Vote> votes = new ArrayList<Vote>();
            while (rs.next()) {
                Vote vote = new Vote(rs.getInt("id"), rs.getString("name"), rs.getInt("entryId"));
                votes.add(vote);
            }
            return votes;
        }
    }

    public int save(VoteRequest voteRequest) throws SQLException {
        String sql = "INSERT INTO PUBLIC.votes (NAME, ENTRYID) VALUES (?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, voteRequest.name());
            statement.setInt(2, voteRequest.entryId());
            return statement.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM PUBLIC.votes WHERE ID = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);) {

            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }
}
