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

		String[] name = request.getParameterValues("id");
		int[] id = new int[name.length];
		for(int i = 0; i < name.length; i++) {
			id[i] = Integer.parseInt(name[i]);
		}

		List<Menu> menus = (List<Menu>)session.getAttribute("menus");
		if(menus == null) {
			menus = new ArrayList<Menu>();
			session.setAttribute("menus", menus);
		}

		List<Material> mt = (List<Material>)session.getAttribute("mt");
		if(mt == null) {
			mt = new ArrayList<Material>();
			session.setAttribute("mt", mt);
		}

		if(id !=null) {
			MenuDAO dao = new MenuDAO();
			for(int i = 0; i < id.length; i++) {
				Menu menu = dao.menuList(id[i]);
				menus.add(menu);
			}

			for(int i = 0; i < id.length; i++) {
				List<Material> m1 = dao.shoppingList(id[i]);
				if(mt == null) {
					session.setAttribute("mt", mt);
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
