package myuczelnia;
import java.util.*;
import java.lang.ArrayIndexOutOfBoundsException;
/**
 *
 * @author marcin.bohm
 */
public class Uczelnia {
    
    private String nazwaUczelni;
    Student[] bazaStudentow;
    
    Uczelnia(){
        nazwaUczelni = "";
        bazaStudentow = new Student[500];
    }
    
    int dodajStudenta(Student student){
        try{
            for(int i=0;i<bazaStudentow.length;i++){
                if(bazaStudentow[i] != null){
                    i++;
                } else {
                    bazaStudentow[i] = student;
                    break;
                }
            }
        }catch(ArrayIndexOutOfBoundsException exception){
            System.out.println("Brak miejsca w bazie");
            return -1;
        }
        return 1;
    }
    
    Student odczytajStudenta(int nrStudenta){
        if(bazaStudentow[nrStudenta]==null){
            return null;
        }else{
                if (bazaStudentow[nrStudenta] != null) {
                    System.out.println("-------------------");
                    System.out.println("Imie: "+bazaStudentow[nrStudenta].getImie());
                    System.out.println("Nazwisko:"+bazaStudentow[nrStudenta].getNazwisko());
                    System.out.println("Grupa: "+bazaStudentow[nrStudenta].getGrupa());
                    System.out.println("Oceny: "+Arrays.toString(bazaStudentow[nrStudenta].getOceny()));
                    System.out.println("Srednia ocen: "+bazaStudentow[nrStudenta].sredniaOcen());
                    System.out.println("Czy zdana sesja: "+bazaStudentow[nrStudenta].zaliczonaSesja());
                    System.out.println("Czy stypendium: "+bazaStudentow[nrStudenta].stypendium());
                } else {
                    System.out.println("Brak studenta");
                }
            }
        return bazaStudentow[nrStudenta];
    }
    
    int numerBazaSesjaZal = 0;
    
    Student[] zaliczyliSesje(){
        Student[] zaliczonaSesja;
        zaliczonaSesja = new Student[500];
        for (Student z : bazaStudentow){
            if (z != null) {
                if(z.zaliczonaSesja()) {
                    zaliczonaSesja[numerBazaSesjaZal] = z;
                    numerBazaSesjaZal++;
                    System.out.println("Użytkownik " + z.getImie() + " " + z.getNazwisko() + " zaliczył sesję ze średnią ocen: "+z.sredniaOcen());
                }
            }
        }
        return zaliczonaSesja;
    }

    int numerBazaSesjaNZal = 0;
    
    Student[] nieZaliczyliSesji(){
        Student[] nieZaliczonaSesja;
        nieZaliczonaSesja = new Student[500];
        for (Student z : bazaStudentow){
            if (z != null) {
                if(!z.zaliczonaSesja()) {
                    nieZaliczonaSesja[numerBazaSesjaNZal] = z;
                    numerBazaSesjaNZal++;
                    System.out.println("Użytkownik " + z.getImie() + " " + z.getNazwisko() + " nie zaliczył sesji ze średnią ocen: "+z.sredniaOcen());
                }
            }
        }
        return nieZaliczonaSesja;
    }

    int numerBazaStyp = 0;
    
    Student[] stypendia(){
        Student[] zeStypendium;
        zeStypendium = new Student[500];
        for (Student z : bazaStudentow){
            if (z != null) {
                if(z.stypendium()) {
                    zeStypendium[numerBazaStyp] = z;
                    numerBazaStyp++;
                    System.out.println("Użytkownik " + z.getImie() + " " + z.getNazwisko() + " otrzymał stypendium ze średnią ocen: "+z.sredniaOcen());
                }
            }
        }
        return zeStypendium;
    }
    
    int listaGrupy = 0;
    
    Student[] grupa(String idGrupy){
        Student[] zGrupy;
        zGrupy = new Student[500];
        for (Student z : bazaStudentow){
            if (z != null) {
                if(z.getGrupa().equals(idGrupy)) {
                    zGrupy[listaGrupy] = z;
                    listaGrupy++;
                    System.out.println("Użytkownik " + z.getImie() + " " + z.getNazwisko() + " Jest członkiem grupy "+idGrupy);
                }
            }
        }
        return zGrupy;
    }
}
