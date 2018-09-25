package com.sengmean.repository;

import java.util.List;

//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Select;

import com.sengmean.model.Article;

public interface ArticleRepository {

	//@Select("SELECT * FROM article")
	List<Article> findAll();
	
	Article findOne(int id);
	
	//@Insert("INSERT INTO article(id, title, description, thumbnail) VALUES(#{id}, #{title}, #{description}, #{thumbnail}")
	Boolean save(Article article);
	
	Boolean delete(int id);
	
	Boolean update(Article article);
}
