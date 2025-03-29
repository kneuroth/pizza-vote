package com.kneuroth.pizza_vote.data.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EntryService {

    @Autowired
    EntryDao entryDao;

    public List<Entry> getEntries() throws SQLException {
        return entryDao.getAll();
    }

    int addEntry(EntryRequest entryRequest) throws SQLException {
        return entryDao.save(entryRequest);
    }
}
