package myuczelnia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewStud {
    public static void newStud() throws FileNotFoundException, IOException, ParseException{
        Scanner sc2 = new Scanner(System.in);
        String imie, nazwisko, grupa;
        Student student1 = new Student();
        System.out.println("Podaj imie studenta");
        imie = sc2.nextLine();
        System.out.println("Podaj nazwisko studenta");
        nazwisko = sc2.nextLine();
        System.out.println("Podaj grupe studenta");
        grupa = sc2.nextLine();
        student1.setImie(imie);
        student1.setNazwisko(nazwisko);
        student1.setGrupa(grupa);
                        
        JSONObject student = new JSONObject();
        student.put("imie", student1.getImie());
        student.put("nazwisko", student1.getNazwisko());
        student.put("oceny", null);
        student.put("grupa", student1.getGrupa()); 
                        
        JSONParser parser = new JSONParser();
                        
        Object obj = parser.parse(new FileReader("data.json"));
        JSONObject jsonObject = (JSONObject)obj;
        obj = obj.toString();
                        
        System.out.println(obj);
                        
        try (FileWriter file = new FileWriter("data.json")) {
            file.write(obj + student.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
