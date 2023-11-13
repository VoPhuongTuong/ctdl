
package lab8;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class MyWordCountApp {

	public static final String fileName = "data/fit.txt";

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public void loadData() {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				String word = scanner.next().toLowerCase(); // Convert to lowercase for case-insensitive counting
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int countDistinct() {
		return map.size();
	}

	public void printWordCounts() throws FileNotFoundException {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	public void printWordCountsAlphabet() {

		Map<String, Integer> sortMap = new HashMap<String, Integer>();
		sortMap.putAll(map);
		sortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
	}

	public static void main(String[] args) {
		MyWordCountApp app = new MyWordCountApp();
		app.loadData();
		System.out.println("Number of unique tokens: " + app.countDistinct());
		try {
			app.printWordCounts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		app.printWordCountsAlphabet();

	}
}
