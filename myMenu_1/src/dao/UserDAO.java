package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

//受けとったユーザIDとパスワードでuserListを検索し
//取得したidとpassをUserBeanへ格納する
public class UserDAO extends DAO {
	public User search(String id, String pass)throws Exception{
		User user = null;

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from user_list where id=? and pass=?");
		st.setString(1, id);
		st.setString(2, pass);
		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setPass(rs.getString("pass"));
		}
		st.close();
		con.close();
		return user;
 	}
}
