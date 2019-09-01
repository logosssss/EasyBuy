package cn.easybuy.service.order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.easybuy.dao.order.*;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.utils.*;
import cn.easybuy.entity.Order;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.entity.User;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	@Qualifier("orderDao")
	private OrderDao orderDao;

	@Autowired
	@Qualifier("orderDetailDao")
	private OrderDetailDao orderDetailDao;

/*	@Autowired
	@Qualifier("productDao")
	private ProductDao ProductDao;*/

	/**
	 * 结算购物车物品包含以下步骤： 1.生成订单 2.生成订单明细 3.更新商品表，减库存 注意加入事物的控制
	 */
	@Override
	public Order payShoppingCart(ShoppingCart cart, User user, String address) {
		// TODO Auto-generated method stub
		Order order = new Order();
		// 增加订单
		order.setUserId(user.getId());
		order.setLoginName(user.getLoginName());
		order.setUserAddress(address);
		order.setCreateTime(new Date());
		order.setCost(cart.getTotalCost());
		order.setSerialNumber(StringUtils.randomUUID());
		orderDao.add_Mybatis(order);
		int id = orderDao.getOrderid();
		order.setId(id);
		// 增加订单对应的明细信息
		for (ShoppingCartItem item : cart.getItems()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(order.getId());
			orderDetail.setCost(item.getCost());
			orderDetail.setProduct(item.getProduct());
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setProductId(item.getProduct().getId());
			orderDetailDao.add_Mybatis(orderDetail);
			// 更新商品表的库存
			/*ProductDao.updateStock_Mybatis(item.getProduct().getId(), item.getQuantity());*/
		}
		return order;
	}

	@Override
	public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) {
		List<Order> orderList = new ArrayList<Order>();
		orderList = orderDao.getOrderList_Mybatis(userId, (currentPageNo - 1) * pageSize, pageSize);
		for (Order order : orderList) {
			orderDetailDao.getOrderDetailList_Mybatis(order.getId());
		}
		return orderList;
	}

	@Override
	public int count(Integer userId) {
		return orderDao.count_Mybatis(userId);
	}

	/**
	 * 调用dao接口：OrderDetailMapper的方法实现
	 */
	@Override
	public List<OrderDetail> getOrderDetailList(Integer orderId) {
		return orderDetailDao.getOrderDetailList_Mybatis(orderId);
	}
}
