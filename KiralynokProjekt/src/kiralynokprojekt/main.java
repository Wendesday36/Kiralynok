
package kiralynokprojekt;

import java.io.IOException;
import modell.Tabla;

public class main {

    public static void main(String[] args) throws IOException {
        Tabla t1 = new Tabla('a');
       
      t1.Elhelyez(8); 
        System.out.println(t1.Megjelenit()); 
        t1.UresSor(5);
        t1.UresOszlop(2);
        t1.UresOszlopokSzama();
        t1.ÜresSorokSzáma();
        
    }
    
}
