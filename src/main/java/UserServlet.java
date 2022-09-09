import com.carrental.dao.UserDao;
import com.carrental.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the user data from the class (model)
        UserDao userDao = new UserDao();
        List<User> users = userDao.getUsers();
        // add the students to request object
        request.setAttribute("userList", users);
        //get the request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("User.jsp");
        // forward to JSP
        dispatcher.forward(request, response);
    }
}
