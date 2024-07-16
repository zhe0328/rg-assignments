import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToUpperExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Convert each name to uppercase using map
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        upperCaseNames.forEach(System.out::println);
    }
}
