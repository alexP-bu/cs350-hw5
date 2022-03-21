import java.util.HashMap;

public class UnHash {
    
    private static Hash hasher;
    private int numHashes = 0;
    //dictionary for attack
    HashMap<String, Integer> dict;
    
    public UnHash(){
        dict = new HashMap<String, Integer>();
        hasher = new Hash();
    }
    
    public int unhash(String hash){
        while(!dict.containsKey(hash)){
            numHashes++;
            dict.put(hasher.hash(numHashes), numHashes);  
        }
        return dict.get(hash);
    }

    public static void main(String[] args) {
        UnHash u = new UnHash();
        System.out.println(u.unhash(args[0]));
    }

}