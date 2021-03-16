package myuczelnia;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;

/**
 *
 * @author marcin.bohm
 */
public class MyUczelnia {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        boolean run = true;
        Student student;
        Uczelnia uczelnia1 = new Uczelnia();
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Wprowadź dane");
        System.out.println("2. Odczytaj dane");
        System.out.println("3. Wyjdź");
        switch(sc.nextInt()){
            case 1 -> {
                System.out.println("Co chcesz zrobić?");
                System.out.println("1. Nowy student do bazy");
                System.out.println("2. Wprowadź oceny konkretnemu studentowi");
                System.out.println("3. Usuń konkretnego studenta z bazy");
                switch(sc.nextInt()){
                    case 1 -> {
                        String imie, nazwisko, grupa;
                        Scanner sc2 = new Scanner(System.in);
                        student = new Student();
                        System.out.println("Podaj imię studenta");
                        imie = sc2.nextLine();
                        System.out.println("Podaj nazwisko studenta");
                        nazwisko = sc2.nextLine();
                        System.out.println("Podaj grupę studenta");
                        grupa = sc2.nextLine();
                        System.out.println("Czy chcesz wpisać oceny? Wpisz true lub false");
                        boolean czyOceny = sc2.nextBoolean();
                        if(czyOceny){
                            System.out.println("Ile ocen chcesz wprowadzić");
                            int ile = sc2.nextInt();
                            
                            try{
                                for(int i=0;i<ile;i++){
                                    System.out.println("Wprowadź ocenę:");
                                    double n = sc2.nextDouble();
                                    if(n<1 || n>5){
                                        System.out.println("Podano ocenę spoza skali");
                                        i--;
                                    }else{
                                       student.dodajOcene(n);
                                    }
                                }
                            }catch(java.lang.NullPointerException | ArrayIndexOutOfBoundsException exception){
                                    System.out.println("Nie można wprowadzić więcej niż 5 ocen, brak miejsca w bazie, uczeń ma wystawione wszystkie oceny");
                                    System.out.println("Aktualne oceny studenta: "+Arrays.toString(student.getOceny()));
                                }
                            student.setImie(imie);
                            student.setNazwisko(nazwisko);
                            student.setGrupa(grupa);
                            uczelnia1.dodajStudenta(student);
                            break;
                        }
                    }
                    case 2 -> {
                       Scanner sc2 = new Scanner(System.in); 
                       System.out.println("Wprowadź numer studenta");
                       int n = sc2.nextInt();
                       System.out.println("Aktualne oceny studenta: "+Arrays.toString(uczelnia1.bazaStudentow[n].getOceny()));
                       for(int i=0;i<5;i++){
                                try{
                                    double o = sc2.nextDouble();
                                    if(o<1 || o>5){
                                        System.out.println("Podano ocenę spoza skali");
                                        i--;
                                    }else{
                                        uczelnia1.bazaStudentow[n].dodajOcene(o);
                                    }
                                }catch(java.lang.NullPointerException | ArrayIndexOutOfBoundsException exception){
                                    System.out.println("Brak miejsca w bazie, uczeń ma wystawione wszystkie oceny");
                                    System.out.println("Aktualne oceny studenta: "+Arrays.toString(uczelnia1.bazaStudentow[n].getOceny()));
                                    break;
                                }
                            }
                        break;
                    }
                    case 3 -> {
                        Scanner sc2 = new Scanner(System.in); 
                        System.out.println("Wprowadź numer studenta");
                        int n = sc2.nextInt();
                        uczelnia1.bazaStudentow[n] = null;
                        break;
                    }
                }
            }
            case 2 -> {
                System.out.println("Co chcesz zrobić?");
                System.out.println("1. Lista studentow");
                System.out.println("2. Odczytaj informacje o konkretnym studencie");
                System.out.println("3. Lista studentow ze stypendiami");
                System.out.println("4. Lista studentow, którzy zaliczyli sesję");
                System.out.println("5. Lista studentow, którzy nie zaliczyli sesji");
                System.out.println("6. Lista studentow z podanej grupy");
                switch(sc.nextInt()){
                    case 1 -> {
                        int pozycja = -1;
                        for (Student z : uczelnia1.bazaStudentow){ 
                            
                            pozycja++;
                            
                            if (z != null) {
                                System.out.println("-------------------");
                                System.out.println("Pozycja: "+pozycja);
                                System.out.println("Imie: "+z.getImie());
                                System.out.println("Nazwisko:"+z.getNazwisko());
                                System.out.println("Grupa: "+z.getGrupa());
                            }
                        }
                        break;
                    }
                    case 2 -> {
                        Scanner sc2 = new Scanner(System.in); 
                        System.out.println("Wprowadź numer studenta");
                        int n = sc2.nextInt();
                        uczelnia1.odczytajStudenta(n);
                        break;
                    }
                    case 3 -> {
                        uczelnia1.stypendia();
                        break;
                    }
                    case 4 -> {
                        uczelnia1.zaliczyliSesje();
                        break;
                    }
                    case 5 -> {
                        uczelnia1.nieZaliczyliSesji();
                        break;
                    }
                    case 6 ->{
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Wprowadź numer grupy");
                        String nr = sc2.nextLine();
                        uczelnia1.grupa(nr);
                        break;
                    }
                }
            }
            case 3 ->{
                run = false;
            }
        }
        }while(run);
    }
}
