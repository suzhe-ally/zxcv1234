package WTU.dbc;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DatabaseConnection {
	private static String DBDRIVER = "com.mysql.jdbc.Driver";
	private static String DBURL = "jdbc:mysql://localhost:3306/graphics?useSSL=false";
	private static String DBUSER = "root";
	private static String PASSWORD = "enen7657";
	// ׼��һ����ݿ����Ӷ���
	private Connection con;
	
	static{
		try{
			Class.forName(DBDRIVER);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ���췽����ʵ�����ʱ�������Ӷ���
	public DatabaseConnection() {
		try {
			this.con = (Connection) DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ֱ�ӷ���ʵ�����ʱ���������Ӷ���
	public Connection getConnection() {
		return this.con;
	}
	
	// �ر����Ӷ���
	public void close() {
		if (this.con != null) {
			try {
				this.con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
