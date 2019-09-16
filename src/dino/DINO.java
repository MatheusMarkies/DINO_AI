/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Elements;
import javax.swing.text.Element;

/**
 *
 * @author Matheus Markies
 */
public class DINO {

    public static String User_Speak;
    public static String User_NotData;
    public static boolean Process;
    static boolean Regravar;
    
    static int b;
    static int c;
    static int d;
    static int h;
    
    static boolean CommandCalcule;
    static boolean CommandSearch;
    
    static boolean Recorder;
    
    static String google = "http://www.google.com/search?q=";
    static String search = "";
    static String charset = "UTF-8";
    static String userAgent = "AIzaSyC0DsmJ2LpVHjXPdUFjO9g3LlVp-c5jklc";
    static URL url;
    
    
    static String[] SpeakWords;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("DINO IA V2.5.2");
        System.out.println("By: Matheus Markies | 20/01/2019");
        System.out.println("");
        
        new GUI().setVisible(true);
       
        DataCenter Drive = new DataCenter();
        Thread threadDrive = new Thread((Runnable) Drive);
        threadDrive.start();

        while (true) {
            
        
        if(Process == true){
            
            System.out.println("");
            System.out.println("USER: "+User_Speak);
            
            if(User_Speak.equals("Errado")){
                User_NotData = DataCenter.Historic;
                System.out.println("");
                System.out.println("Oque significa: "+User_NotData);
                User_Speak = "";
                DataCenter.Historic = "";
                Regravar = true;
                Process = false;
            }
        
        }
            
        if(Process == true){
            SpeakWords = DINO.User_Speak.split(" ");
            
            for(int a = 0;a < SpeakWords.length;a++){
                        SpeakWords[a] = SpeakWords[a].toLowerCase();
                    }
            
             for(int a = 0;a < SpeakWords.length;a++){
                 
                 if(SpeakWords[a].equals("calcule")){
                     d = a;
                     Recorder = true;
                     int f = a+1;
                     b = Integer.parseInt(SpeakWords[f]);
                     
                     CommandCalcule = true;
                 }
                     
                 if(CommandCalcule == true){
                 
                 if(SpeakWords[a].equals("/")){
                    int g = a+1; 
                    c = Integer.parseInt(SpeakWords[g]);
                     h = b / c;
                     
                     User_Speak = b+" / "+c;
                     
                    System.out.println("");
                    System.out.println("Resultado de "+User_Speak+" = "+h);
                     
             User_NotData = User_Speak;
             User_Speak = "= "+h;
             DataCenter.WriteData = true;
             
             CommandCalcule = false;
                     //Process = false;
                 }
                 if(SpeakWords[a].equals("-")){
                     int g = a+1;
                     c = Integer.parseInt(SpeakWords[g]);
                      h = b - c;
                      User_Speak = b+" - "+c;
                     System.out.println("");
                     System.out.println("Resultado de "+User_Speak+" = "+h);
  
             User_NotData = User_Speak;
             User_Speak = "= "+h;
             
             DataCenter.WriteData = true;
             
             CommandCalcule = false;
                    // Process = false;
                 }
                 if(SpeakWords[a].equals("*")){
                     int g = a+1;
                     c = Integer.parseInt(SpeakWords[g]);
                      h = b * c;
                      User_Speak = b +" x "+c;
                     System.out.println("");
                     System.out.println("Resultado de "+User_Speak+" = "+h);
   
             User_NotData = User_Speak;
             User_Speak = "= "+h;
             DataCenter.WriteData = true;
             
             CommandCalcule = false;
                     //Process = false;
                 }
                 if(SpeakWords[a].equals("x")){
                     int g = a+1;
                     c = Integer.parseInt(SpeakWords[g]);
                      h = b * c;
                      User_Speak = b+" x "+c;
                     System.out.println("");
                     System.out.println("Resultado de "+User_Speak+" = "+h);

             User_NotData = User_Speak;
             User_Speak = "= "+h;
             DataCenter.WriteData = true;
             
             CommandCalcule = false;
                     //Process = false;
                 }
                 if(SpeakWords[a].equals("+")){
                     int g = a+1;
                     c = Integer.parseInt(SpeakWords[g]);
                      h = b + c;
                      User_Speak = b+" + "+c;
                     System.out.println("");
                     System.out.println("Resultado de "+User_Speak+" = "+h);
                     
             User_NotData = User_Speak;
             User_Speak = "= "+h;
             DataCenter.WriteData = true;
             
             CommandCalcule = false;
                    // Process = false;
                 }
                 
             }
                 
                 if(SpeakWords[a].endsWith("Pesquise")){
                     
                     for(int r = 0;r<User_Speak.length();r++){
                         if(r > 8){
                             search = search + User_Speak.charAt(r);
                         }
                     }
                     
                     search = search.replace(" ", "+");
                     CommandSearch = true;
                 }
                 
                 if(CommandSearch == true){
                     url = new URL(
            "https://www.googleapis.com/customsearch/v1?key="+userAgent+ "&cx=013036536707430787589:_pqjad5hr1a&q="+ search + "&alt=json");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "application/json");
    BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));

    String output;
    System.out.println("");
    while ((output = br.readLine()) != null) {
        if(output.contains("\"link\": \"")){                
            String link=output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
            System.out.println(link);       
        }     
    }
    conn.disconnect();  
    
    System.out.println("");
    search = search.replace("+", " ");
    System.out.println("Esses são os resultados para "+search);
    search = "";
    User_Speak = "";
    Process = false;
    CommandSearch = false;
    
                 }
                 
             }
                 
             }    
        
            if(Process == true){
            if(Regravar == true){
                DataCenter.WriteData = true;
                Regravar = false;
            }
            
             try {
                int v = Integer.parseInt(User_Speak);
                User_NotData = v+"";
                User_Speak = "Numero "+v;
                DataCenter.WriteData = true;
                
            } catch (Exception e) {
                
            }
            
            if(DataCenter.WriteData == false){
            DataCenter.ReadData = true;
            Process = false;
            }else{
                Process = true;
            }
            }
            
        
        
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(DINO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
