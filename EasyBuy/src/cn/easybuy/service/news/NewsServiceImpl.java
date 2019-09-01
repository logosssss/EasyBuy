package cn.easybuy.service.news;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.MyBatisUtil;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;

/**
 *
 */
@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newDao;
	
	public void deleteNews(String id) {// 删除新闻
		 newDao.deleteById_Mybatis(Integer.parseInt(id));
	}

	public News findNewsById(String id) {// 根据ID获取新闻
		return newDao.getNewsById_Mybatis(Integer.parseInt(id));
	}

	public void addNews(News news) {// 保存新闻
		newDao.add_Mybatis(news);
	}

	public void updateNews(News news) {// 更新新闻
		newDao.update_Mybatis(news);
	}

	
	public List<News> queryNewsPageList(NewsParams param) throws SQLException {
		return newDao.queryNewsList_Mybatis(param);
	}
	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		return newDao.queryNewsList_Mybatis(param);
	}

	@Override
	public Integer queryNewsCount(NewsParams param) {
		return newDao.queryNewsCount_Mybatis(param);
	}

}
