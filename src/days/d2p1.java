import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class d2p1 {

public static int processF(String filepath){
    int[][] matrix = null;
    int rowcount=0;
    try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
      String line = reader.readLine();
      
      while(line!=null){
        rowcount++;
        line=reader.readLine();
      }
      matrix = new int[rowcount][];
    }catch(IOException e ){
        e.printStackTrace();
    } 

    try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
      String line = reader.readLine();

      int currow = 0;
      while(line!=null){
        if(currow<rowcount){
        String[] numbers = line.trim().split("\\s+");
        int[] row  = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            row[i]=Integer.parseInt(numbers[i]);
        }
        matrix[currow]=row;
        currow++;
        }
        line = reader.readLine();
      }
    }catch(IOException e ){
        e.printStackTrace();
    } 
    
    int count=0;
    for(int i=0;i< matrix.length;i++){    
            if(isInOrder(matrix[i]) && hasDiff(matrix[i])){
                count++;
            }
    }
    return count;
}
public static boolean isInOrder(int[] row){
    boolean increasing = true;
    boolean decreasing = true;

    for(int i=1;i<row.length;i++){
        if(row[i]>row[i-1]){
            decreasing=false;
        }
        if(row[i]<row[i-1]){
            increasing=false;
        }
    }
    return increasing || decreasing;
}

public static boolean hasDiff(int[] row){
    boolean flag=true;
    for(int i=1;i<row.length;i++){
        int num = Math.abs(row[i]-row[i-1]);
        if(num<1 || num>3){
            flag=false;
        }
    }
    return flag;
}
public static void main(String args[]){
String filepath = "../resources/d2.txt";
int ans = processF(filepath);
System.out.println(ans);
}
}
