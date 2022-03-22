import java.util.HashMap;
import java.util.Map;

public class UnHash {
    
    private static Hash hasher = new Hash();
    private int numHashes = 0;
    //dictionary for attack
    Map<String, Integer> dict;
    
    public UnHash(){
        //multithread here to generate values in map up to 134345

        dict = new HashMap<String, Integer>();
    }
    
    public void unhash(String hash){
        while(!dict.containsKey(hash)){
            numHashes++;
            dict.put(hasher.hash(numHashes), numHashes);  
        }
        System.out.println(dict.get(hash));
    }

    public static void main(String[] args) {
        UnHash u = new UnHash();
        u.unhash(args[0]);
    }

}