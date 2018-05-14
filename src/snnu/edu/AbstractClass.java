package snnu.edu;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * Created by WT on 2018/5/7.
 */
public class AbstractClass {
    private final static String[] abstrac= {
            "absolute","abstract","and","array","as","asm","assembler","at","automated","begin","case",
            "cdecl","class","const","constructor","contains","default","destructor","dispid","dispinterface","div",
            "do","downto","dynamic","else","end","except","export","exports","external","far","file","finalization","finally",
            "for","forward","function","goto","if","implementation","implements","in","index","inherited","initialization",
            "inline","interface","is","label","library","message","mod","name","near","nil","nodefault","not","object","of","on",
            "or","out","overload","override","package","packed","pascal","private","procedure","program","property","protected","public",
            "published","raise","read","readonly","record","register","reintroduce","repeat","requires","resourcestring","safecall","set",
            "shl","shr","stdcall","stored","string","then","threadvar","to","type","try","unit","uses","var","virtual","while","with",
            "write","writeonly","xor"
    };
    public final static String[] OptA = {"+","-","*","/","=","#","<",">"};
    public final static String[] OptB = {"<=",">=",":=","<>"};
    public final static String[] End = {
            "(", ")" , "," , ";" , "." , "[" ,
            "]" , ":" , "{" , "}" , "\""
    };
    static {
        Arrays.sort(abstrac);
        Arrays.sort(OptA);
        Arrays.sort(OptB);
        Arrays.sort(End);
    }
    public static void analysisString(String str){

        if(Arrays.binarySearch(abstrac,str.toLowerCase())>0){
            Utils.print(str,"关键字");
        }else{
            if(Utils.lastStr.equals("'")||Utils.lastStr.equals("\"")){
                Utils.print(str,"常量");
            }else{
                Utils.print(str,"标识符");
            }
        }
    }
    public static void analysisDigit(String str){
        Utils.print(str,"常量");
    }
    public static void analysisOther(String str){
        if(Arrays.binarySearch(OptA,str)>0 || Utils.isOptB(str)){
            Utils.print(str,"运算符");
        }
        if(Arrays.binarySearch(End,str)>0){
            Utils.print(str,"界符");
        }

    }
}
