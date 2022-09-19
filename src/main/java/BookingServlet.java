import com.carrental.dao.CarDao;
import com.carrental.dao.BookingDao;
import com.carrental.dao.UserDao;
import com.carrental.entities.Booking;
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

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {

    private BookingDao bookingDao = new BookingDao();

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarDao carDao = new CarDao();
        UserDao userDao = new UserDao();

        User user = userDao.getUserByUsername(request.getParameter("username"));
        Car car = carDao.getCarByLicensePlate(request.getParameter("licensePlate"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), formatter);
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), formatter);


        Booking booking = new Booking(user, car, startDate, endDate, true);
        bookingDao.saveBooking(booking);

        response.sendRedirect("bookingSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {
                case "newBooking":
                    showNewForm(request, response);
                    break;

                case "deleteBooking":
                    deleteBooking(request, response);
                    break;

                default:
                    listBooking(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Booking> listBooking = bookingDao.getBookings();
        request.setAttribute("listBooking", listBooking);
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookingList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookingForm.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookingDao.deleteBooking(id);
        response.sendRedirect("listBooking");
    }
}



