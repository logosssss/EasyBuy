package cn.easybuy.web.pre;

import cn.easybuy.service.user.UserAddressService;
import cn.easybuy.service.user.UserAddressServiceImpl;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bdqn on 2016/5/12.
 */
public class UserAdressServlet extends AbstractServlet {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    private UserAddressService userAddressService;

    public void init() throws ServletException {
        userAddressService = (UserAddressService) ctx.getBean("userAddressService");
    }

    @Override
    public Class getServletClass() {
        return UserAdressServlet.class;
    }
}
