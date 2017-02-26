package com.countergrabber.dao.impl;

import com.countergrabber.dao.CounterDAO;
import com.countergrabber.dao.util.Connector;
import com.countergrabber.domain.Counter;
import com.countergrabber.domain.Source;
import com.countergrabber.executor.Executor;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CounterDAOImpl implements CounterDAO {

    private final static String COUNTER_TABLE = "source_data";

    @Override
    public List<Source> findAll() {
        List<Source> result = new ArrayList<>();
        return result;
    }

    @Override
    public int saveBatch(final List<Counter> counters) {
        int saved = 0;
        List<String> queries = prepareCountersForBatchSave(counters);
        try {
            DataSource ds = Connector.getDataSource();
            Executor ex = new Executor(ds.getConnection());
            saved = ex.execBatchUpdate(queries);
        } catch (SQLException e) {

        }
        return saved;
    }


    private List<String> prepareCountersForBatchSave(final List<Counter> counters) {
        String sql;
        List<String> result = new ArrayList<>();
        for(Counter counter : counters) {
            sql = "INSERT INTO " + COUNTER_TABLE + " (id_source, day, type, value, created)" +
                    " VALUES (" + counter.getIdSource() + ", " +
                    "'" + new SimpleDateFormat("yyyy-MM-dd").format(counter.getDay()) + "'," +
                    counter.getType() + ", " +
                    counter.getValue() + ", " +
                    "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(counter.getCreated()) + "'" +
                    ")";
            result.add(sql);
        }
        return result;
    }

}
