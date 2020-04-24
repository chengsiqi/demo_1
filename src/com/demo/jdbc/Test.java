package com.demo.jdbc;

import java.sql.*;

/**
 * @author csq
 * @date 2020/4/23 17:48
 * @description
 *
 * 阐述JDBC操作数据库的步骤
 *
 * MySQL 8.0 以上版本的数据库连接有所不同：
 *  com.mysql.jdbc.Driver 更换为 com.mysql.cj.jdbc.Driver。
 *  MySQL 8.0 以上版本不需要建立 SSL 连接的，需要显示关闭。
 *  最后还需要设置 CST。
 *
 * 1、Statement和PreparedStatement有什么区别？哪个性能更好
 * 答：与Statement相比，①PreparedStatement接口代表预编译的语句，它主要的优势在于可以减少SQL
 * 的编译错误并增加SQL的安全性（减少SQL注射攻击的可能性）；②PreparedStatement中的SQL语句是可
 * 以带参数的，避免了用字符串连接拼接SQL语句的麻烦和不安全；③当批量处理SQL或频繁执行相同的查询时，
 * PreparedStatement有明显的性能上的优势，由于数据库可以将编译优化后的SQL语句缓存起来，下次执行
 * 相同结构的语句时就会很快（不用再次编译和生成执行计划）。
 *
 * 补充：为了提供对存储过程的调用，JDBC API中还提供了CallableStatement接口。
 * 存储过程（Stored Procedure）是数据库中一组为了完成特定功能的SQL语句的集合，经编译后存储在数据库
 * 中，用户通过指定存储过程的名字并给出参数（如果该存储过程带有参数）来执行它。虽然调用存储过程会在网络
 * 开销、安全性、性能上获得很多好处，但是存在如果底层数据库发生迁移时就会有很多麻烦，因为每种数据库的存
 * 储过程在书写上存在不少的差别。
 *
 *
 * 2、使用JDBC操作数据库时，如何提升读取数据的性能？如何提升更新数据的性能？
 * 答：要提升读取数据的性能，可以指定通过结果集（ResultSet）对象的setFetchSize()方法指定每次抓
 * 取的记录数（典型的空间换时间策略）；要提升更新数据的性能可以使用PreparedStatement语句构建批处
 * 理，将若干SQL语句置于一个批处理中执行。
 *
 *
 **/
public class Test {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // Statement statement =null;
        ResultSet resultSet = null;
        try {
            // 1、加载驱动
            Class.forName(JDBC_DRIVER);
            // 2、创建连接
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            // 3、创建语句
            String sql = "SELECT * FROM `user` where id = ?";
            // statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            // 4、执行语句
            // resultSet = statement.executeQuery(sql);
            resultSet = preparedStatement.executeQuery();
            // 5、处理结果
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + "-" + resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6、关闭资源
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 提示：关闭外部资源的顺序应该和打开的顺序相反，也就是说先关闭ResultSet、再关闭Statement、在关闭Connection。
        // 上面的代码只关闭了Connection（连接），虽然通常情况下在关闭连接时，连接上创建的语句和打开的游标也会关闭，但不能
        // 保证总是如此，因此应该按照刚才说的顺序分别关闭。
        //
        // 此外，第一步加载驱动在JDBC 4.0中是可以省略的（自动从类路径中加载驱动），但是我们建议保留。
    }
}
