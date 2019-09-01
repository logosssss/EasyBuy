package cn.easybuy.web.pre;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by bdqn on 2016/4/25.
 */
@WebServlet(urlPatterns = {"/News"}, name = "News")
public class NewsServlet extends AbstractServlet {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    private NewsService newsService;

    public void init() throws ServletException {
        newsService = (NewsService) ctx.getBean("newsService");
    }

    @Override
    public Class getServletClass() {
        return NewsServlet.class;
    }

    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "/pre/newsList";
    }

}
