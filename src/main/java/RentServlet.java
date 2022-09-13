import com.carrental.dao.RentDao;
import com.carrental.dao.UserDao;
import com.carrental.entities.Rent;
import com.carrental.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RentServlet", value = "/RentServlet")
public class RentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the data from the class (model)
        RentDao rentDao = new RentDao();
        List<Rent> rents = rentDao.getRents();
        // add the data to request object
        request.setAttribute("rentList", rents);
        //get the request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("rent.jsp");
        // forward to JSP
        dispatcher.forward(request, response);
        }
    }

