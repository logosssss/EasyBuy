package cn.easybuy.dao.order;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Order;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.OrderParams;

/***
 * 订单处理的dao层
 * getRowCount
 * getRowList(Params params)
 * getById(Integer id)
 * addObject(Params params)
 */
@Repository
public interface OrderDao extends IBaseDao {

	void add_Mybatis(Order order);

	void deleteById_Mybatis(@Param("id")Integer id);
	
	Order getOrderById_Mybatis(@Param("id")Integer id);
	
	List<Order> getOrderList_Mybatis(@Param("userId")Integer userId,@Param("currentNo")Integer currentNo,@Param("pageSize")Integer pageSize);
	
	int count_Mybatis(@Param("userId")Integer userId);
	
	int getOrderid();
}
