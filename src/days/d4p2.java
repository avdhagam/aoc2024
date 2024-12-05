import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class d4p2 {
    
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
            if(matrix[i][j]=='A'){
                count+= alldirections(i,j,matrix,rows,cols);
            }
        }
       }
       return count;
    }
    public static int alldirections(int x,int y,char[][] matrix,int rows,int cols){
        int count=0;
        
            int n1x = x-1;int n1y=y-1;
            int n2x = x+1;int n2y=y-1;
            int n3x = x-1;int n3y=y+1;
            int n4x = x+1;int n4y=y+1;
            if(n1x>=0 && n1y>=0 && n1y<rows && n1x<cols &&
               n2x>=0 && n2y>=0 && n2x<cols && n2y<rows &&
               n3x>=0 && n3y>=0 && n3x<cols && n3y<rows &&
               n4x>=0 && n4y>=0 && n4x<cols && n4y<rows){
                if((matrix[n1x][n1y]=='M' && matrix[n2x][n2y]=='M' && matrix[n3x][n3y]=='S' && matrix[n4x][n4y]=='S')||
                   (matrix[n1x][n1y]=='M' && matrix[n2x][n2y]=='S' && matrix[n3x][n3y]=='M' && matrix[n4x][n4y]=='S')||
                   (matrix[n1x][n1y]=='S' && matrix[n2x][n2y]=='M' && matrix[n3x][n3y]=='S' && matrix[n4x][n4y]=='M')||
                   (matrix[n1x][n1y]=='S' && matrix[n2x][n2y]=='S' && matrix[n3x][n3y]=='M' && matrix[n4x][n4y]=='M')){
                    count++;
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

