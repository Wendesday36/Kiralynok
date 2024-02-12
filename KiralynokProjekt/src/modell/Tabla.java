package modell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabla {

    private char[][] T = new char[8][8];
    private char UresCella;
    List<Character> helyek = new ArrayList<>();

    public Tabla(char betu) {

        this.UresCella = betu;
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                T[i][j] = UresCella;
            }
        }

    }

    public char[][] getT() {
        return T;
    }

    public char getUresCella() {
        return UresCella;
    }

    public String Megjelenit() {
         String szoveg="";
         for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                szoveg+=(T[i][j]);
            }
            szoveg+=("\n");
        }
        szoveg+=("\n");

        return szoveg;
    }

    public void Elhelyez(int db) {
        char Kiralyno = 'K';
        Random random = new Random();

        for (int i = 0; i < db; i++) {
            int randomSor = random.nextInt(8);
            int randomOszlop = random.nextInt(8);

            while (T[randomSor][randomOszlop] == Kiralyno) {
                randomSor = random.nextInt(8);
                randomOszlop = random.nextInt(8);
            }

            T[randomSor][randomOszlop] = Kiralyno;
        }
    }

    public void FájlbaÍr() throws IOException {
        String fajlnev = "tablak64.txt";
        for (int i = 0; i <= 7; i++) {
                StringBuilder sor = new StringBuilder();
                for (int j = 0; j <= 7; j++) {
                    sor.append(T[i][j]).append(" ");
                }
                sor.append(System.lineSeparator());
                Files.writeString(Path.of(fajlnev), sor.toString(), StandardOpenOption.APPEND);
            }
            Files.writeString(Path.of(fajlnev), System.lineSeparator(), StandardOpenOption.APPEND);
        } 
    

//7.feladat
    public boolean UresOszlop(int oszlop) {
        for (int i = 0; i < T.length; i++) {
            if (T[i][oszlop] == 'K') {
//                System.out.println("A karakter megtalalhato az oszlopban: [" + i + "][" + oszlop + "]");
                return true;
            }
        }

//        System.out.println("A karakter nem talalhato az oszlopban.");
        return false;
    }

    public boolean UresSor(int sor) {
        for (int j = 0; j < T[sor].length; j++) {
            if (T[sor][j] == 'K') {
//                System.out.println("A karakter megtalalhato a sorban: [" + sor + "][" + j + "]");
                return true;
            }
        }

//        System.out.println("A karakter nem talalhato az oszlopban.");
        return false;
    }
    //8.feladat

    public String UresOszlopokSzama() {
    int db = 0;

    for (int i = 0; i <= 7; i++) {
        if (UresOszlop(i)) {
            db++;
        }
    }

    return db+"darab";
}

    public String ÜresSorokSzáma() {
        int db = 0;

        for (int i = 0; i <= 7; i++) {
            if (UresSor(i)) {
                db++;
            }
        }

        return db+"darab";

    }

}
