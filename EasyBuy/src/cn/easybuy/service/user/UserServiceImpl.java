package cn.easybuy.service.user;
import java.sql.SQLException;
import java.util.List;
import cn.easybuy.dao.user.UserDao;
import cn.easybuy.utils.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.easybuy.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean add(User user){
		return userDao.add_Mybatis(user)>0;
	}

	@Override
	public boolean update(User user) {
		return userDao.update_Mybatis(user)>0;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		return userDao.deleteUserById_Mybatis(userId.toString())>0;
	}

	@Override
	public User getUser(Integer userId, String loginName) {
		return userDao.getUser_Mybatis(userId, loginName);
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		return userDao.getUserList_Mybatis((currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public int count() {
		return userDao.count();
	}
}
