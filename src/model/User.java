package model;

import java.util.Arrays;

/*
 * model for storing the users data in the rating system
 */
public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private int[] productRating;

	public User(int length) {
		super();
		this.productRating = new int[length];
	}
	
	public int[] getProductRating() {
		if (productRating!=null) {
			return Arrays.copyOf(productRating, productRating.length);
		}else{return null;}
	}
	
	public void setProductRating(int index,int rating) {
		productRating[index]=rating;
	}

}
