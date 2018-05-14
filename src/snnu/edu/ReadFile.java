package snnu.edu;

import java.io.*;

/**
 * Created by WT on 2018/5/7.
 */
public class ReadFile {
    private BufferedReader reader = null;
    private char[] words = null;
    private int index = 0;
    //打开文件
    public ReadFile(String fileName) {
        File file = new File(fileName);
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            tempString = reader.readLine();
            if(tempString !=null){
                words = tempString.toCharArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //得到字符
    public Object getChar(){
        if(index > words.length-1){
            if(readWords()){
                index = 0;
                return words[index++];
            }else {
                return null;
            }
        }else {
            return words[index++];
        }
    }
    //回退
    public void retract(){
        --index;
    }
    //关闭文件
    public void closeFile(){
        if(reader!=null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //当一行单词读取完毕之后继续读取
    private boolean readWords(){
        if(reader!=null){
            String tempString = null;
            try {
                tempString = reader.readLine();
                while (tempString!=null&&tempString.equals("")){
                    tempString = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            if(tempString !=null){
                words = tempString.toCharArray();
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
