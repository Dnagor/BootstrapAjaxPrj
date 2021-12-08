package servlets;

import com.bootstrapajaxprj.domain.User;
import com.bootstrapajaxprj.dto.UserLogin;
import com.bootstrapajaxprj.service.UserService;
import com.bootstrapajaxprj.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    private UserService userService = UserServiceImpl.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.readUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            UserLogin userLogin = new UserLogin();
            userLogin.destinationUrl = "cabinet.jsp";
            userLogin.userEmail = user.getEmail();
            String json = new Gson().toJson(userLogin);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
}
