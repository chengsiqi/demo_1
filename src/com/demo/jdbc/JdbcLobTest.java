package com.demo.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author csq
 * @date 2020/4/24 15:04
 * @description
 *
 * JDBC能否处理Blob和Clob？
 * 答： Blob是指二进制大对象（Binary Large Object），而Clob是指大字符对象（Character Large Objec），
 * 因此其中Blob是为存储大的二进制数据而设计的，而Clob是为存储大的文本数据而设计的。JDBC的PreparedStatement
 * 和ResultSet都提供了相应的方法来支持Blob和Clob操作。
 *
 * 下面的代码展示了如何使用JDBC操作LOB：
 *
 **/
public class JdbcLobTest {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 1、加载驱动（Java6以上版本可以省略）
            Class.forName(JDBC_DRIVER);
            // 2、建立连接
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            // 3、创建语句对象
            String sql = "insert into user values(default,?,?,?,?)" ;
            ps = con.prepareStatement(sql);
            // 将SQL语句中的占位符换成字符串
            ps.setString(1, "test");
            ps.setString(2, "test");
            ps.setString(3, "test");

            // Java 7的TWR
            try (InputStream in = new FileInputStream("test.jpg")){
                // 将SQL语句中的占位符换成二进制流
                ps.setBinaryStream(4, in);
                // 4、发出SQL语句获得受影响行数
                System.out.println(ps.executeUpdate() == 1 ? "插入成功" : "插入失败");
            }catch (IOException e){
                System.out.println("读取照片失败");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) { // Java7的多异常捕获
            e.printStackTrace();
        } finally { // 释放外部资源的代码都应当放在finally中保证其能够得到执行
            try {
                if(con != null && !con.isClosed()){
                    // 5、释放数据库连接
                    con.close();
                    // 指示垃圾回收器可以回收该对象
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
