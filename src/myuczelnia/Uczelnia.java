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
    Student[] zaliczyliSesje(){
        ArrayList<Student> studenciZaliczajacySesje = new ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].zaliczonaSesja()){
                studenciZaliczajacySesje.add(bazaStudentow[i]);
            } 
        }
        return studenciZaliczajacySesje.toArray(new Student[studenciZaliczajacySesje.size()]);
        }
    
    Student[] nieZaliczyliSesji(){
        ArrayList<Student> studenciNieZaliczajacySesji = new ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(!bazaStudentow[i].zaliczonaSesja()){
                studenciNieZaliczajacySesji.add(bazaStudentow[i]);
            }
        }
        return studenciNieZaliczajacySesji.toArray(new Student[studenciNieZaliczajacySesji.size()]);
    }
    
    Student[] stypendia(){
        ArrayList<Student> studenciZeStypendium = new ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].stypendium()==true){
                studenciZeStypendium.add(bazaStudentow[i]);
            }
        }
        return studenciZeStypendium.toArray(new Student[studenciZeStypendium.size()]);
    }
    
    Student[] grupa(String idGrupy){
        ArrayList<Student> studenciZGrupy = new ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].getGrupa()==idGrupy){
                studenciZGrupy.add(bazaStudentow[i]);
            }
        }
        return studenciZGrupy.toArray(new Student[studenciZGrupy.size()]);
    }
}
