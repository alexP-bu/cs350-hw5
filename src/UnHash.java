import java.util.HashMap;

public class UnHash {
    
    //number of values to check for unhasher
    private static final int NUM_VALUES = 100000;
    //dictionary for attack
    HashMap<String, Integer> h;
    
    public UnHash(){
        h = new HashMap<String, Integer>();
        //generate dictionary for attack
        Hash hasher = new Hash();
        for(int i = 0; i < NUM_VALUES; i++){
            h.put(hasher.hash(i), i);
        }
    }
    
    public int unhash(String hash){
        //returns -1 if hash isn't found
        return h.getOrDefault(hash, -1);
    }

    public static void main(String[] args) {
        UnHash u = new UnHash();
        System.out.println(u.unhash(args[0]));
    }
}