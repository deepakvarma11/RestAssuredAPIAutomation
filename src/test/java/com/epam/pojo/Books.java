package com.epam.pojo;

public class Books {

	private long isbn;
	private String title;
	private String subTitle;
	private String author;
	private String publish;
	private String publisher;
	private long pages;
	private String description;
	private String website;

	public Books(long isbn, String title, String subTitle, String author, String publish, String publisher, long pages,
			String description, String website) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.subTitle = subTitle;
		this.author = author;
		this.publish = publish;
		this.publisher = publisher;
		this.pages = pages;
		this.description = description;
		this.website = website;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", title=" + title + ", subTitle=" + subTitle + ", author=" + author
				+ ", publish=" + publish + ", publisher=" + publisher + ", pages=" + pages + ", description="
				+ description + ", website=" + website + "]";
	}

}
