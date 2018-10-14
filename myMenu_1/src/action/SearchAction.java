//menuListを検索するクラス
package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Menu;
import dao.MenuDAO;
import tool.Action;

public class SearchAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws Exception{

		HttpSession session = request.getSession();

		//受け取ったキーワードからmenuListを検索しlist配列へ格納しセッション属性へ渡す
		String keyword = request.getParameter("keyword");
		if(keyword == null) keyword = "";

		MenuDAO dao = new MenuDAO();
		List<Menu> list = dao.search(keyword);

		session.setAttribute("list", list);

		return "menuList.jsp";
	}
}
