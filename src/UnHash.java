import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnHash {
    
    private static Hash hasher = new Hash();
    private int numHashes = 0;
    //dictionary for attack
    Map<String, Integer> dict;
    
    public UnHash(){
        dict = new ConcurrentHashMap<String, Integer>();
        //multithread here to generate values in map up to 134345
        int numThreads = 13;
        int valuesPerThread = 10336;
        List<Thread> threads = new ArrayList<>(numThreads);
        for(int i = 0; i < numThreads; i++){
            Thread thread = new Thread(new Worker(dict, i*valuesPerThread, (i+1)*valuesPerThread-1));
            thread.start();
            threads.add(thread);
        }
        for(Thread t : threads){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public void unhash(String hash){
        //while(!dict.containsKey(hash)){
        //    numHashes++;
        //    dict.put(hasher.hash(numHashes), numHashes);  
        //}
        System.out.println(dict.get(hash));
    }

    public static void main(String[] args) {
        UnHash u = new UnHash();
        u.unhash(args[0]);
    }

}