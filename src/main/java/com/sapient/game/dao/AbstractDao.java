package com.sapient.game.dao;

import com.sapient.game.memory.Session;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Sourabh on 4/23/2018.
 */
public class AbstractDao {

    private Session session;
    private DataSource dataSource;
    private Connection connection;

    @Inject
    public AbstractDao(Session session, DataSource dataSource) {
        this.session = session;
        this.dataSource = dataSource;
    }

    protected Connection getConnection() throws Exception{

        if(connection == null) {
            connection = dataSource.getConnection();
        }
        return connection;
    }

    protected Session getSession() {
        return session;
    }
}
