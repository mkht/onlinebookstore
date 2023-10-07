package com.bittercode.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class DatabaseConfig {

    static Properties prop = new Properties();
    static {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("application.properties");

        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static String DRIVER_NAME = prop.getProperty("db.driver");
    public final static String DB_HOST = prop.getProperty("db.host");
    public final static String DB_PORT = prop.getProperty("db.port");
    public final static String DB_NAME = prop.getProperty("db.name");
    public final static String DB_USER_NAME = System.getenv("MYSQL_DB_USERNAME");
    public final static String DB_PASSWORD = System.getenv("MYSQL_DB_PASSWORD");
    public final static String USE_SSL = prop.getProperty("db.usessl");
    public final static String CONNECTION_STRING = System.getenv("MYSQL_CONNECTION_STRING");
}
