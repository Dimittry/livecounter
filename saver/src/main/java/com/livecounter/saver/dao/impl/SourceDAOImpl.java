package com.livecounter.saver.dao.impl;


import com.livecounter.saver.dao.SourceDAO;
import com.livecounter.saver.dao.util.Connector;
import com.livecounter.saver.domain.Source;
import com.livecounter.saver.executor.Executor;
import com.livecounter.saver.executor.ResultHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourceDAOImpl implements SourceDAO {
    @Override
    public List<Source> findAll() {
        List<Source> result = new ArrayList<>();
        try {
            DataSource dataSource = Connector.getDataSource();
            final String sql = "SELECT id, name, is_visible, address FROM sources";
            Executor ex = new Executor(dataSource.getConnection());
            result = ex.execQuery(sql, new ResultHandler<List<Source>>(){
                @Override
                public List<Source> handle(ResultSet rs) throws SQLException {
                    List<Source> result = new ArrayList<>();
                    while(rs.next()) {
                        result.add(new Source(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getByte("is_visible"),
                                rs.getString("address")
                            )
                        );
                    }
                    return result;
                }
            });
        } catch (SQLException e) {}
        return result;
    }

    @Override
    public Source findById(final long id) throws SQLException {
        DataSource dataSource = Connector.getDataSource();
        final String sql = "SELECT id, name, is_visible, address FROM sources WHERE id = " + id;
        Executor ex = new Executor(dataSource.getConnection());
        Source source = ex.execQuery(sql, new ResultHandler<Source>() {
            @Override
            public Source handle(ResultSet rs) throws SQLException {
                if(rs.next()) {
                    return new Source(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getByte("is_visible"),
                            rs.getString("address")
                    );
                } else {
                    return new Source();
                }
            }
        });
        return source;
    }

    @Override
    public int createSource(final Source source) {
        return 0;
    }

    @Override
    public int createSourcesBatch(final List<String> queries) {
        int result = 0;
        try {
            DataSource dataSource = Connector.getDataSource();
            Executor ex = new Executor(dataSource.getConnection());
            int[] inserted = ex.execBatchUpdate(queries);
            result = Arrays.stream(inserted).sum();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public int updateSource(final Source source) {
        return 0;
    }

    @Override
    public int deleteById(final long id) {
        return 0;
    }
}
