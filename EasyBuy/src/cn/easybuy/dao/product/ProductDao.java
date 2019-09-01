package cn.easybuy.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.ProductParam;

/**
 * 商品查询Dao
 *
 * deleteById(Integer id)
 * getById(Integer id)
 * getRowCount(params)
 * getRowList(params)
 *
 */
@Repository
public interface ProductDao extends IBaseDao {

	Integer updateStock_Mybatis(@Param("id")Integer id, @Param("quantity")Integer quantity);
	
	Integer add_Mybatis(Product product);

	Integer update_Mybatis(Product product);
	
	Integer deleteProductById_Mybatis(Integer id);
	
	Product getProductById_MyBatis(Integer id);
	
	List<Product> getProductList_Mybatis(@Param("currentNo")Integer currentPageNo,@Param("pageSize")Integer pageSize,@Param("proName")String proName,@Param("categoryId")Integer categoryId,@Param("level")Integer level);
	
	Integer queryProductCount_Mybatis(@Param("proName")String proName,@Param("categoryId")Integer categoryId,@Param("level")Integer level);
}
