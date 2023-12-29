/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Ahmed Fekry
 */
public class Recordings {
    
     private File dir;
    private File file;
    private String recordsDirPath = "src/GameRecordss";//= "./GameRecords";
    private File[] recordsList;
    private FileInputStream fis;
    private DataInputStream dis;

    public Recordings() {
        //this.recordsDirPath = recordsDirPath;
        //dir = new File(recordsDirPath);

    }

    public String[] getRecordedGamesList() {
        dir = new File("src/GameRecordss");
        String[] Str;
        recordsList = dir.listFiles();
        StringBuilder fileList = new StringBuilder();
        if (recordsList != null) {
            // Display the list of files in the TextArea
            for (File file : recordsList) {
                //file.getName();
                fileList.append(file.getName()).append("#");
            }
            System.out.println(fileList.toString());
            Str = splitter(fileList.toString() , "#");
            //getRecord(Str[4]);
            return  Str;
            
        } else {
            //System.out.println("No files in the specified directory.");
            Str = null;
            Str[0] = "No files in the specified directory.";
            return Str;
        }
        
    }

    private String[] splitter(String str , String separator) {
        
        String separatore = "\\";
        separatore += separator;
        
        String[] result = str.split(separatore);
        /*for (int x = 0; x < result.length; x++) {
            //System.out.println(result[x]);
        }*/

        return result;
    }
    
   public GameRecord getRecord(String RecordName){
        String[] record;
        String game = " ";
        String firstPlayerName;
        String secondPlayerName;
        String gameResult;
        String gameMovments;
        int[] gameMovmentsInteger;
        GameRecord recordObject = new GameRecord();;
        if(file == null)
                {
                    try{
                    file = new File(recordsDirPath, RecordName);    
                    fis = new FileInputStream(file);
                    dis = new DataInputStream(fis);
                    game = dis.readUTF();
                    //System.out.println(game);
                    //textAreaId.setText(s);
                    record = splitter(game, ".");
                    gameMovments = record[0];
                         System.out.println(gameMovments);
                    firstPlayerName = record[1];
                    recordObject.setFirstPlayerName(firstPlayerName);
                         System.out.println(firstPlayerName);
                         
                    secondPlayerName = record[2];
                    recordObject.setSecondPlayerName(secondPlayerName);
                         System.out.println(secondPlayerName);

                    gameResult = record[3];
                    recordObject.setGameResult(gameResult);
                         System.out.println(gameResult);

                    
                    //////////////
                    gameMovmentsInteger = new int[gameMovments.length()];
                    for(int i = 0 ; i < gameMovments.length() - 1 ; i++){
                        
                          char charValue = gameMovments.charAt(i);
                          int intValue = charValue - '0';
                          gameMovmentsInteger[i] = intValue; 
                          System.out.println(gameMovmentsInteger[i]);
                    }
                    
                    /////////////
                    
                    recordObject.setGameMoves(gameMovmentsInteger);
                    recordObject.setFirstPlayerName(firstPlayerName);
                    recordObject.setSecondPlayerName(secondPlayerName);
                    recordObject.setGameResult(gameResult);
                    fis.close();
                    }catch(Exception e) {
                        e.printStackTrace();                        
                    }
                }else{
               System.out.println(game);
                } 
        
        return recordObject;
    
    }

    
}
