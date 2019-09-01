package cn.easybuy.service.product;
import java.sql.Connection;
import java.util.List;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.MyBatisUtil;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.easybuy.entity.Product;
/**
 * 商品的业务类
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	private Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public boolean add(Product product) {
		return productDao.add_Mybatis(product)>0;
	}

	@Override
	public boolean update(Product product) {
		return productDao.update_Mybatis(product)>0;
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		return productDao.deleteProductById_Mybatis(productId)>0;
	}

	@Override
	public Product getProductById(Integer productId) {
		return productDao.getProductById_MyBatis(productId);
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName, Integer categoryId, Integer level) {
		return productDao.getProductList_Mybatis((currentPageNo-1)*pageSize, pageSize, proName, categoryId, level);
	}

	@Override
	public int count(String proName,Integer categoryId, Integer level) {
		return productDao.queryProductCount_Mybatis(proName, categoryId, level);
	}

	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		return productDao.updateStock_Mybatis(productId, stock)>0;
	}
   
}
