package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterfaceMap<K,V> implements Map<K,V> {
	
	 private List<Pair> KeyAndValues = new ArrayList<>();

	    @Override
	    public int size() {
	        // BEGIN (write your solution here)
	    	return KeyAndValues.size(); 
	        // END
	    }

	    @Override
	    public boolean isEmpty() {
	        // BEGIN (write your solution here)
	        return KeyAndValues.isEmpty();
	        // END
	    }

	    @Override
	    public boolean containsKey(Object key) {
	        // BEGIN (write your solution here)
	    	if(key == null) throw new NullPointerException();
	    	for(Pair p : KeyAndValues) {
	    		if(key.equals(p.getKey())) 
	    			return true;
	    	}
	        return false;
	        // END
	    }

	    @Override
	    public boolean containsValue(Object value) {
	        // BEGIN (write your solution here)
	    	for(Pair p : KeyAndValues) {
	    		if(value==null ? p.getValue()==null : value.equals(p.getValue())) 
	    			return true;
	    	}
	        return false;
	        // END
	    }

	    @Override
	    public V get(Object key) {
	        // BEGIN (write your solution here)
	    	if(key == null) throw new NullPointerException();
	    	for(Pair p : KeyAndValues) {
	    	if(key.equals(p.getKey()))
	    		return p.getValue();
	    	}
	        return null;
	        // END
	    }
	    
	    @Override
	    public V put(K key, V value) {
	        // BEGIN (write your solution here)
	    	if(key == null) throw new NullPointerException();
	    	try {
	    		if(KeyAndValues.isEmpty()) {
	    			KeyAndValues.add(new Pair(key, value));
	    			return null;
	    		}
	    		for(Pair p : KeyAndValues) {
	    	    	if(key.equals(p.getKey())) {
	    	    		return p.setValue(value);	    	    		
	    	    	}	    	    		    		
	    		}
	    	} catch(UnsupportedOperationException | IllegalArgumentException e) {
	    		e.printStackTrace();
	    	}
	    	KeyAndValues.add(new Pair(key, value));
	    	return null;
	        // END
	    }

	    @Override
	    public V remove(Object key) {
	        // BEGIN (write your solution here)
	    	if(key == null) throw new NullPointerException();
	    	int count = 0;
	    	try {
	    		for(Pair p : KeyAndValues) {
	    	    	if(key.equals(p.getKey())) {
	    	    		V val = p.getValue();
	    	    		KeyAndValues.remove(count);
	    	    		return val;
	    	    	}
	    	    	count++;	    		
	    		}
	    	} catch(UnsupportedOperationException e) {
	    		e.printStackTrace();
	    	}
	    	System.out.println("Map not found");
	    	return null;
	        // END
	    }

	    @Override
	    public void putAll(Map<? extends K, ? extends V> m) {
	        for (Map.Entry<K, V> e : (Set<Map.Entry<K, V>>)(Set)m.entrySet())
	            put(e.getKey(), e.getValue());
	    }

	    @Override
	    public void clear() {
	        // BEGIN (write your solution here)
	        try {
	        	KeyAndValues.clear();
	        } catch(UnsupportedOperationException e) {
	        	e.printStackTrace();
	        }        
	        // END
	    }

	    @Override
	    public Set<K> keySet() {
	        final Set<K> keys = new HashSet<K>();
	        for (Pair p : KeyAndValues) keys.add(p.getKey());
	        return keys;
	    }

	    @Override
	    public Collection<V> values() {
	        // BEGIN (write your solution here)
	    	Collection<V> value = new ArrayList<>();
	    	int count = 0;
	    	for(Pair p : KeyAndValues) {
	    		value.add(p.getValue());
	    	}
	        return value;
	        // END
	    }

	    @Override
	    public Set<Entry<K, V>> entrySet() {
	        return (Set<Entry<K, V>>)(Set)new HashSet<>(KeyAndValues);
	    }
	    
	    @Override
	    public String toString() {
	    	StringBuilder str = new StringBuilder();
	    	for(Pair p : KeyAndValues) {
	    		str.append(p);
	    	}
	    	String s = new String(str);
	    	return s;
	    }

	    private class Pair implements Map.Entry<K, V> {

	        private final K key;

	        private V value;

	        private Pair(K key, V value) {
	            this.key = key;
	            this.value = value;
	        }

	        public K getKey() {
	            return key;
	        }

	        public V getValue() {
	            return value;
	        }

	        @Override
	        public V setValue(V value) {
	            final V oldValue = this.value;
	            this.value = value;
	            return oldValue;
	        }

	        @Override
	        public boolean equals(Object o) {
	            if (this == o) return true;

	            Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


	            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
	            return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

	        }

	        @Override
	        public int hashCode() {
	            return (key   == null ? 0 :   key.hashCode()) ^
	                    (value == null ? 0 : value.hashCode());
	        }
	        
	        @Override
		    public String toString() {
		   	return String.format("%s=%s  ",this.getKey(), this.getValue()); 
		    }
	    }
	    
	 
	    

}
