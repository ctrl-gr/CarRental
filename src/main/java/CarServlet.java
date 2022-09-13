import com.carrental.dao.CarDao;
import com.carrental.dao.UserDao;
import com.carrental.entities.Car;
import com.carrental.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the data from the class (model)
        CarDao carDao = new CarDao();
        List<Car> cars = carDao.getCars();
        // add the data to request object
        request.setAttribute("carList", cars);
        //get the request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("car.jsp");
        // forward to JSP
        dispatcher.forward(request, response);
    }
}



