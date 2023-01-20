package dao;

import pojo.Custom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomDao {
    public static boolean exists() {
        try {
            Connection c = MyDBHelper.getConnection();
            Statement stmt = c.createStatement();
            stmt.executeQuery("SELECT * FROM CUSTOM;");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean createTable() {
        System.out.println("in createTable");
        try {
            Connection c = MyDBHelper.getConnection();
            Statement stmt;
            stmt = c.createStatement();
            String sql = "CREATE TABLE CUSTOM " +
                    "(PHONE   TEXT PRIMARY KEY     NOT NULL," +
                    " NAME    TEXT                 NOT NULL," +
                    " AMOUNT  INT                  NOT NULL," +
                    " BALANCE INT," +
                    " LEVEL   TEXT," +
                    " REMARK  TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean insertCustom(Custom custom) {
        System.out.println("in insertCustom");
        Connection c = MyDBHelper.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String values = "VALUES ('" + custom.getPhone() + "', '" + custom.getName() + "', " +
                    custom.getAmount() + ", " + custom.getBalance() + ", '" + custom.getLevel() + "', '" + custom.getRemark() + "');";
            String sql = "INSERT INTO CUSTOM (PHONE, NAME, AMOUNT, BALANCE, LEVEL, REMARK) " +
                    values;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<Custom> selectCustomByPhone(String phone) {
        Connection c;
        Statement stmt;
        List<Custom> customs = new ArrayList<>();
        Custom custom = null;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOM WHERE PHONE LIKE '%" + phone + "%';");
            while (rs.next()) {
                custom = new Custom();
                custom.setPhone(rs.getString("PHONE"));
                custom.setName(rs.getString("NAME"));
                custom.setAmount(rs.getInt("AMOUNT"));
                custom.setBalance(rs.getInt("BALANCE"));
                custom.setLevel(rs.getString("LEVEL"));
                custom.setRemark(rs.getString("REMARK"));
                customs.add(custom);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return customs;

    }

    public static List<Custom> selectCustomByName(String name) {
        Connection c;
        Statement stmt;
        List<Custom> customs = new ArrayList<>();
        Custom custom = null;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOM WHERE NAME LIKE '%" + name + "%';");
            while (rs.next()) {
                custom = new Custom();
                custom.setPhone(rs.getString("PHONE"));
                custom.setName(rs.getString("NAME"));
                custom.setAmount(rs.getInt("AMOUNT"));
                custom.setBalance(rs.getInt("BALANCE"));
                custom.setLevel(rs.getString("LEVEL"));
                custom.setRemark(rs.getString("REMARK"));
                customs.add(custom);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return customs;

    }

    public static List<Custom> selectAllCustoms() {
        Connection c;
        Statement stmt;
        Custom custom = null;
        List<Custom> customs = new ArrayList<>();
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOM;");
            while (rs.next()) {
                custom = new Custom();
                custom.setPhone(rs.getString("PHONE"));
                custom.setName(rs.getString("NAME"));
                custom.setAmount(rs.getInt("AMOUNT"));
                custom.setBalance(rs.getInt("BALANCE"));
                custom.setLevel(rs.getString("LEVEL"));
                custom.setRemark(rs.getString("REMARK"));
                customs.add(custom);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return customs;
    }

    public static void updateCustom(Custom custom) {
        Connection c;
        Statement stmt;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            String set = "set NAME = '" + custom.getName() + "', " +
                    "AMOUNT = " + custom.getAmount() + ", " +
                    "BALANCE = " + custom.getBalance() + ", " +
                    "LEVEL = '" + custom.getLevel() + "', " +
                    "REMARK = '" + custom.getRemark() + "'";
            String where = "where PHONE = '" + custom.getPhone() + "';";
            String sql = "UPDATE CUSTOM " + set + where;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void deleteCustom(String phone) {
        Connection c;
        Statement stmt;
        try {
            c = MyDBHelper.getConnection();
            stmt = c.createStatement();
            String sql = "DELETE from CUSTOM where PHONE = '" + phone + "';";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
