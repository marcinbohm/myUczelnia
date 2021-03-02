package myuczelnia;

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
        for(int i=0;i<bazaStudentow.length;i++){
            if(bazaStudentow[i].zaliczonaSesja()==true){
                //return bazaStudentow[i];
            }
        }
    }
}
