package com.livecounter.saver.dao.util;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import sun.plugin.dom.exception.InvalidStateException;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class Connector {
    private static final String DB_PROPS_FILENAME = "dp.properties";
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if(dataSource == null) {
            Properties props = getDbProperties();
            System.out.println(props);
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(props.getProperty("db.url"));
            config.setUsername(props.getProperty("db.username"));
            config.setPassword(props.getProperty("db.password"));
            config.setPassword("");
            config.addDataSourceProperty("cachePrepStmts", props.getProperty("db.cachePrepStmts"));
            config.addDataSourceProperty("prepStmtCacheSize", props.getProperty("db.prepStmtCacheSize"));
            config.addDataSourceProperty("prepStmtCacheSqlLimit", props.getProperty("db.prepStmtCacheSqlLimit"));
            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }

    public static Properties getDbProperties() {
        final Properties properties = new Properties();
        try {
            properties.load(Connector.class.getClassLoader().getResourceAsStream(DB_PROPS_FILENAME));
        } catch (IOException e) {
            throw new InvalidStateException("Can't load property file.");
        }
        return properties;
    }
}
