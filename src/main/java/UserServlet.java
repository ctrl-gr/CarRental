import com.carrental.dao.UserDao;
import com.carrental.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {

                case "saveUser":
                    saveUser(request, response);
                    break;
                case "saveUserFromUser":
                    saveUserFromUser(request, response);
                    break;
                case "updateUser":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }
    private void saveUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"), formatter);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User(firstName, lastName, birthDate, username, password);
        userDao.saveUser(newUser);
        response.sendRedirect("userSuccess.jsp");
    }

    private void saveUserFromUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"), formatter);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User(firstName, lastName, birthDate, username, password);
        userDao.saveUser(newUser);
        response.sendRedirect("userSuccessUser.jsp");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"), formatter);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(id, firstName, lastName, birthDate, username, password);

        userDao.updateUser(user);
        response.sendRedirect("UserServlet?action=listUser");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {
                case "newUserFromUser":
                    showNewForm(request, response);
                    break;
                case "newUserFromAdmin":
                    showNewFormAdmin(request, response);
                    break;
                case "editUser":
                    showEditForm(request, response);
                    break;
                case "deleteUser":
                    deleteUser(request, response);
                    break;

                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<User> listUser = userDao.getUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userFormUser.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormAdmin(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("userFormAdmin.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editUserFormAdmin.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("UserServlet?action=listUser");
    }

}

