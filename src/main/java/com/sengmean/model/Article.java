/**
 * 
 */
package com.sengmean.model;

import java.util.List;

/**
 * @author lenovo
 *
 */
public class Article {

	private int id;
	private String title;
	private String description;
	private String thumbnail;
	private List<String> images;
	
	public Article() {}

	public Article(int id, String title, String description, String thumbnail, List<String> images) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", thumbnail=" + thumbnail
				+ ", images=" + images + "]";
	}
		
}
