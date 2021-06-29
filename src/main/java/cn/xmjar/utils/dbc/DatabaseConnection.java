package cn.xmjar.utils.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author 欣茂Java网络课堂开源组件 xmjar.cn
 * @version 1.0
 * <li>此类用于数据库连接</li>
 */


public class DatabaseConnection {
    // 定义数据库连接信息
    private static final String DBDRIVER = ResourceBundle.getBundle("jdbc").getString("jdbc.driver");
    private static final String DBURL = ResourceBundle.getBundle("jdbc").getString("jdbc.url");
    private static final String DBUSER = ResourceBundle.getBundle("jdbc").getString("jdbc.username");
    private static final String DBPASSWORD = ResourceBundle.getBundle("jdbc").getString("jdbc.password");
    private Connection conn;
    /**
     * 加载驱动信息
     */
    public DatabaseConnection() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConn() {
        return this.conn;
    }
    /**
     *  判断数据连接是否操作。
     */
    public void close() {
        if(this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试数据库连接
     * @param args
     */
//    public static void main(String[] args) {
//        System.out.println(new DatabaseConnection().getConn());
//    }
}
