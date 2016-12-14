package com.ichunming.mg.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.ichunming.mg.model.Article;
import com.ichunming.mg.model.Page;

public class ArticleTest extends BaseTest {
/*	@Test
	public void insert(){
		ArticleDao articleDao=sqlSession.getMapper(ArticleDao.class);
		Article ss=new Article();
    	ss.setAuthor("刘磊");
    	ss.setTitle("2");
    	ss.setContent("xuexisadsadsadsa2312412412");
    	ss.setIntroduce("SB");
    	ss.setTag("weizhi");
    	ss.setLikecnt(0);
    	ss.setReplycnt(0);
    	ss.setViewcnt(0);
		ss.setStatus(1);
		articleDao.insert(ss);
		Article article=articleDao.getArticle(4);
		assertNotNull(article);
		assertEquals("刘磊",article.getAuthor());
		
	}
	@Test
	public void update(){
		ArticleDao articleDao=sqlSession.getMapper(ArticleDao.class);
		Article ss=new Article();
		ss.setId(Long.valueOf(4));
    	ss.setTitle("3");
    	ss.setContent("xuexisdsadasdadsadsadsa2312412412");
    	ss.setIntroduce("nijiushiSB");
    	ss.setTag("weizhi");
		articleDao.update(ss);
		Article article=articleDao.getArticle(4);
		assertNotNull(article);
		assertEquals("3",article.getTitle());
		
	}
	
	@Test
	public void zdelete(){
		ArticleDao articleDao=sqlSession.getMapper(ArticleDao.class);
		articleDao.delete(Long.valueOf(4));
		Article article=articleDao.getArticle(4);
		assertNull(article);
		
	}*/
	
	@Test
	public void zqueryList(){
		ArticleDao articleDao=sqlSession.getMapper(ArticleDao.class);
		Page page=new Page();
		page.setPageSize(5);
		page.setPageNum(2);
		page.setStart((page.getPageNum()-1)*page.getPageSize()+1);
		page.setEnd(page.getPageNum()*page.getPageSize());
		List<Article> ll=articleDao.queryArticleList(page);
		for (Article article : ll) {
			System.out.println(article.getId());
		}
		String i=articleDao.queryallpage();
		System.out.println(i);
		assertNotNull(i);
		
	}

}
