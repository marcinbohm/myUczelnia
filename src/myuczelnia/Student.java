package myuczelnia;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.*;

public class Student {
    private String imie, nazwisko, grupa;
    private double[] oceny;
    
     public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
    
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }
    
    public double[] getOceny(){
        return oceny;
    }
    
    public void setOceny(double oceny[]){
        this.oceny = oceny;
    }
    
    public Student(){
        imie = ""; nazwisko = ""; grupa = "";
        oceny = new double[5];
    }
    
    int next = 0;
    
    public int dodajOcene(double ocena){
        try{
            if(oceny[next] > 5){
                return -1;
            } else {
                oceny[next] = ocena;
                next++;
            }
                
        } catch(ArrayIndexOutOfBoundsException exception){
            System.out.print("Wszystkie oceny zostały wystawione, brak miejsca");
            return -1;
        }
        
        return 1;
    }
    public double odczytajOcene(int nrOceny){
        try{
            double ocena;
            ocena = oceny[nrOceny];
            System.out.println(ocena);
        }catch(ArrayIndexOutOfBoundsException exception){
            System.out.print("Odczytano wynik spoza tablicy");
            return -1;
        }
        System.out.print("Odczytano prawidłowo ocenę, wynik funkcji: ");
        return 1;
    }
    public double sredniaOcen(){
        double srednia = 0;
        for(int i=0;i<oceny.length;i++){
            srednia += oceny[i];
        }
        srednia = srednia/oceny.length;
        return srednia;
    }
    public boolean zaliczonaSesja(){
        for(int i=0; i<oceny.length; i++){
            if(oceny[i]<3){
                return false;
            }
        }
        return true;
    }
    public boolean stypendium(){
        double sredniaOcen = sredniaOcen();
        if(sredniaOcen >= 4.5){
            return true;
        }else {
            return false;
        }
    }
}
