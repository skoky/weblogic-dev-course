package com.skoky.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Created by skoky on 21.12.14.
 */
public class DBHelperPS {

    public List<String> getOwners() {

        Context ctx = null;
        Hashtable ht = new Hashtable();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ctx = new InitialContext(ht);
            DataSource ds = (DataSource) ctx.lookup ("myXE");
            conn = ds.getConnection();
            // You can now use the conn object to create
            //  Statements and retrieve result sets:
            stmt = conn.createStatement();
            int rows = new Random().nextInt(100000);
            long start = System.nanoTime();
            String statement = "select * from employees where rownum<?";
            PreparedStatement pstmt = conn.prepareStatement(statement);
            pstmt.setInt(1,rows);
            rs = pstmt.executeQuery();
            long end = System.nanoTime();
            System.out.println("Rows:"+rows + " in ms:"+(float)(end-start)/1000000 );
            List<String> owners = new ArrayList<String>();
            while (rs.next())
                owners.add(rs.getString("LAST_NAME"));
            return owners;
        }
        catch (Exception e) {
            // a failure occurred
            e.printStackTrace();
        }
        finally {
            try {
                ctx.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
