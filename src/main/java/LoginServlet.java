import com.carrental.dao.UserDao;
import com.carrental.entities.Car;
import com.carrental.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {

                case "loginUser":
                    loginUser(request, response);
                    break;
                case "loginAdmin":
                    loginAdmin(request, response);
                    break;
                default:
                    loginNotSuccessful(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.getUserByUsername(username);
        int userId = user.getId();

        if (userDao.validate(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("userId", userId);
            response.sendRedirect("homepage.jsp?username=" + username);
        } else {

            response.sendRedirect("loginNotSuccessful.jsp");
        }

        out.close();
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userDao.validateAdmin(username, password)) {
            response.sendRedirect("adminHomepage.jsp");
        } else {
            response.sendRedirect("loginNotSuccessful.jsp");
        }

        out.close();
    }

    private void loginNotSuccessful(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        response.sendRedirect("loginNotSuccessful.jsp");
    }
}

