
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import map.HashAssociation;

public class Hastable<K,V> implements Map<K,V> {

protected static final String RESERVED = "RESERVED";
protected Vector<HashAssociation<K,V>> data;
protected int count;
protected final double maximumLoadFactor = 0.6;

public Hastable(int initialCapacity)
// pre: initialCapacity > 0
// post: constructs a new Hashtable
// holding initialCapacity elements
{
   Assert.pre(initialCapacity > 0, "Hashtable capacity must be positive.");
   data = new Vector<HashAssociation<K,V>>();
   data.setSize(initialCapacity);
   count = 0;
}

public Hastable()
// post: constructs a new Hashtable
{
   this(997);
}

protected int locate(K key)
{
	// compute an initial hash code
   int hash = Math.abs(key.hashCode() % data.size());
	// keep track of first unused slot, in case we need it
   int reservedSlot = -1;
   boolean foundReserved = false;

   while (data.get(hash) != null)
   {
        if (data.get(hash).reserved()) {
           // remember reserved slot if we fail to locate value
           if (!foundReserved) {
               reservedSlot = hash;
               foundReserved = true;
           }
           } else {
             // value located? return the index in table
             if (key.equals(data.get(hash).getKey())) return hash;
           }
         // linear probing; other methods would change this line:
         hash = (1+hash)%data.size();
    }
   // return first empty slot we encountered
   if (!foundReserved) return hash;
   else return reservedSlot;
}


public V put(K key, V value)
	// pre: key is non-null object
	// post: key-value pair is added to hash table
	{
	if (maximumLoadFactor*data.size() <= (1+count)) {
		extend();
	}
	
	int hash = locate(key);
	if (data.get(hash) == null || data.get(hash).reserved())
	{ // logically empty slot; just add association
		data.set(hash,new HashAssociation<K,V>(key,value));
		count++;
		return null;
	} else {
	// full slot; add new and return old value
	HashAssociation<K,V> a = data.get(hash);
	V oldValue = a.getValue();
	a.setValue(value);
	return oldValue;
	}
}

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
