

package otros;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.FileWriter; 

public class Archivo { 
    private int nro; 
     
    public int leerArchivo(){ 
        try{ 
             
            FileReader fr=new FileReader("contador.txt"); 
            BufferedReader br= new BufferedReader(fr); 
            String linea=br.readLine();//leo linea 
            nro=Integer.parseInt(linea.trim());//paso string a int para retornar variable 
            br.close(); 
            fr.close(); 
        }catch(Exception ex){ 
            ex.printStackTrace(); 
        } 
        return nro; 
    } 
     
    public void escribirArchivo(String visita){ 
        try{ 
            FileWriter fw=new FileWriter("contador.txt"); 
            fw.write(visita); 
            fw.close(); 
        }catch(Exception ex){ 
            ex.printStackTrace(); 
        } 
    } 

} 
