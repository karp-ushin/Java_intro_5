import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class RepeatingNames {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		try {
			File input = new File("input.txt");
			Scanner myReader = new Scanner(input);
			while (myReader.hasNextLine()) {
				String str = myReader.nextLine();
				String name = str.substring(0, str.indexOf(" "));
				if(map.containsKey(name)){
					map.put(name, map.get(name) + 1);
				} else {
					map.put(name, 1);
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No input file.");
		}
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		map.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
			.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		System.out.println(sortedMap);
	}
}