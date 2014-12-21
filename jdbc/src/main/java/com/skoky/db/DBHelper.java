package com.skoky.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

/**
 * Created by skoky on 21.12.14.
 */
public class DBHelper {

    public void users() {

        Context ctx = null;
        Hashtable ht = new Hashtable();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ctx = new InitialContext(ht);
            javax.sql.DataSource ds
                    = (javax.sql.DataSource) ctx.lookup ("myXE");
            conn = ds.getConnection();
            // You can now use the conn object to create
            //  Statements and retrieve result sets:
            stmt = conn.createStatement();
            stmt.execute("select * from someTable");
            rs = stmt.getResultSet();
            ...
//Close JDBC objects as soon as possible
            stmt.close();
            stmt=null;
            conn.close();
            conn=null;
        }
        catch (Exception e) {
            // a failure occurred
            log message;
        }
        finally {
            try {
                ctx.close();
            } catch (Exception e) {
                log message; }
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                log message; }
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                log message; }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                log message; }
        }
    }
}
