package com.kneuroth.pizza_vote.data.entry;

import com.kneuroth.pizza_vote.data.vote.Vote;
import com.kneuroth.pizza_vote.data.vote.VoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryDao {

    @Autowired
    DataSource dataSource;

    public List<Entry> getAll() throws SQLException {
        Connection conn = dataSource.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM PUBLIC.entries;");
        List<Entry> entries = new ArrayList<Entry>();
        while (rs.next()) {
            Entry entry = new Entry(rs.getInt("id"), rs.getString("name"), rs.getString("creator"), rs.getInt("pizzaYear"));
            entries.add(entry);
        }
        return entries;
    }

    public int save(EntryRequest entryRequest) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO PUBLIC.entries (NAME, CREATOR, PIZZAYEAR) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, entryRequest.name());
        statement.setString(2, entryRequest.creator());
        statement.setInt(3, entryRequest.year());
        int updatedRecordCount = statement.executeUpdate();
        conn.commit();
        return updatedRecordCount;
    }

}
