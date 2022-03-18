import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class Dispatcher {

    LinkedHashMap<String, Integer> hashes = new LinkedHashMap<String, Integer>();
    UnHash u = new UnHash();

    //import a hash and crack it if it's not already in the hashmap
    public void importHashes(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            String line = br.readLine();
            while(line != null){
                String current = line;
                hashes.computeIfAbsent(line, k -> u.unhash(current));
                line = br.readLine();
            }
        } catch(Exception e){
          e.printStackTrace();
        } 
    }
    
    //print cracked values in order of insertion
    public void printHashes(){
        hashes.forEach((k, v) -> System.out.println(v));
    }

    public static void main(String[] args) {
        //initialize dispatcher
        Dispatcher d = new Dispatcher();
        //import hashes into dispatcher
        //the dispatcher maintains a hashmap of cracked hashes
        d.importHashes(args[0].toString());
        //print hashes in the dispatcher
        d.printHashes();
    }
}
