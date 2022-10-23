package servlet;

import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroDeleteServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        int id = Integer.parseInt(req.getParameter("id"));
        new HeroDao().delete(id);

        System.out.println("test");
        resp.sendRedirect(req.getContextPath()+"/listHero");
    }
}
