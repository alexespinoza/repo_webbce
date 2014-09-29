
package otros;

import java.io.File;
import java.net.URL;
import static javax.servlet.SessionTrackingMode.URL;

public class Directorio {
    private static File WORKING_DIRECTORY;
public static File get() {
    String Recurso = Directorio.class.getSimpleName() + ".class";
    if (WORKING_DIRECTORY == null) {
        try {
            URL url = Directorio.class.getResource(Recurso);
            if (url.getProtocol().equals("file")) {
                File f = new File(url.toURI());
                do {
                    f = f.getParentFile();
                } while (!f.isDirectory());
                WORKING_DIRECTORY = f;
            } else if (url.getProtocol().equals("jsp")) {
                String expected = "!/" + Recurso;
                String s = url.toString();
                s = s.substring(4);
                s = s.substring(0, s.length() - expected.length());
                File f = new File(new URL(s).toURI());
                do {
                    f = f.getParentFile();
                } while (!f.isDirectory());
                WORKING_DIRECTORY = f;
            }
        } catch (Exception e) {
            WORKING_DIRECTORY = new File(".");
        }
    }
    return WORKING_DIRECTORY;
}
public static void main(String file) throws Exception 
{
 String dir;   
		File f = new File(file); // Creamos un objeto file
		dir =f.getAbsolutePath(); 
	}
}