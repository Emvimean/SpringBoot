package com.sengmean.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.sengmean.model.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
	
	private List<Article> articles;
	
	@Autowired
	public ArticleRepositoryImpl() {
		Faker faker = new Faker(Locale.ENGLISH);
		articles = new ArrayList<Article>();
		for (int i = 1; i <=20; i++) {
			Article article = new Article();
			article.setId(i);
			article.setTitle(faker.book().title());
			article.setDescription(faker.lorem().sentence());
			article.setThumbnail("https://wallpaperbrowse.com/media/images/3848765-wallpaper-images-download.jpg");
			articles.add(article);
		}
		
	}

	@Override
	public List<Article> findAll() {
		return articles;
	}

	@Override
	public Article findOne(int id) {
		return articles.get(id);
	}

	@Override
	public Boolean save(Article article) {
		return articles.add(article);
		
	}

	@Override
	public Boolean delete(int id) {
		for (Article article: articles) {
			if (article.getId() == id) {
				articles.remove(article);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public Boolean update(Article article) {
		for (int i=1; i<articles.size(); i++) {
			if (article.getId() == articles.get(i).getId()) {
				articles.set(i, article);
				return true;
			}
		}
		return false;
	}

}
