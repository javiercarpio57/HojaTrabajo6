
package hojatrabajo6;
import java.util.*;

/**
 *
 * @author javie
 */
public class FactoryMap {
    
    public Map FactoryMap(int opcion){
        
        switch(opcion){
            case 1:
                return new HashMap();
            case 2:
                return new TreeMap();
            case 3:
                return new LinkedHashMap();    
        }
        
        return null;
    }
    
}
