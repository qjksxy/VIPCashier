package dao;

import pojo.History;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HistoryDao {
    public static boolean exists() {
        try {
            Connection c = MyDBHelper.getConnection();
            Statement stmt = c.createStatement();
            stmt.executeQuery("SELECT * FROM HISTORY;");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean createTable() {
        System.out.println("in createTable:History");
        try {
            Connection c = MyDBHelper.getConnection();
            Statement stmt;
            stmt = c.createStatement();
            String sql = "CREATE TABLE HISTORY " +
                    "(ID      INT PRIMARY KEY      NOT NULL," +
                    " PHONE   TEXT," +
                    " SUBJECT  TEXT                  NOT NULL," +
                    " NAME TEXT," +
                    " MONEY   INT                    NOT NULL," +
                    " DATE   INTEGER," +
                    " REMARK  TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean insertHistory(History history) {
        System.out.println("in insertCustom");
        Connection c = MyDBHelper.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            // int id, String phone, String subject, String name, int money, long time, String remark
            String values = "VALUES (" + history.getId() + ", '" + history.getPhone() + "', '" +
                    history.getSubject() + "', '" + history.getName() + "', " + history.getMoney() + ", " +
                    history.getDate() + ", '" + history.getRemark() + "');";
            String sql = "INSERT INTO HISTORY (ID, PHONE, SUBJECT, NAME, MONEY, DATE, REMARK) " + values;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
