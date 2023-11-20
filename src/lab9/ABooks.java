package lab9;

public abstract class ABooks {
	private String title;
	private int numberOfPages;
	private int yearPublished;
	private String author;
	private double price;

	public ABooks(String title, int numberOfPages, int yearPublished, String author, double price) {
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.yearPublished = yearPublished;
		this.author = author;
		this.price = price;
	}

	public abstract String getType() ;

	public int getYearPublished() {
		return yearPublished;
	}

	public String getTitle() {
		return title;
	}

	public abstract boolean isSameType(ABooks other);

	public boolean isPublishedTimeAgo10Years() {
		return (2021 - this.yearPublished) > 10;
	}

	public boolean isSameYearPublished(int year) {
		return this.yearPublished == year;
	}

	public double getPrice() {
		return price;
	}

	public boolean isSameTypeAndAuthor(ABooks other) {
		return this.isSameType(other) && this.author.equals(other.author);
	}

	public int compareTo(ABooks o2) {
		return 0;
	}

	public int compareToTitle(ABooks o2) {
		return this.title.compareTo(o2.title);
	}

	public int compareToYear(ABooks o2) {
		return this.yearPublished - o2.yearPublished;
	}

	public boolean isSameType1(ABooks other) {
		// TODO Auto-generated method stub
		return false;
	}

}
