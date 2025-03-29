package com.kneuroth.pizza_vote.computed.results;

import com.kneuroth.pizza_vote.data.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultsDao {

    @Autowired
    DataSource dataSource;

    public List<Results> getResults(int year) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "SELECT e.name AS entryName, e.creator, COUNT(v.id) AS voteCount " +
                "FROM entries e LEFT JOIN votes v ON e.id = v.entryId " +
                "WHERE e.pizzaYear = ? " +
                "GROUP BY e.id, e.name, e.creator " +
                "ORDER BY voteCount DESC;";
        PreparedStatement statement = conn.prepareStatement(sql);
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
