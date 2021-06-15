/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dino;

import static dino.DINO.Process;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Markies
 */
public class DataCenter extends Thread{
    
    boolean BlockQuestion;
    String LineQuestion = "";
    String Reader;
    public static boolean ReadData;
    public static boolean WriteData;
    
    String[] QuestionWords;
    String[] SpeakWords;
    String[] StaticSpeakWords;
    String Question;
    
     Scanner reader;  
     static String Line;
    
    String AnswerData = "";
    String StaticAnswerData;
    
    int AnswerPoints;
    int Points;
     boolean a;
     int o;
     int b;
     int c = 1000;
     int Space;
     
     static String HightCaseAnswer;
     
     public static String Historic;
     
     int ProssLine;
     
     public static int LineNubers;
    
     boolean Result;
     
    static File DataCenter = new File(System.getProperty("user.home") + "\\Desktop\\DATA\\DataCenter.txt");
    static File IndexControl = new File(System.getProperty("user.home") +"\\Desktop\\DATA\\Index.txt");
    
    Calendar cal = Calendar.getInstance();
    LocalDate localDate = LocalDate.now();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    DateTimeFormatter sdd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
   public void run(){
        
         if (!DataCenter.exists()) {
             System.out.println("Creating Data Center...");
             
             try {
            DataCenter.createNewFile();
            FileWriter DataCenterWriter = null;
            DataCenterWriter = new FileWriter(DataCenter.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(DataCenterWriter);
            
            bw.write("Dino");
            bw.close();  
            
            LineNubers = 0;
            
             } catch (IOException ex) {
                 Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
             }

            }
         
         if (!IndexControl.exists()) {
             System.out.println("Creating Index...");
             
             try {
            IndexControl.createNewFile();
            FileWriter IndexWriter = null;
            IndexWriter = new FileWriter(IndexControl.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(IndexWriter);
            
            bw.write(""+LineNubers);
            bw.close();  
            
             } catch (IOException ex) {
                 Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
             }

            }else{
            FileReader ler = null;
             try {
                 ler = new FileReader(IndexControl);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
             }
            BufferedReader Index = new BufferedReader(ler); 
            
             try {
                 LineNubers = Integer.parseInt(Index.readLine());
                 
             } catch (IOException ex) {
                 Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
             }
            
         }
            
         while (true) {
         
        if(WriteData == true){
            
            if(Process == true){
                
                 FileWriter DataCenterWriter = null;
                 FileWriter IndexWriter = null;
            try {
                
            DataCenterWriter = new FileWriter(DataCenter.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(DataCenterWriter);
               
            
            IndexWriter = new FileWriter(IndexControl.getAbsoluteFile());
            BufferedWriter bi = new BufferedWriter(IndexWriter);
            
            LineNubers += 1;
            
            bi.write(""+LineNubers);
            bi.close();
            
            bw.newLine();
            bw.write(DINO.User_NotData+"*"+DINO.User_Speak);
            System.out.println("");
            System.out.println("DINO: "+DINO.User_NotData+": "+DINO.User_Speak );
            bw.close(); 
            
              } catch (IOException ex) {
                Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Process = false;
            WriteData = false; 
            }    
            
          
            
  
        }
          
        if(ReadData == true){
              
            FileReader DataCenterRead = null;
            try {
                DataCenterRead = new FileReader(DataCenter);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           try {
               reader = new Scanner(DataCenter);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String Temp = null;
            boolean y = false;
            
             if(Line == null){
              Line = reader.nextLine();
              Line.toLowerCase();
            }else{
            
             }
                
                if(LineNubers != 0){
                    
                    reader.close();
                    try {
                        reader = new Scanner(DataCenter);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                  for(int u=0; u <= LineNubers;u++){

                   if(Line.equals(Temp)){
                       y = true;
                       try {
                       Temp = reader.nextLine();
                       HightCaseAnswer = Temp;
                       Temp = Temp.toLowerCase();
                       } catch (Exception e) {
                       }
                       Line = Temp;
                       
                               for(int i = 0;i < Line.length();i++){
                if(Line.charAt(i) != '*'){
                 
                    if(i < c){
                    LineQuestion = LineQuestion + Line.charAt(i);
                    }
                    
                    }else{
                    
                    c = i;
                    
                    QuestionWords = LineQuestion.split(" ");                   
                    SpeakWords = DINO.User_Speak.split(" ");
                    
                    for(int a = 0;a < SpeakWords.length;a++){
                        SpeakWords[a] = SpeakWords[a].toLowerCase();
                    }

                }
            }           
                    if(QuestionWords.length >= SpeakWords.length){
                    
                    for(int a = 0;a < SpeakWords.length;a++){
                        if(SpeakWords[a].equals(QuestionWords[a])){
                            AnswerPoints += 10;
                        }
                    }
                }else{
                    for(int a = 0;a < QuestionWords.length;a++){
                         if(QuestionWords[a].equals(SpeakWords[a])){
                            AnswerPoints += 10;
                        }
                    }
                }
                
                if (Points <= AnswerPoints){
                    
                    for(int i = 0;i < Line.length();i++){
                if(Line.charAt(i) == '*'){
                    a = true;
                    o = i;
                }
                if(a == true){
                    if(o != i){
                        
                        AnswerData = AnswerData + HightCaseAnswer.charAt(i);
                        Question = LineQuestion;
                        StaticSpeakWords = SpeakWords;
                        SpeakWords = null;

                    }
                }
                   
                    }
                    StaticAnswerData = AnswerData;
                    AnswerData = "";
                    Points = AnswerPoints;
                    AnswerPoints = 0;
                }             
                    o = 0;
                    a = false;
                     StaticSpeakWords = SpeakWords;
                     SpeakWords = null;
                     LineQuestion = "";
                     QuestionWords = null;
                     c = 1000;  

                   }else{
                          Temp = reader.nextLine();
                          HightCaseAnswer = Temp;
                          //Temp = Temp.toLowerCase();
                   }
                
                 ProssLine = u;
                   
                 int r = LineNubers;
                
                if(ProssLine < r){
                    Result = false;
                    BlockQuestion = false;
                }else{
                    Result = true;
                }
                
                
                   
               }
                }else{
                    Result = true;
                }
    

            if(Result == true){
                        for(int f = 0;f<Question.length();f++){
                if(Question.charAt(f) == ' '){
                    Space ++;
                }
            }
            if(Space > 0){
            StaticSpeakWords = Question.split(" ");

            }else{
                b = 10;
                
            }
                try {
                    
           if(StaticSpeakWords.length > 1){
            b = (StaticSpeakWords.length / 2)*10;
            } 
                   
                } catch (Exception e) {
                }
            
                //System.out.println("A suposta resposta e: "+StaticAnswerData);
                //System.out.println(Points);
                //System.out.println(b);
 
            if(Points >= b){
                
                if(StaticAnswerData.equals("/TIME/")){
                    StaticAnswerData = sdf.format(cal.getTime())+" HH:MM";
                }
                
                 if(StaticAnswerData.equals("/DATE/")){
                    StaticAnswerData = sdd.format(localDate) +" DD:MM:YYYY";
                }
                
            System.out.println("");
            System.out.println("DINO: "+StaticAnswerData);
            Historic = DINO.User_Speak;
            DINO.User_Speak = "";
            }else{
                System.out.println("");
                System.out.println("DINO: Nao tenho dados...");
                System.out.println("");
                System.out.println("Oque significa "+DINO.User_Speak+" ?");
                
                DINO.User_NotData = DINO.User_Speak;
                DINO.User_Speak = "";
                WriteData = true;
            }
            
            
            AnswerData = "";
            b = 0;
            Points = 0;
            Question = "";
            LineQuestion = "";
            c = 1000;
            BlockQuestion = false;
            Line = null;
            DINO.User_Speak = "";
            Result = false;
            ReadData =  false;
        }
           
        }
        
        
             try {
                 Thread.sleep(50);
             } catch (InterruptedException ex) {
                 Logger.getLogger(DataCenter.class.getName()).log(Level.SEVERE, null, ex);
             }

         
         
         
    }//while
    
   
   
}
   
}
