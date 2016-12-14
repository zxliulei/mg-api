package com.ichunming.mg.dao;

import java.util.List;

import com.ichunming.mg.model.Article;
import com.ichunming.mg.model.Page;

public interface ArticleDao extends GenericDao<Article, Long> {
	public Article getArticle(long id);
	public List<Article> queryArticleList(Page page);
	public String queryallpage();
	
}