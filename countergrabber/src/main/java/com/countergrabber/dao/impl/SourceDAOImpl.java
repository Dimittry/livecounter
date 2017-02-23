package com.countergrabber.dao.impl;

import com.countergrabber.dao.SourceDAO;
import com.countergrabber.dao.util.Connector;
import com.countergrabber.domain.Source;
import com.countergrabber.executor.Executor;
import com.countergrabber.executor.ResultHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SourceDAOImpl implements SourceDAO {
    public List<Source> findAll() {
        List<Source> result = new ArrayList<>();
        try {
            DataSource dataSource = Connector.getDataSource();
            final String sql = "SELECT id, name, is_visible, address FROM sources";
            Executor ex = new Executor(dataSource.getConnection());
            result = ex.execQuery(sql, new ResultHandler<List<Source>>() {
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
        } catch (SQLException e) {

        }
        return result;
    }
}
