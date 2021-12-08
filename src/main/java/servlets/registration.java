package servlets;

import com.bootstrapajaxprj.domain.User;
import com.bootstrapajaxprj.domain.UserRole;
import com.bootstrapajaxprj.service.UserService;
import com.bootstrapajaxprj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class registration extends HttpServlet {
    private UserService userService = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");

        if (!email.isEmpty() & !name.isEmpty() && !lastname.isEmpty() && !password.isEmpty()) {
            userService.create(new User(email, name, lastname, UserRole.USER.name(), password));
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success!");
    }
}
