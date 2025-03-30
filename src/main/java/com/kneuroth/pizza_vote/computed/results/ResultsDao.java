package com.kneuroth.pizza_vote.computed.results;

import com.kneuroth.pizza_vote.data.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.kneuroth.pizza_vote.Constants.SCOTT_DB_NAME;

@Repository
public class ResultsDao {

    @Autowired
    DataSource dataSource;

    public List<Results> getResults(int year) throws SQLException {
        String sql = "SELECT e.name AS entryName, e.creator, COUNT(v.id) AS voteCount " +
                "FROM entries e LEFT JOIN votes v ON e.id = v.entryId " +
                "WHERE e.pizzaYear = ? " +
                "GROUP BY e.id, e.name, e.creator " +
                "ORDER BY voteCount DESC;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);) {

            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();
            List<Results> resultSet = new ArrayList<Results>();
            while (rs.next()) {
                Results results = new Results(rs.getString("entryName"), rs.getString("creator"), rs.getInt("voteCount"));
                resultSet.add(results);
            }
            return resultSet;
        }
    }

    public List<Entry> getScottResults(int year) throws SQLException {
        String sql = "SELECT e.* " +
                "FROM entries e " +
                "JOIN votes v ON e.id = v.entryId " +
                "WHERE e.pizzaYear = ? AND v.name = '"+ SCOTT_DB_NAME + "' " +
                "GROUP BY e.id, e.name, e.creator, e.pizzaYear " +
                "ORDER BY COUNT(v.id) DESC " +
                "LIMIT 1;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();
            List<Entry> resultSet = new ArrayList<Entry>();
            while (rs.next()) {
                Entry entry = new Entry(rs.getInt("id"), rs.getString("name"), rs.getString("creator"), rs.getInt("pizzaYear"));
                resultSet.add(entry);
            }
            return resultSet;
        }
    }



}
