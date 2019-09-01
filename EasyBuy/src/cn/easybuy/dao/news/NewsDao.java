package cn.easybuy.dao.news;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

/**
 * 新闻的dao
 */
@Repository
public interface NewsDao extends IBaseDao {
	/**
	 * 添加新闻
	 * @param news
	 * @throws Exception
	 */
	void add_Mybatis(News news);
	/**
	 * 修改新闻
	 * @param news
	 * @throws Exception
	 */
	
	void update_Mybatis(News news);
	/**
	 * 根据id删除新闻
	 * @param id
	 * @throws Exception
	 */
	void deleteById_Mybatis(Integer id);
	/**
	 * 根据id查询新闻
	 * @param id
	 * @return
	 * @throws Exception
	 */
	News getNewsById_Mybatis(Integer id); 
	/**
	 * 查询新闻列表
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<News> queryNewsList_Mybatis(NewsParams params); 
	/**
	 * 查询新闻的数目
	 * @param params
	 * @return
	 * @throws Exception
	 */
	Integer queryNewsCount_Mybatis(NewsParams params);
}
