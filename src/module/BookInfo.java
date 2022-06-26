package module;

import java.io.Serializable;

public class BookInfo implements Serializable{

	private int bn;
	private String title;
	private String author;
	private int price;
	private String pub_date;
	private int page;
	private String publisher;
	//private String infotitletap;
	//private String infoauthortap;
	
	@Override
	public String toString() {
		return bn + "\t" + title +"\t" + author + "\t" + price + "\t" + pub_date + "\t\t" + page + "\t" + publisher;
	}

	
	void viewList() {
		System.out.printf("%d\t%-25s\t%-20s\t%d\t%-15s\t%d\t%s\n", bn, title, author, price, pub_date, page, publisher);
	}
	
	public BookInfo() {
		
	}

	public BookInfo(int bn, String title, String author, int price, String pub_date, int page, String publisher) {
		this.bn = bn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pub_date = pub_date;
		this.page = page;
		this.publisher = publisher;
	}
	
	public int getBn() {
		return bn;
	}


	public void setBn(int bn) {
		this.bn = bn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPub_date() {
		return pub_date;
	}


	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
