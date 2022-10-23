package servlet;

import bean.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroUpdateServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("utf-8");

        Hero hero = new Hero();
        hero.setId(Integer.parseInt(req.getParameter("id")));
        hero.setHp(Float.parseFloat(req.getParameter("hp")));
        hero.setDamage(Integer.parseInt(req.getParameter("damage")));
        hero.setName(req.getParameter("name"));
        System.out.println(hero.getName());
        new HeroDao().update(hero);

        resp.sendRedirect(req.getContextPath() + "/listHero");
    }
}
