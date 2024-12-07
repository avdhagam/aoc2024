import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class d7p1 {
    public static void main(String[] args) {
        String filepath = "../resources/d7.txt";
        long ans = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line =reader.readLine()) !=null) {
                String[] temp=line.split(":");
                long test =Long.parseLong(temp[0].trim());
                String[] numberstest =temp[1].trim().split("\\s+");
                
                int[] nums =new int[numberstest.length];
                for (int i= 0; i < numberstest.length; i++) {
                    nums[i] =Integer.parseInt(numberstest[i].trim());
                }
                List<String> eqs = new ArrayList<>();
                eqs.addAll(makeEqs(nums, '+'));
                eqs.addAll(makeEqs(nums, '*'));
                for (String eq: eqs) {
                    if (calculate(eq)==test) {
                        ans +=test;
                        break;
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(ans);
    }
    
    private static List<String> makeEqs(int[] nums,char x) {
        if (nums.length==2) {
            if (x=='+') {
                return Arrays.asList(nums[0]+" + "+nums[1]);
            }
            if (x=='*') {
                return Arrays.asList(nums[0]+" * "+nums[1]);
            }
        }
        
        List<String> temp = new ArrayList<>();
        temp.addAll(makeEqs(Arrays.copyOfRange(nums,1,nums.length),'+'));
        temp.addAll(makeEqs(Arrays.copyOfRange(nums,1,nums.length),'*'));
        
        List<String> temp1 = new ArrayList<>();
        for (String s:temp) {
            temp1.add(nums[0]+" "+x+" "+s);
        }
    

        return temp1;
    }
    
    private static long calculate(String eq) {
        String[] temp=eq.split(" ");
        long ans =Long.parseLong(temp[0]);
        char op =temp[1].charAt(0);
        
        for (int i=2;i<temp.length;i++) {
            if (i % 2==0) {
                if (op=='*') {
                    ans=ans*(Long.parseLong(temp[i]));
                }
                if (op=='+') {
                    ans=ans+(Long.parseLong(temp[i]));
                }
            }else{
                op=temp[i].charAt(0);
            }
        }
        return ans;
    }
}