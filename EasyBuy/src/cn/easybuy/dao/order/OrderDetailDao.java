package cn.easybuy.dao.order;
import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.OrderDetailParam;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 订单详细
 * Created by bdqn on 2016/5/8.
 */
@Repository
public interface OrderDetailDao extends IBaseDao {

    void add_Mybatis(OrderDetail detail);

	void deleteById_Mybatis(OrderDetail detail);
	
	OrderDetail getOrderDetailById_Mybatis(@Param("id")Integer id);
	
	List<OrderDetail> getOrderDetailList_Mybatis(@Param("orderId")Integer orderId);
	
	Integer queryOrderDetailCount_Mybatis(OrderDetailParam params);
}
