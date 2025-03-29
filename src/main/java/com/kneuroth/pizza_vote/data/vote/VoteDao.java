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
        Connection conn = dataSource.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM PUBLIC.votes;");
        List<Vote> votes = new ArrayList<Vote>();
        while (rs.next()) {
            Vote vote = new Vote(rs.getInt("id"), rs.getString("name"), rs.getInt("entryId"));
            votes.add(vote);
        }
        return votes;
    }

    public int save(VoteRequest voteRequest) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO PUBLIC.votes (NAME, ENTRYID) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, voteRequest.name());
        statement.setInt(2, voteRequest.entryId());
        int updatedRecordCount = statement.executeUpdate();
        conn.commit();
        return updatedRecordCount;
    }

    public int delete(int id) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "DELETE FROM PUBLIC.votes WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        int updatedRecordCount = statement.executeUpdate();
        conn.commit();
        return updatedRecordCount;
    }
}
