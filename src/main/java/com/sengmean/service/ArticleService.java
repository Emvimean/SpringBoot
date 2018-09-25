package com.sengmean.service;

import java.util.List;

import com.sengmean.model.Article;

public interface ArticleService {

	List<Article> findAll();
	
	Article findOne(int id);
	
	Boolean save(Article article);
	
	Boolean delete(int id);
	
	Boolean update(Article article);
}
