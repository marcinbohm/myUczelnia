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
            for(int i=0;i>bazaStudentow.length;i++){
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
            return bazaStudentow[nrStudenta];
        }
    }
    Student[] zaliczyliSesje(){
        java.util.ArrayList<Student> studenciZaliczajacySesje = new java.util.ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].zaliczonaSesja()==true){
                studenciZaliczajacySesje.add(bazaStudentow[i]);
            }
        }
        return studenciZaliczajacySesje.toArray(new Student[studenciZaliczajacySesje.size()]);
        }
    
    Student[] nieZaliczyliSesji(){
        java.util.ArrayList<Student> studenciNieZaliczajacySesji = new java.util.ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].zaliczonaSesja()==false){
                studenciNieZaliczajacySesji.add(bazaStudentow[i]);
            }
        }
        return studenciNieZaliczajacySesji.toArray(new Student[studenciNieZaliczajacySesji.size()]);
    }
    
    Student[] stypendia(){
        java.util.ArrayList<Student> studenciZeStypendium = new java.util.ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].stypendium()==true){
                studenciZeStypendium.add(bazaStudentow[i]);
            }
        }
        return studenciZeStypendium.toArray(new Student[studenciZeStypendium.size()]);
    }
    
    Student[] grupa(String idGrupy){
        java.util.ArrayList<Student> studenciZGrupy = new java.util.ArrayList<Student>();
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].getGrupa()== idGrupy){
                studenciZGrupy.add(bazaStudentow[i]);
            }
        }
        return studenciZGrupy.toArray(new Student[studenciZGrupy.size()]);
    }
}
