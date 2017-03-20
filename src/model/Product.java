package model;

import java.util.Arrays;

/*
 * model for the all products in this rating system
 */
public class Product {

	private String name;
	private String imgFile;// name of the product image file
	private String authors;
	private int[] ratings=new int[5];// each rating count for a product
	private float averageRating;
	private int totalRating;// total number of rating
	private float price;
	private int paperBack;
	private String publisher;
	
	
	private String edition;
	private String pubDate;
	
	private String language;
	private String isbn10;
	private String isbn13;

	public Product(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPaperBack() {
		return paperBack;
	}

	public void setPaperBack(int paperBack) {
		this.paperBack = paperBack;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public int[] getRatings() {
		return Arrays.copyOf(ratings,ratings.length);
	}

	public void addRating(int rating){
		ratings[rating-1]=ratings[rating-1]+1;
	}
	
	public int getTotalRating(){
		totalRating=0;
		for (int i:ratings){totalRating+=i;}
		return totalRating;
	}
	
	public float getAverageRating(){
		int total=0;
		for (int i=0;i<ratings.length;i++){total=total+(i+1)*ratings[i];}
		int totalR=getTotalRating();
		if (totalR==0){return 0;}
		return averageRating=(Float.valueOf(String.valueOf(total)))/totalR;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}



}
