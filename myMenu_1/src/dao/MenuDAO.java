package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Material;
import bean.Menu;

public class MenuDAO extends DAO {

	List<Menu> list = new ArrayList<>();
	//menuListすべてを取得しMenuBeanへ格納する
	public List<Menu> allList() throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from mydb.menu_list");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Menu menu = new Menu();
			menu.setId(rs.getInt("id"));
			menu.setName(rs.getString("name"));
			menu.setUrl(rs.getString("url"));
			list.add(menu);
		}
		st.close();
		con.close();
		return list;
	}
	//受け取ったキーワードをmenuListで検索し取得する
	public List<Menu> search(String keyword) throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from menu_list where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Menu menu = new Menu();
			menu.setId(rs.getInt("id"));
			menu.setName(rs.getString("name"));
			menu.setUrl(rs.getString("url"));
			list.add(menu);
		}
		st.close();
		con.close();
		return list;
	}
	//チェックリストでチェックされたメニューのIDからmenuListを検索し取得する
	public Menu menuList(int id) throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from menu_list where id=" + id);
		ResultSet rs = st.executeQuery();
		Menu menu = new Menu();

		if(rs.next()) {
			menu.setId(rs.getInt("id"));
			menu.setName(rs.getString("name"));
			menu.setUrl(rs.getString("url"));
		}
		st.close();
		con.close();
		return menu;
	}

	//食材ごとにまとめられたshoppingListをMaterialBeanへ格納する
	public List<Material> shoppingList(int id) throws Exception{

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select mt.name, mt.quantity, un.data from material_list as mt left join unit_list as un on mt.unit_id = un.unit_id where mt.mt_id=" + id);
		ResultSet rs = st.executeQuery();
		List<Material> mt= new ArrayList<Material>();

		while(rs.next()) {
			Material m = new Material();
			m.setName(rs.getString("name"));
			m.setQuantity(rs.getDouble("quantity"));
			m.setData(rs.getString("data"));
			mt.add(m);
		}
		st.close();
		con.close();
		return mt;

	}
}
