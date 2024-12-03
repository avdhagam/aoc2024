import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class d3p2 {
    public static int processF(String filepath) {
        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Pattern opPattern = Pattern.compile(regex);
        Pattern numPattern = Pattern.compile("\\d+");

        boolean zoit = true;
        int answer = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                Matcher opMatcher = opPattern.matcher(line);
                while (opMatcher.find()) {
                    String match = opMatcher.group();

                    if (match.equals("do()")) {
                        zoit = true;
                    } else if (match.equals("don't()")) {
                        zoit = false;
                    } else {
                        int[] res = {0, 0};
                        Matcher numMatcher = numPattern.matcher(match);
                        int i = 0;
                        while (numMatcher.find() && i < 2) {
                            res[i] = Integer.parseInt(numMatcher.group());
                            i++;
                        }
                        if (zoit) {
                            answer += res[0] * res[1];
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return answer;
    }

    public static void main(String[] args) {
        String filepath = "../resources/d3.txt";
        int ans = processF(filepath);
        System.out.println(ans);
    }
}
