package dao;

import pojo.Custom;
import pojo.History;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                    "(ID       INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " PHONE    TEXT," +
                    " SUBJECT  TEXT              NOT NULL," +
                    " NAME     TEXT," +
                    " MONEY    INT               NOT NULL," +
                    " DATE     INTEGER," +
                    " REMARK   TEXT)";
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
            String values = "VALUES ('" + history.getPhone() + "', '" +
                    history.getSubject() + "', '" + history.getName() + "', " + history.getMoney() + ", " +
                    history.getDate() + ", '" + history.getRemark() + "');";
            String sql = "INSERT INTO HISTORY (PHONE, SUBJECT, NAME, MONEY, DATE, REMARK) " + values;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<History> selectHistoryByPhone(String phone) {
        Connection c;
        Statement stmt;
        List<History> histories = new ArrayList<>();
        History history = null;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HISTORY WHERE PHONE LIKE '%" + phone + "%';");
            while (rs.next()) {
                // int id, String phone, String subject, String name, int money, long date, String remark
                history = new History();
                history.setId(rs.getInt("ID"));
                history.setPhone(rs.getString("PHONE"));
                history.setName(rs.getString("NAME"));
                history.setSubject(rs.getString("SUBJECT"));
                history.setMoney(rs.getInt("MONEY"));
                history.setDate(rs.getLong("DATE"));
                history.setRemark(rs.getString("REMARK"));
                histories.add(history);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return histories;

    }

    public static List<History> selectHistoryByDate(long startTime, long endTime) {
        Connection c;
        Statement stmt;
        List<History> histories = new ArrayList<>();
        History history = null;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HISTORY WHERE DATE >=" + startTime + " AND DATE <= " + endTime + ";");
            while (rs.next()) {
                history = new History();
                history.setId(rs.getInt("ID"));
                history.setPhone(rs.getString("PHONE"));
                history.setName(rs.getString("NAME"));
                history.setSubject(rs.getString("SUBJECT"));
                history.setMoney(rs.getInt("MONEY"));
                history.setDate(rs.getLong("DATE"));
                history.setRemark(rs.getString("REMARK"));
                histories.add(history);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return histories;

    }

    public static List<History> selectHistoryByName(String name) {
        Connection c;
        Statement stmt;
        List<History> histories = new ArrayList<>();
        History history = null;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HISTORY WHERE NAME LIKE '%" + name + "%';");
            while (rs.next()) {
                // int id, String phone, String subject, String name, int money, long date, String remark
                history = new History();
                history.setId(rs.getInt("ID"));
                history.setPhone(rs.getString("PHONE"));
                history.setName(rs.getString("NAME"));
                history.setSubject(rs.getString("SUBJECT"));
                history.setMoney(rs.getInt("MONEY"));
                history.setDate(rs.getLong("DATE"));
                history.setRemark(rs.getString("REMARK"));
                histories.add(history);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return histories;

    }
}
