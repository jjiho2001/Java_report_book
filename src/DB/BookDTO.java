package DB;

public class BookDTO {

	private int bn;
	private String title;
	private String author;
	private int price;
	private String pub_date;
	private int page;
	private String publisher;
	
	public BookDTO() {
		
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
