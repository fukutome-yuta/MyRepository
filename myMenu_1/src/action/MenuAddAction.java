//shoppingListの作成および追加するクラス
package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Material;
import bean.Menu;
import dao.MenuDAO;
import tool.Action;

public class MenuAddAction extends Action {

	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response)throws Exception{

		HttpSession session = request.getSession();

		//選択されたメニューのidを配列へ格納しInt型へ変換
		String[] name = request.getParameterValues("id");
		int[] id = new int[name.length];
		for(int i = 0; i < name.length; i++) {
			id[i] = Integer.parseInt(name[i]);
		}

		//getしたセッション属性のmenus配列がnullなら新たに配列を作成
		List<Menu> menus = (List<Menu>)session.getAttribute("menus");
		if(menus == null) {
			menus = new ArrayList<Menu>();
			session.setAttribute("menus", menus);
		}

		//getしたセッション属性のmt配列がnullなら新たに配列を作成

		List<Material> mt = (List<Material>)session.getAttribute("mt");
		if(mt == null) {
			mt = new ArrayList<Material>();
			session.setAttribute("mt", mt);
		}

		//受け取ったidのメニューを取り出しmenus配列へ格納しセッション属性ヘ渡す
		if(id != null) {
			MenuDAO dao = new MenuDAO();
			for(int i = 0; i < id.length; i++) {
				Menu menu = dao.menuList(id[i]);
				menus.add(menu);
			}

			//shoppingLIstを作成
			for(int i = 0; i < id.length; i++) {
				List<Material> m1 = dao.shoppingList(id[i]);
				//shoppingListが無ければセッション属性へ格納
				if(mt == null) {
					session.setAttribute("mt", mt);
				//すでにshoppingListがあればそこへ追加する
				}else {
					for(Material m : m1) {
						mt.add(m);
					}
				}
			}
		}

		return "menuShoppingList.jsp";
	}

}
