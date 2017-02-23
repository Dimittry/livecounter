package com.countergrabber.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public int execUpdate(final String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        int updated = stmt.getUpdateCount();
        stmt.close();
        connection.close();
        return updated;
    }

    public int[] execBatchUpdate(final List<String> queries) throws SQLException{
        connection.setAutoCommit(false);
        Statement stmt = connection.createStatement();
        for(String query : queries) {
            stmt.addBatch(query);
        }
        int[] updated = stmt.executeBatch();
        connection.commit();
        stmt.close();
        connection.close();
        return updated;
    }

    public <T> T execQuery(final String query, ResultHandler<T> handler)
            throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        T value = handler.handle(result);
        result.close();
        stmt.close();
        connection.close();
        return value;
    }
}
