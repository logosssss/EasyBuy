package cn.easybuy.service.user;

import cn.easybuy.dao.order.UserAddressDao;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.MyBatisUtil;
import cn.easybuy.utils.Params;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bdqn on 2016/5/12.
 */
@Service("userAddressService")
@Transactional
public class UserAddressServiceImpl implements UserAddressService {

	@Autowired
	private UserAddressDao userAddressDao;

	/**
	 * 查询用户地址列表
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<UserAddress> queryUserAdressList(Integer id) throws Exception {
		UserAddressParam params = new UserAddressParam();
		params.setUserId(id);
		return userAddressDao.queryUserAddressList_Mybatis(params);
	}

	/**
	 * 添加用户地址
	 *
	 * @param id
	 * @param address
	 * @return
	 */
	@Override
	public Integer addUserAddress(Integer id, String address, String remark) {
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(id);
		userAddress.setAddress(address);
		userAddress.setRemark(remark);
		return userAddressDao.add_Mybatis(userAddress);
	}

	@Override
	public UserAddress getUserAddressById(Integer id) {
		return userAddressDao.getUserAddressById_Mybatis(id);
	}
}
