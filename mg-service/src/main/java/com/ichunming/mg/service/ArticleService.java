package com.ichunming.mg.service;

import java.util.List;

import com.ichunming.mg.model.Article;
import com.ichunming.mg.model.Page;

public interface ArticleService {
	public void ArticleInsert(Article article);
	public Article getArticle(long id);
	public int deleteArticle(long id);
	public int updateArticle(Article article);
	public Page getArticleList(Page article);
	public int queryAllPage();
	

}
