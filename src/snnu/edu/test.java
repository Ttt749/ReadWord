package snnu.edu;

import java.util.Arrays;

/**
 * Created by WT on 2018/5/7.
 */
public class test {
    public static void main(String[] args){
//        ReadFile readFile = new ReadFile("F:\\java\\Thread\\src\\org\\snnu\\wt\\test\\helloworld.PAS");
        ReadFile readFile = new ReadFile("F:\\java\\test.PAS");
        Object words = readFile.getChar();
        String strToken = "";
        //双目运算符
        String str = "";
        boolean flag = true;
        while (words!=null){
            //todo 分析单词得出结果
            char word = (char) words;
            if(Utils.isLetter(word)){
                strToken = strToken + word;
                words = readFile.getChar();
                if(words !=null){
                    word = (char) words;
                    while (Utils.isLetter(word) || Utils.isDigit(word)){
                        strToken = strToken + word;
                        words = readFile.getChar();
                        if(words == null){
                            flag = false;
                            break;
                        }else{
                            word = (char) words;
                        }
                    }
                    if(flag){
                        readFile.retract();
                    }
                }
                AbstractClass.analysisString(strToken);
                strToken = "";
            }else if(Utils.isDigit(word)){
                strToken = strToken + word;
                word = (char) readFile.getChar();
                while (Utils.isDigit(word)||Utils.isDigitChar(word)){
                    strToken = strToken + word;
                    words = readFile.getChar();
                    if(words == null){
                        break;
                    }else{
                        word = (char) words;
                    }
                }
                readFile.retract();
                AbstractClass.analysisDigit(strToken);
                strToken = "";
            }else if(word!=' '){
                strToken = strToken + word;
                if(Utils.isOpt(word)){
                    char word_1 = (char) readFile.getChar();
                    str = str + word +word_1;
                    if(Utils.isOptB(str)){
                        strToken = str;
                    }else{
                        str = "";
                        readFile.retract();
                    }
                }
                AbstractClass.analysisOther(strToken);
                strToken = "";
            }

//            System.out.print(words.toString()+" ");
            words = readFile.getChar();
        }
        readFile.closeFile();
    }
}
