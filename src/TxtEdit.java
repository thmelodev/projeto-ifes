
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peppão
 */
public class TxtEdit {
    
    public void writeInTxt(java.io.File file,String path){
        try{
            FileWriter txt = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(txt);
            printWriter.print(path);
            printWriter.flush();
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    public String readTxt(java.io.File file){
        String path = "";
        try{
            FileReader txt = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(txt);
            path = bufferedReader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
}
