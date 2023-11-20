package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bookstore {
	private List<ABooks> books;

	public Bookstore(List<ABooks> books) {
		this.books = books;
	}

	public double totalAmountOfTheBookstore() {
		double total = 0;
		for (ABooks book : books) {
			total += book.getPrice();
		}
		return total;
	}

	public ABooks referencebooksHavetheMostChapters() {
		ABooks maxPage = new ReferenceBook("", 0, 0, "", 0, "", new ArrayList<Chapter>());
		for (ABooks book : books) {
			if (book instanceof ReferenceBook) {
				if (((ReferenceBook) book).highestnumberOfPagesInAChapter() > ((ReferenceBook) maxPage)
						.highestnumberOfPagesInAChapter()) {
					maxPage = book;
				}
			}
		}
		return maxPage;
	}

	public boolean isContainsAMagazine(String magazineName) {
		for (ABooks book : books) {
			if (book instanceof Magazine) {
				if (((Magazine) book).sameMagazineName(magazineName)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<ABooks> booksPublishedDuringtheYear(int year) {
		List<ABooks> booksPublishedDuringtheYear = new LinkedList<ABooks>();
		for (ABooks book : books) {
			if (book.isSameYearPublished(year)) {
				booksPublishedDuringtheYear.add(book);
			}
		}
		return booksPublishedDuringtheYear;
	}

	// /Sort publications ascending by title and descending by year of publication
	// (history using the Comparable or Comparator interface)
	public List<ABooks> ascendingByTitleanddescendingbyyearofpublication() {
		List<ABooks> sortedBooks = new ArrayList<ABooks>(books);
		sortedBooks.sort(new Comparator<ABooks>() {
			@Override
			public int compare(ABooks o1, ABooks o2) {
				if (o1.compareToTitle(o2) == 0) {
					return o2.compareToYear(o1);
				}
				return o1.compareToTitle(o2);
			}
		});
		return sortedBooks;
	}

	public Map<Integer, List<ABooks>> numberOfProductsPublishedByYear() {
		Map<Integer, List<ABooks>> map = new HashMap<Integer, List<ABooks>>();
		for (ABooks book : books) {
			if (map.containsKey(book.getYearPublished())) {
				map.get(book.getYearPublished()).add(book);
			} else {
				List<ABooks> list = new ArrayList<ABooks>();
				list.add(book);
				map.put(book.getYearPublished(), list);
			}
		}
		return map;
	}

}
