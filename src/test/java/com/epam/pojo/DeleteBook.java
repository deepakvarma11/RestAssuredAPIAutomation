package com.epam.pojo;

public class DeleteBook {

	private String isbn;
	private String userId;

	public DeleteBook(String isbn, String userId) {
		this.isbn = isbn;
		this.userId = userId;
	}

	/**
	 * @return the isbn
	 */
	public synchronized String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public synchronized void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the userId
	 */
	public synchronized String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public synchronized void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "DeleteBook [isbn=" + isbn + ", userId=" + userId + "]";
	}

}
