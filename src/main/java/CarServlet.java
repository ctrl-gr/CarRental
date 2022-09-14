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

@WebServlet("/CarServlet")
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

                case "insertCar":
                    insertCar(request, response);
                    break;

                case "deleteCar":
                    deleteCar(request, response);
                    break;
                case "editCar":
                    showEditForm(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
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

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car existingCar = carDao.getCar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carForm.jsp");
        request.setAttribute("car", existingCar);
        dispatcher.forward(request, response);

    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carDao.deleteCar(id);
        response.sendRedirect("list");
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
                case "updateCar":
                    updateCar(request, response);
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

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("carForm.jsp");
        dispatcher.forward(request, response);
    }


    private void updateCar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String licensePlate = request.getParameter("licensePlate");
        String manufacturer = request.getParameter("manufacturer");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        String type = request.getParameter("type");
        int seats = Integer.parseInt(request.getParameter("seats"));

        Car newCar = new Car(licensePlate, manufacturer, model, year, type, seats);

        carDao.updateCar(newCar);
        response.sendRedirect("carList.jsp");
    }

}




