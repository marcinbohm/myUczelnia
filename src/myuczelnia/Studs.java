package myuczelnia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Studs {
    public static void studs(){
        JSONParser parser = new JSONParser();
        try{
        JSONArray a = (JSONArray) parser.parse(new FileReader("data.json"));
        System.out.println("------");
        for (Object o : a){
          JSONObject student = (JSONObject) o;

          String imie = (String) student.get("imie");
          System.out.println("Imię: "+imie+" ");

          String nazwisko = (String) student.get("nazwisko");
          System.out.println("Nazwisko: "+nazwisko+" ");

          String grupa = (String) student.get("grupa");
          System.out.println("Grupa: "+grupa+" ");

          JSONArray oceny = (JSONArray) student.get("oceny");
          
          System.out.print("Oceny: ");
          for (Object c : oceny)
          {
            System.out.print(c+", ");
          }
          System.out.println("");
          System.out.println("------");
        }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
