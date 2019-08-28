package utils

import java.sql.DriverManager
import java.sql.ResultSet

import com.kms.katalon.core.annotation.Keyword
import com.mysql.jdbc.Connection
import com.mysql.jdbc.Statement

import internal.GlobalVariable

public class JDBCUtil {
	static Connection connection

	/**
	 * 数据库连接
	 * @param url 连接地址--含数据库名
	 * @return value  Value of variable
	 */
	@Keyword
	def connectDB() {
		def db_url=GlobalVariable.jdbc_url
		def db_name = GlobalVariable.jdbc_database
		def userName=GlobalVariable.jdbc_username
		def password=GlobalVariable.jdbc_password
		def driver = "com.mysql.jdbc.Driver"
		Connection con = null
		Class.forName(driver)
		con = DriverManager.getConnection("jdbc:mysql://" + db_url + "/" + db_name + "?user=" + userName + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8")
		return con
	}

	/**
	 * 执行sql
	 * @param  操作数据库对象
	 * @param sql语句
	 * @return value  Value of variable
	 */
	@Keyword
	def executeSql_Core(sql,queryContent){
		List<String> list = new ArrayList<>()
		connection = connectDB()

		try {
			Statement stm = connection.createStatement()
			ResultSet rs = stm.executeQuery(sql)
			while (rs.next()) {
				list.add(rs.getString(queryContent))
			}
			rs.close()
			stm.close()
			connection.close()
		} catch (Exception e) {
			e.printStackTrace()
		}
		return list.get(0)
	}
}
