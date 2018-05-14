package snnu.edu;

import java.util.Arrays;

/**
 * Created by WT on 2018/5/7.
 */
public class Utils {
    public static boolean isE = false;
    public static String lastStr = "";
    private static char[] OptA = {'+','-','*','/','=','#','<','>',':'};
    public static String[] OptB = {"<=",">=",":=","<>"};

    static {
        Arrays.sort(OptA);
    }

    public static boolean isLetter(char word){
        if(('a'<= word && word <= 'z')||('A'<= word&&word<='Z')){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isDigit(char word){
        if(('0'<=word && word <= '9')){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isDigitChar(char word){
        switch (word){
            case '.':
                return true;
            case 'e':
                isE = true;
                return true;
            case '-':
            case '+':
                if(isE){
                    return true;
                }else{
                    return false;
                }
            default:
                return false;
        }
    }
    public static boolean isOpt(char word){
        if(Arrays.binarySearch(OptA,word)>0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isOptB(String str){
        for(int i =0 ;i<OptB.length;i++){
            if(OptB[i].equals(str)){
                return true;
            }
        }
        return false;
    }
    public static void print(String str,String word){
        lastStr = str;
        System.out.println("<"+str+","+word+">");
    }
}
