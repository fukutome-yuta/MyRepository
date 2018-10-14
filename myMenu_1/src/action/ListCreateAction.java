//買い物リストを作成するクラス
package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Material;
import dao.MaterialDAO;
import tool.Action;


public class ListCreateAction extends Action{
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		HttpSession session = request.getSession();
		List<Material> mt = (List<Material>)session.getAttribute("mt");

		MaterialDAO dao= new MaterialDAO();

		//shoppintListを一旦リセット
		dao.delete();

		//セッション属性から受け取った食材リストをshoppingListへInsertする
		for(Material m : mt) {
			dao.insert(m);
		}

		//作成したshoppingListを取得しセッション属性へ渡す
		List<Material> mtlist = dao.getList();

		session.setAttribute("mtlist", mtlist);

		return "shoppingList.jsp";
	}
}
