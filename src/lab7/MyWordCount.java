package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {

	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<WordCount>();
		for (String w : words) {
			WordCount wc = new WordCount(w, count(w));
			if (!re.contains(wc))
				re.add(wc);
		}
		return re;
	}

	public int count(String w) {
		int s = 0;
		for (String wc : words) {
			if (wc.equals(w)) {
				s++;
			}
		}
		return s;
	}

	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1) {
				re.add(wc.getWord());

			}
		}
		return re;
	}

	public Set<String> getDistinctWords() {
		// TODO
		return new HashSet(this.words);
	}

	public Set<WordCount> printWordCounts() {
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount wc1, WordCount wc2) {
				int re = wc2.getCount() - wc1.getCount();
				if (re == 0) {
					return wc1.getWord().compareToIgnoreCase(wc2.getWord());

				}
				return wc1.getCount() - wc2.getCount();
			}

		});

		for (String word : words) {
			WordCount wc = new WordCount(word, count(word));
			if (!re.contains(wc)) {
				re.add(wc);
			}
		}

		return re;

	}

	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> result = new TreeSet<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount wc1, WordCount wc2) {
				if (wc1.getCount() - wc2.getCount() == 0) {
					return wc2.getWord().compareToIgnoreCase(wc1.getWord());
				}
				return wc2.getCount() - wc1.getCount();
			}
		});

		for (String word : words) {
			WordCount wc = new WordCount(word, count(word));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}

		return result;
	}

	public Set<String> filterWords(String pattern) {
		Set<String> result = new HashSet<String>();
		for (String word : words) {
			if (!word.startsWith(pattern)) {
				result.add(word);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MyWordCount wordCount = new MyWordCount();
		List<WordCount> wc = wordCount.getWordCounts();
		for (int i = 0; i < wc.size(); i++) {
			System.out.println(wc.get(i));
		}
		System.out.println();
		for (String word : wordCount.getUniqueWords()) {
			System.out.println(word);
		}
		System.out.println();
		for (String word : wordCount.getDistinctWords()) {
			System.out.println(word);
		}
		System.out.println();

		for (WordCount word : wordCount.printWordCounts()) {
			System.out.println(word);
		}
		System.out.println();

		for (WordCount word : wordCount.exportWordCountsByOccurence()) {
			System.out.println(word);
		}
		System.out.println();

		for (String word : wordCount.filterWords("A")) {
			System.out.print(word + " ");
		}

	}
}