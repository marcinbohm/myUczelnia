package myuczelnia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;
/**
 *
 * @author marcin.bohm
 */
public class MyUczelnia {
    public static void main(String[] args) {
        studs();
    }
    public static void studs(){
        JSONParser parser = new JSONParser();
        try{
        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\marcin.bohm\\Documents\\NetBeansProjects\\MyUczelnia\\src\\myuczelnia\\data.json"));
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
