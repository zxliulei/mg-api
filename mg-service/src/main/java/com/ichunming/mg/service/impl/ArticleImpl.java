package com.ichunming.mg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.mg.dao.ArticleDao;
import com.ichunming.mg.model.Article;
import com.ichunming.mg.model.Page;
import com.ichunming.mg.service.ArticleService;

@Service
public class ArticleImpl implements ArticleService {
	@Autowired
	private ArticleDao articledao;

	@Override
	public void ArticleInsert(Article article) {
		articledao.insert(article);

	}

	@Override
	public Article getArticle(long id) {
		Article article = articledao.getArticle(id);
		return article;
	}

	@Override
	public int deleteArticle(long id) {
		return articledao.delete(id);

	}

	@Override
	public int updateArticle(Article article) {
		return articledao.update(article);

	}

	@Override
	public Page getArticleList(Page page) {
		int total = queryAllPage();
		page.setPageSize(5);
		page.setTotal(total);
		int current=page.getPageNum();
		int pp= current < 1 ? 1 : current;
		page.setPageNum(pp);
		page.setStart((pp-1)*5+1);
		page.setEnd(pp*5);
		int pages = total / 5;
		int i = total % 5;
		pages = i == 0 ? pages : pages + 1;
		pages = pages==0 ? 1 : pages;
		page.setPages(pages);
		List<Article> aList=articledao.queryArticleList(page);
		page.setSize(aList.size());
		page.setResult(aList);
		return page;
	}

	@Override
	public int queryAllPage() {
		String total = articledao.queryallpage();
		return Integer.valueOf(total);
	}
}
