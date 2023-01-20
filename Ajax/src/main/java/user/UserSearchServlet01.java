package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class UserSearchServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public class UserSearch_Servlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String userName = request.getParameter("userName");
			response.getWriter().write(getJSON(userName));
			}
		
		public String getJSON(String userName) {
			if(userName == null) userName = "";
			StringBuffer result = new StringBuffer("");
			result.append("{\"result\":[");
			UserDAO userDAO = new UserDAO();
			ArrayList<User> userList = userDAO.search(userName);
			for(int i = 0; i< userList.size(); i++) {
				result.append("[{\"value\":\""+ userList.get(i).getUserName() + "\"},");
				result.append("{\"value\":\""+ userList.get(i).getUserAge() + "\"},");
				result.append("{\"value\":\""+ userList.get(i).getUserGender() + "\"},");
				result.append("{\"value\":\""+ userList.get(i).getUserEmail() + "\"}],");
			}
			result.append("]}");
			return result.toString();
		}

	}}
