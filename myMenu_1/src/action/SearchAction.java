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

		String keyword = request.getParameter("keyword");
		if(keyword == null) keyword = "";

		MenuDAO dao = new MenuDAO();
		List<Menu> list = dao.search(keyword);

		session.setAttribute("list", list);

		return "menuList.jsp";
	}
}
