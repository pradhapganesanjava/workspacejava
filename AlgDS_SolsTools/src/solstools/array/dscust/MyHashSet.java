package solstools.array.dscust;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

	public static void main(String[] args) {
		System.out.println(3%0);
	}

}

class MyHashSetImpl {

    /** Initialize your data structure here. */
    public MyHashSetImpl() {
        
    }
    
    public void add(String key) {
        int hval = this.hashCode(key);
        while(this.lst.get(hval) != null){
            if(key.equals(this.lst.get(hval))){
                return;
            }
            hval = (hval+1) % lst.size();
        }
        this.lst.set(hval, key);
        SZ++;
        if(60 > (SZ/lst.size())*100){
            resize();
        }
    }
    
    public void remove(String key) {
        int hval = this.hashCode(key);
        while(this.lst.get(hval) != null){
            if(key.equals(this.lst.get(hval))){
               this.lst.set(hval, key);
                --SZ;
               return;
            }
            hval = (hval+1) % lst.size();
        }  
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(String key) {
        int hval = this.hashCode(key);
        while(this.lst.get(hval) != null){
            if(key.equals(this.lst.get(hval))){
               return true;
            }
            hval = (hval+1) % lst.size();
        } 
        return false;
    }
    
   
    final int CAPS = 100;
    int SZ = 0;
    List<String> lst = new ArrayList<>(CAPS);
    
    private int hashCode(String s){
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum += (s.charAt(i) + (i * Math.pow(2, 31)));
        }
        return sum % lst.size();
    }
    
    private void resize(){
        List<String> nlst = new ArrayList<>(lst.size()+CAPS);
        List<String> tlst = this.lst;
        this.lst = nlst;
        
        for(int i=0; i<tlst.size(); i++){
            if(tlst.get(i) != null){
                this.add(tlst.get(i));
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */