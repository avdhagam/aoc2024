import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class d4p1 {
    
    public static int processF(String filepath){
        List<String> storage = new ArrayList<>();
       try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
        String line = reader.readLine();
        while(line!=null){
            storage.add(line);
            line = reader.readLine();
        }
        
       }
        catch(IOException e){
            e.printStackTrace();
        }
       int rows = storage.size();
       int cols = storage.get(0).length();

       int count=0;
       
       char[][] matrix = new char[rows][cols];
       for(int i=0;i<rows;i++){
        matrix[i]=storage.get(i).toCharArray();
       }

       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(matrix[i][j]=='X'){
                count+= alldirections(i,j,matrix,rows,cols);
            }
        }
       }
       return count;
    }
    public static int alldirections(int i,int j,char[][] matrix,int rows,int cols){
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
        int count=0;
        for(int[] dir:dirs){
            int x = dir[0];
            int y = dir[1];
            int n1x = i+x;int n1y=j+y;
            int n2x = i+2*x; int n2y = j+2*y;
            int n3x = i+3*x; int n3y = j+3*y;

            if(n1x>=0 && n1y>=0 && n1y<rows && n1x<cols &&
               n2x>=0 && n2y>=0 && n2x<cols && n2y<rows &&
               n3x>=0 && n3y>=0 && n3x<cols && n3y<rows){
                if(matrix[n1x][n1y]=='M' && matrix[n2x][n2y]=='A' && matrix[n3x][n3y]=='S'){
                    count++;
                }
               }
        }
        return count;
    }

    public static void main(String[] args){
        String filepath = "../resources/d4.txt";
        int ans = processF(filepath);
        System.out.println(ans);
    }

}
