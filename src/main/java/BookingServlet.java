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

    private final BookingDao bookingDao = new BookingDao();
    private final CarDao carDao = new CarDao();
    private final UserDao userDao = new UserDao();

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = "";

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        try {
            switch (action) {
                case "saveBooking":
                    saveBooking(request, response);
                    break;
                case "approveBooking":
                    approveBooking(request, response);
                    break;
                case "showMyBookings":
                    showMyBookings(request, response);
                    break;
                default:
                    listBooking(request, response);
                    break;
            }
            } catch(SQLException ex){
                throw new ServletException(ex);
            }
        }


    private void saveBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userDao.getUserByUsername(username);
        Car car = carDao.getCar(Integer.parseInt(request.getParameter("carId")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), formatter);
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), formatter);
        boolean isApproved = false;

        Booking booking = new Booking(user, car, startDate, endDate, isApproved);
        bookingDao.saveBooking(booking);

        response.sendRedirect("bookingSuccess.jsp");
    }

    private void approveBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("bookingId"));
        Car car = carDao.getCar(Integer.parseInt(request.getParameter("carId")));
        User user = userDao.getUser(Integer.parseInt(request.getParameter("userId")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), formatter);
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), formatter);
        boolean isApproved = true;

        Booking booking = new Booking(id, user, car, startDate, endDate, isApproved);
        bookingDao.updateBooking(booking);

        response.sendRedirect("bookingApproved.jsp");
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
                case "listApprovedBooking":
                    listApprovedBooking(request, response);
                    break;
                case "showMyBookings":
                    showMyBookings(request, response);
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

    private void showMyBookings(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String username = (String) request.getAttribute("username");
        User user = userDao.getUser(userId);
        List<Booking> myBookings = bookingDao.getBookingsByUser(user);
        request.setAttribute("BookingsByUser", myBookings);
        request.setAttribute("username", username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userBookingList.jsp?username=" + username);
        dispatcher.forward(request, response);

    }

    private void listApprovedBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Booking> listApprovedBooking = bookingDao.getBookings();
        request.setAttribute("listApprovedBooking", listApprovedBooking);
        RequestDispatcher dispatcher = request.getRequestDispatcher("approvedBookingList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookingForm.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookingDao.deleteBooking(id);
        response.sendRedirect("BookingServlet?action=listBooking");
    }
}



