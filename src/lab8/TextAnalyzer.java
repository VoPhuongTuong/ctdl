package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	public void load(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = null;
			int position = 0;
			try {
				while (true) {
					line = reader.readLine();
					if (line == null)
						break;
					StringTokenizer tokens = new StringTokenizer(line, " ");
					while (tokens.hasMoreTokens()) {
						String word = tokens.nextToken();
						if (map.containsKey(word)) {
							map.get(word).add(position);
						} else {
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(position);
							map.put(word, list);

						}
						position++;
					}
					if (map.containsKey("\n")) {
						map.get("\n").add(position);
					} else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(position);
						map.put("\n", list);
					}
					position++;

				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void add(String word, int position) {
		if (map.containsKey(word)) {
			map.get(word).add(position);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(position);
			map.put(word, list);
		}

	}

	public void displayWords() {
		Map<String, ArrayList<Integer>> sortedMap = new HashMap<String, ArrayList<Integer>>();
		sortedMap.putAll(map);
		sortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

	}

	public int countAllWords() {
		int count = 0;
		for (String word : map.keySet()) {
			count += map.get(word).size();
		}
		System.out.println(count);
		return count;
	}

	public void displayText() {
		int count = countAllWords();
		String content[] = new String[count];
		for (String word : map.keySet()) {
			for (int i = 0; i < map.get(word).size(); i++) {
				content[map.get(word).get(i)] = word;
			}
		}
		for (int i = 0; i < content.length; i++) {
			System.out.print(" " + content[i]);
		}

	}
	public String mostFrequentWord() {
		int max = 0;
		String word = "";
		for (String w : map.keySet()) {
			if (map.get(w).size() > max && !w.equals("\n")) {
				max = map.get(w).size();
				word = w;
			}
		}
		return word;
	}

	public static void main(String[] args) {
		TextAnalyzer ta = new TextAnalyzer();
		ta.load("data/fit.txt");

		System.out.println();
		ta.displayWords();

		System.out.println();
		ta.displayText();

		System.out.println(ta.mostFrequentWord());
	}
}
