package servlet;

import bean.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroEditServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));
        Hero hero = new HeroDao().get(id);  // 获取hero对象
        StringBuffer fmt = new StringBuffer();
        resp.setContentType("text/html;charset=utf-8");

        fmt.append("<!DOCTYPE html>");

        fmt.append("<form action='updateHero' method='post'>");
        fmt.append("name: <input type='text' name='name' value=%s > <br>");
        fmt.append("hp: <input type='text' name='hp' value=%f > <br>");
        fmt.append("damage <input type='text' name='damage' value=%d > <br>");
        fmt.append("<input type='hidden' name='id' value=%d>");
        fmt.append("<input type='submit' value='update'>");
        fmt.append("</form");

        String html = String.format(fmt.toString(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId());

        resp.getWriter().write(html);


    }
}
