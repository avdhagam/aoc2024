import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class d6p1 {
    public static int processF(String filepath){
        Set<List<Integer>> visited = new HashSet<>();
        ArrayList<char[]> storage = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line = reader.readLine();
            while(line!=null){
                char[] temp = line.toCharArray();
                storage.add(temp);
                line = reader.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    
    int rows = storage.size();
    int cols = storage.get(0).length;

    int startx = -1;
    int starty = -1;

    outerloop:
    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(storage.get(i)[j]=='^'){
                 startx = i;
                 starty = j;
                 break outerloop;
            }
        }
    }

    int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}};
    // this is up, right ,down and finally left
    int ind=0;
    // in the input the char ^ is always upwards so we start from first index in moves

    visited.add(Arrays.asList(startx,starty));

    while(true){
        int x = startx + moves[ind][0];
        int y = starty + moves[ind][1];

        if(x<0 || x>=rows||y<0||y>=cols){
            break;
        }

        if(storage.get(x)[y]=='#'){
            ind = (ind+1)%4;
            //moving through the moves array circularly to achieve a 90 degrees right
        }
        else{
            startx = x;
            starty = y;
            visited.add(Arrays.asList(startx,starty));
        }
    }
    return visited.size();
    }

    public static void main(String[] args){
        int ans = processF("../resources/d6.txt");
        System.out.println(ans);
    }

    
}
