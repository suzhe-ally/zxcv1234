package WTU.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbc.DatabaseConnection;
import vo.Info;

public class InfoDao {
	public Info get(String number){
		Info info=null;
		DatabaseConnection dbc=new DatabaseConnection();
		Connection con=dbc.getConnection();
		try{
			String sql="select* from infoTable where number=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,number);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				info=new Info(rs.getString("begin"),rs.getString("sender"),rs.getString("senderPhone"),
						rs.getString("senderAddress"),rs.getString("receiver"),rs.getString("receiverPhone"),
						rs.getString("receiverAddress"),rs.getString("jibaodi"),rs.getString("number"));
			}
			}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return info;
	}

	
}
