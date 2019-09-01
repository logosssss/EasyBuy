package cn.easybuy.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis的工具类
 * @author 86185
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory factory;//工厂函数
	
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");//读取配置文件
			factory = new SqlSessionFactoryBuilder().build(is);//获取factory对象
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建SqlSession的方�?
	 * @return
	 */
	public static SqlSession createSqlSession(){
		return factory.openSession(false);
	}
	
	/**
	 * 关闭SqlSession的方�?
	 * @param sqlSession
	 */
	public static void closeSqlSession(SqlSession sqlSession){
		if(null!=sqlSession){
			sqlSession.close();
		}
	}
}
