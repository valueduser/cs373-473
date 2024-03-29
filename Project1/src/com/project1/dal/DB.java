package com.project1.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * This file from the WikiBook "Java JDBC using SQLite" found at:
 * http://en.wikibooks.org/wiki/Java_JDBC_using_SQLite/Example_base_class
 */

 
/** Database connection class & utilities **/
 
abstract class Db {
 
    public  String sDriver = ""; 
    public  String sUrl = null;
    public  int iTimeout = 30;
    public  Connection conn = null;
    public  Statement statement = null;
 
 
    /* Stub constructor for quick instantiation o/t fly for using some of the ancillary stuff */
 
    public  Db()
    {}
 
    /* quick and dirty constructor to test the database passing the DriverManager name and the fully loaded url to handle */
    /* NB this will typically be available if you make this class concrete and not abstract */
    public Db(String sDriverToLoad, String sUrlToLoad) throws Exception
    {
        init(sDriverToLoad, sUrlToLoad);
    }
 
    public void init(String sDriverVar, String sUrlVar) throws Exception
    {
        setDriver(sDriverVar);
        setUrl(sUrlVar);
        setConnection();
        setStatement();
    }
 
    private void setDriver(String sDriverVar)
    {
        sDriver = sDriverVar;
    }
 
    private void setUrl(String sUrlVar)
    {
        sUrl = sUrlVar;
    }
 
    public  void setConnection() throws Exception {
        Class.forName(sDriver);
        conn = DriverManager.getConnection(sUrl);
    }
 
 
    public  Connection getConnection() {
        return conn;
    }
 
    public  void setStatement() throws Exception {
        if (conn == null) {
            setConnection();
        }
        statement = conn.createStatement();
        statement.setQueryTimeout(iTimeout);  // set timeout to 30 sec.
    }
 
    public  Statement getStatement() {
        return statement;
    }
 
    public  void executeStmt(String instruction) throws SQLException {
        statement.executeUpdate(instruction);
    }
 
    // processes an array of instructions e.g. a set of SQL command strings passed from a file
    //NB you should ensure you either handle empty lines in files by either removing them or parsing them out 
    // since they will generate spurious SQLExceptions when they are encountered during the iteration....
    public void executeStmt(String[] instructionSet) throws SQLException {
        for (int i = 0; i < instructionSet.length; i++) {
            executeStmt(instructionSet[i]);
        }
    }
 
    public ResultSet executeQry(String instruction) throws SQLException {
        return statement.executeQuery(instruction);
    } 
 
    public void closeConnection() {
        try { conn.close(); } catch (Exception ignore) {}
    }
 
}