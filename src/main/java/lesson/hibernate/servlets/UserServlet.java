package lesson.hibernate.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lesson.hibernate.dao.UserDao;
import lesson.hibernate.entity.UserEntity;
import lesson.hibernate.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        UserDao userDao = new UserDao();
        userService = new UserService(userDao);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            List<UserEntity> users = userService.getListOfUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/user-list.jsp").forward(request, response);
        } else if (pathInfo.equals("/add")) {
            request.getRequestDispatcher("/user-add.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && pathInfo.equals("/add")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            UserEntity user = UserEntity.builder()
                .name(name)
                .email(email)
                .build();

            userService.addOrUpdateUser(user);
        }
        response.sendRedirect(request.getContextPath() + "/users");
    }
}
