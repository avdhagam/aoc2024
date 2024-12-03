import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class d1p2 {
    public static int processF(String filepath) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] numbers = line.trim().split("\\s+");
                if (numbers.length == 2) {
                    l1.add(Integer.parseInt(numbers[0]));
                    l2.add(Integer.parseInt(numbers[1]));
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = 0;

        for (int i = 0; i < l1.size(); i++) {
            int num = Collections.frequency(l2, l1.get(i));
            result += num * (l1.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        String filepath = "d1.txt";
        int result = processF(filepath);
        System.out.println(result);
    }
}
