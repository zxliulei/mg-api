package com.ichunming.mg.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ichunming.mg.common.constant.ErrorCode;
import com.ichunming.mg.entity.vo.BaseResult;
import com.ichunming.mg.model.Article;
import com.ichunming.mg.model.Page;
import com.ichunming.mg.service.ArticleService;


@Controller
@ResponseBody

public class ArticleController {
   @Autowired
   private ArticleService articleservice;
   
   @RequestMapping(value = "/article/post", method = {RequestMethod.POST, RequestMethod.GET}, headers = "Accept=application/json;charset=UTF-8", produces = { "application/json;charset=UTF-8" })
   public BaseResult articlePost(String title,String introduce,String content,String tag,HttpServletRequest request ){
	   Article articleinfo=new Article();
	   String author=(String) request.getSession().getAttribute("name");
	   articleinfo.setAuthor(author);
	   articleinfo.setContent(content);
	   articleinfo.setIntroduce(introduce);
	   articleinfo.setTitle(title);
	   articleinfo.setTag(tag);
	   articleinfo.setLikecnt(0);
	   articleinfo.setReplycnt(0);
	   articleinfo.setViewcnt(0);
	   articleinfo.setStatus(1);
	   articleservice.ArticleInsert(articleinfo);
	   return new BaseResult(ErrorCode.SUCCESS);
	   }
   @RequestMapping(value = "/article/update", method = {RequestMethod.POST, RequestMethod.GET}, headers = "Accept=application/json;charset=UTF-8", produces = { "application/json;charset=UTF-8" })
   public BaseResult articleUpdate(String id,String title,String introduce,String content,String tag ){
	   Article articleinfo=new Article();
	   articleinfo.setId(Long.valueOf(id));
	   articleinfo.setIntroduce(introduce);
	   articleinfo.setTitle(title);
	   articleinfo.setContent(content);
	   int i=articleservice.updateArticle(articleinfo);
	   if (i==0) {
		   return new BaseResult(ErrorCode.ERR_ARTICLE_OPTION_ERROR);
	    } else {
	    	return new BaseResult(ErrorCode.SUCCESS);
	    	}
	    }
   @RequestMapping(value = "/article/delete", method = {RequestMethod.POST, RequestMethod.GET}, headers = "Accept=application/json;charset=UTF-8", produces = { "application/json;charset=UTF-8" })
   public BaseResult articleDelete(String id){
	   int i=articleservice.deleteArticle(Long.valueOf(id));
	   if (i==0) {
		   return new BaseResult(ErrorCode.ERR_ARTICLE_OPTION_ERROR);
	    } else {
	    	return new BaseResult(ErrorCode.SUCCESS);
	    	}
	    }
   @RequestMapping(value = "/article/detail", method = {RequestMethod.POST, RequestMethod.GET}, headers = "Accept=application/json;charset=UTF-8", produces = { "application/json;charset=UTF-8" })
   public BaseResult articleDetail(String id ){
	   Article articleinfo=articleservice.getArticle(Long.valueOf(id));
	   if (articleinfo == null) {
		   return new BaseResult(ErrorCode.ERR_ARTICLE_OPTION_ERROR);
	    } else {
	    	return new BaseResult(ErrorCode.SUCCESS,articleinfo);
	    	}
	    }
   @RequestMapping(value = "/article/list", method = {RequestMethod.POST, RequestMethod.GET}, headers = "Accept=application/json;charset=UTF-8", produces = { "application/json;charset=UTF-8" })
   public BaseResult articleList(String queryType,String pageNum){
	   Page page= new Page();
	   page.setPageNum(Integer.valueOf(pageNum));
	   page=articleservice.getArticleList(page);
       return new BaseResult(ErrorCode.SUCCESS,page);
       }

}
