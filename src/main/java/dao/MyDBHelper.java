package dao;

import ui.Dialog;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDBHelper {
    private static Connection c = null;

    public static Connection getConnection() {
        if (c == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getClass().getName() + ": " + e.getMessage());
                Dialog.showDialog("错误", e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
        return c;
    }



}
