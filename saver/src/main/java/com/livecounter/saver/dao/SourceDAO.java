package com.livecounter.saver.dao;


import com.livecounter.saver.domain.Source;

import java.sql.SQLException;
import java.util.List;

public interface SourceDAO {

    List<Source> findAll();

    Source findById(final long id) throws SQLException;

    int createSource(final Source source);

    int createSourcesBatch(final List<String> queries);

    int updateSource(final Source source);

    int deleteById(final long id);
}
