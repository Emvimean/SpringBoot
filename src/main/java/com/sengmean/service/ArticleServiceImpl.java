package com.sengmean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sengmean.model.Article;
import com.sengmean.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article findOne(int id) {
		return articleRepository.findOne(id);
	}

	@Override
	public Boolean save(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Boolean delete(int id) {
		return articleRepository.delete(id);
	}
	@Override
	public Boolean update(Article article) {
		return articleRepository.update(article);
	}

}
