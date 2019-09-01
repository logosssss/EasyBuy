package cn.easybuy.dao.product;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.entity.User;
import cn.easybuy.param.OrderDetailParam;
import cn.easybuy.param.ProductCategoryParam;
import cn.easybuy.utils.Params;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Created by bdqn on 2016/5/12.
 * addObject(UserAddress userAddress)
 * getRowList(params)
 * getRowCount(params)
 * getById(Integer id)
 * updateByQuery(params)
 */
@Repository
public interface ProductCategoryDao extends IBaseDao {
	/**
	 * 根据id删除商品
	 * @param parseLong
	 */
	void deleteById_Mybatis(Integer parseLong);//删除商品分类
	/**
	 * 根据条件查询商品列表
	 * @param param
	 */
	List<ProductCategory> queryProductCategorylist_Mybatis(ProductCategoryParam param);
	/**
	 * 根据id查询商品分类
	 * @param param
	 */
	ProductCategory queryProductCategoryById_Mybatis(Integer id);
	/**
	 * 添加商品分类
	 * @param param
	 */
	Integer add_Mybatis(ProductCategory productCategory);
	/**
	 * 根据参数查询商品分类的数目
	 * @param param
	 */
	Integer queryProductCategoryCount_Mybatis(ProductCategoryParam param);
	/**
	 * 修改商品分类
	 * @param param
	 */
	void update_Mybatis(ProductCategory productCategory);
}
