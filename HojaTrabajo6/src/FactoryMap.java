
import java.util.*;

/**
 * @author Sergio Marchena
 * @author Javier Carpio
 * @version 05.03.2018
 */
public class FactoryMap {
    
    public Map FactoryMap(int opcion){
        
        switch(opcion){
            case 1:
                System.out.println("Eligio utilizar HashMap");
                return new HashMap();
            case 2:
                System.out.println("Eligio utilizar TreeMap");
                return new TreeMap();
            case 3:
                System.out.println("Eligio utilizar LinkedHashMap");
                return new LinkedHashMap();    
        }
        
        return null;
    }
    
}
