package dao;

import bean.Hero;

import java.sql.*;

public class HeroDao {
    public HeroDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/view?characterEncoding=UTF-8", "root", "123456");
    }

    public int getTotal() {
        int total = 0;
        try {
            Connection conn = getConnection();
            Statement s = conn.createStatement();
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

}
