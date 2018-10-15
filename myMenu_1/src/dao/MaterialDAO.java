package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Material;

public class MaterialDAO extends DAO{

	public void insert(Material m) throws Exception{
		Connection con = getConnection();
		con.setAutoCommit(false);

		//受け取ったMaterialBeanをshoppingListへinsertする
		PreparedStatement st = con.prepareStatement("insert into shopping_list values(?, ?, ?)");
		st.setString(1, m.getName());
		st.setDouble(2, m.getQuantity());
		st.setString(3, m.getData());
		int line = st.executeUpdate();

		if(line>0) {
			con.commit();
			System.out.println("追加されました");
		}else {
			con.rollback();
			System.out.println("失敗しました");
		}

		con.setAutoCommit(true);
		st.close();
		con.close();
	}

	//shoppingListを種類ごとにまとめてMaterial配列へ格納しreturn
	public List<Material> getList()throws Exception{

		List<Material> mat = new ArrayList<Material>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select name, sum(quantity), data from shopping_list group by name");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Material m = new Material();
			m.setName(rs.getString("name"));
			m.setQuantity(rs.getDouble("sum(quantity)"));
			m.setData(rs.getString("data"));
			mat.add(m);
		}
		st.close();
		con.close();
		return mat;
	}

	//shoppingList内のデータをすべて削除する
	public void delete()throws Exception{
		Connection con = getConnection();
		con.setAutoCommit(false);

		PreparedStatement st = con.prepareStatement("delete from shopping_list");
		int line = st.executeUpdate();

		if(line>0) {
			con.commit();
			System.out.println("削除しました");
		}else {
			con.rollback();
			System.out.println("失敗しました");
		}
		con.setAutoCommit(true);
		st.close();
		con.close();
	}
}
