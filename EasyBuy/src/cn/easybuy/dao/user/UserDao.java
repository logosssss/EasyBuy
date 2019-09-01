package cn.easybuy.dao.user;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.User;
import cn.easybuy.param.UserParam;

/***
 * UserDao 用户业务的dao层
 * 从父类继承下的被使用的方法
 * User getById(userId);
 * Integer userDao.getRowCount(params);
 * List<User> userDao.getRowList(params);
 */
@Repository
public interface UserDao extends IBaseDao {

	
	int add_Mybatis(User user);
	
	Integer count();
	
	int update_Mybatis(User user);//更新用户信息
	
	int deleteUserById_Mybatis(String id);
	
	List<User> getUserList_Mybatis(@Param("currentNo")Integer currentNo,@Param("pageSize")Integer pageSize);
	
	User getUser_Mybatis(@Param("id")Integer id,@Param("name")String loginName);

}
