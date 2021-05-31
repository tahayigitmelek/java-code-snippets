import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList(new Scanner(System.in).nextLine().split("[\\s\\W]+"));

        stringList.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }
}