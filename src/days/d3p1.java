import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class d3p1 {
    public static int processF(String filepath){
        ArrayList<int[]> storage = new ArrayList<>();
        int ind=0;
        String Regex = "mul\\((\\d+),(\\d+)\\)";
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line = reader.readLine();
            Pattern pat = Pattern.compile(Regex);
            while(line!=null){
                Matcher mat = pat.matcher(line);
                
                while(mat.find()){
                    int[] arr= new int[2];
                    arr[0]=Integer.parseInt(mat.group(1));
                    arr[1]=Integer.parseInt(mat.group(2));
                    storage.add(arr);
                }
                line = reader.readLine();

            }
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        int ans=0;
        for(int i=0;i<storage.size();i++){
            ans+=storage.get(i)[0]*storage.get(i)[1];
        }
        return ans;
    }
    public static void main(String[] args){
        String filepath = "../resources/d3.txt";
        int ans = processF(filepath);
        System.out.println(ans);

    }

}
