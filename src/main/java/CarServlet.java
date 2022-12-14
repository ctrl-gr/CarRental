import com.carrental.dao.CarDao;
import com.carrental.dao.UserDao;
import com.carrental.entities.Car;
import com.carrental.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {

    private CarDao carDao = new CarDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {

                case "saveCar":
                    saveCar(request, response);
                    break;
                case "updateCar":
                    updateCar(request, response);
                    break;

                case "showAvailableCars":
                    showAvailableCars(request, response);
                    break;
                default:
                    throw new Exception();
            }

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void saveCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String licensePlate = request.getParameter("licensePlate");
        String manufacturer = request.getParameter("manufacturer");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        String type = request.getParameter("type");
        int seats = Integer.parseInt(request.getParameter("seats"));

        Car newCar = new Car(licensePlate, manufacturer, model, year, type, seats);
        carDao.saveCar(newCar);
        response.sendRedirect("carSuccess.jsp");

    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("carId"));
        String licensePlate = request.getParameter("licensePlate");
        String manufacturer = request.getParameter("manufacturer");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        String type = request.getParameter("type");
        int seats = Integer.parseInt(request.getParameter("seats"));

        Car existingCar = new Car(id, licensePlate, manufacturer, model, year, type, seats);
        carDao.updateCar(existingCar);
        response.sendRedirect("CarServlet?action=listCar");
    }

    private void showAvailableCars(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), formatter);
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), formatter);
        request.setAttribute("username", username);
        request.setAttribute("availableCars", carDao.getAvailableCars(startDate, endDate));
        request.setAttribute("startDate", request.getParameter("startDate"));
        request.setAttribute("endDate", request.getParameter("endDate"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("showAvailableCars.jsp");
        dispatcher.forward(request, response);

    }


    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {

                case "newCar":
                    showNewForm(request, response);
                    break;
                case "editCar":
                    showEditForm(request, response);
                    break;
                case "getAvailableCars":
                    getAvailableCars(request, response);
                    break;
                case "deleteCar":
                    deleteCar(request, response);
                    break;
                default:
                    listCar(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Car> listCar = carDao.getCars();
        request.setAttribute("listCar", listCar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carList.jsp");
        dispatcher.forward(request, response);
    }

    private void getAvailableCars(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        response.sendRedirect("getAvailableCars.jsp?username=" + username);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("carForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car existingCar = carDao.getCar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carEditForm.jsp");
        request.setAttribute("car", existingCar);
        dispatcher.forward(request, response);

    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carDao.deleteCar(id);
        response.sendRedirect("CarServlet?action=listCar");
    }

}




