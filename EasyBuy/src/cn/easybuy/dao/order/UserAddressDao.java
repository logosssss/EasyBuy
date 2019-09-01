package cn.easybuy.dao.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;

/**
 * Created by bdqn on 2016/5/12.
 * addObject(UserAddress userAddress)
 * getRowList(params)
 */
@Repository
public interface UserAddressDao extends IBaseDao {
	
	List<UserAddress> queryUserAddressList_Mybatis(UserAddressParam param);
	
	Integer add_Mybatis(UserAddress userAddress);
	
	UserAddress getUserAddressById_Mybatis(Integer addressId);

}
