import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Dispatcher {

    UnHash unhasher = new UnHash();

    public void unhashFromFile(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            String line = br.readLine();
            while(line != null){
                unhasher.unhash(line);
                line = br.readLine();
            }
        } catch(Exception e){
          e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //initialize dispatcher
        Dispatcher d = new Dispatcher();
        //import hashes into dispatcher
        //the dispatcher maintains a hashmap of cracked hashes
        d.unhashFromFile(args[0]);
    }
}
