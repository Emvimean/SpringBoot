package com.sengmean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sengmean.model.Article;
import com.sengmean.service.ArticleService;

@Controller
public class ArticleController {

	private ArticleService articleService;

	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String homepage(ModelMap model) {
		List<Article> articles = articleService.findAll();
		model.addAttribute("articles", articles);
		return "article";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/article/articleId", method = RequestMethod.GET)
	public String detailpage(ModelMap model, @RequestParam("id") Integer id) {
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articleDetail";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/article/view/{id}", method = RequestMethod.GET)
	public String detailpages(ModelMap model, @PathVariable("id") Integer id) {
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articleDetail";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/article/update/{id}")
	public String addArticlePage(ModelMap model, @PathVariable("id") Integer id) {
		model.addAttribute("article", articleService.findOne(id));
		model.addAttribute("addStatus", false);
	//	return "updateArticle";
		return "addArticle";
	}

	/**
	 * 
	 * @param article
	 * @param result
	 * @return
	 */
	@PostMapping("/article/update")
	public String actionUpdate(Article article, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/article/edit/" + article.getId();
		}
		if (articleService.update(article)) {
			System.out.println("Update Successfull..!");
		}
		return "redirect:/article";
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/article/add")
	public String addArticlePage(ModelMap model) {
		model.addAttribute("article", new Article());
		
		model.addAttribute("addStatus", true);
		return "addArticle";
	}

	/**
	 * 
	 * @param article
	 * @param result
	 * @return
	 */
	@PostMapping("/article/save")
	public String actionSave(Article article, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().getDefaultMessage());
			return "redirect:/article/add";
		}
		if (articleService.save(article)) {
			System.out.println("Successful..!");
		}
		return "redirect:/article";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/article/remove/{id}")
	public String removePage(ModelMap model, @PathVariable("id") Integer id) {
		if (articleService.delete(id))
			System.out.println("Successfull..!");
		else
			System.out.println("Faile..!");
		return "redirect:/article";
	}
}
