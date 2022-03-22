import java.util.Map;

public class Worker implements Runnable{
    
    private final Hash hasher = new Hash();
    private Map<String, Integer> m;
    private int start = 0;
    private int end = 0;
    
    public void use(Map<String, Integer> map, int start, int end){
        this.m = map;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
        for(int i = start; i < end; i++){
            m.put(hasher.hash(i), i);
        }
    }
}
