package com.epam.pojo;

public class ListOfBooks {

	private String userId;
	private ISBN[] collectionOfIsbns;

	public ListOfBooks(String userId, ISBN[] collectionOfIsbns) {
		this.userId = userId;
		this.collectionOfIsbns = collectionOfIsbns;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the collectionOfIsbns
	 */
	public ISBN[] getCollectionOfIsbns() {
		return collectionOfIsbns;
	}

	/**
	 * @param collectionOfIsbns the collectionOfIsbns to set
	 */
	public void setCollectionOfIsbns(ISBN[] collectionOfIsbns) {
		this.collectionOfIsbns = collectionOfIsbns;
	}

	@Override
	public String toString() {
		return "ListOfBooks [userId=" + userId + ", collectionOfIsbns=" + collectionOfIsbns + "]";
	}

}
