package lazyguy.yyf.critialRegion;

/**
 * Created by tobi on 16-6-22.
 */
public class ThreadSafeGate extends Gate {


    public synchronized void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;
        check();
    }
    private void printState(){
        System.out.println("name :"+name +" address : "+address);
    }

    private void check() {
       if( name.charAt(0)!=address.charAt(0)){
           System.out.println("error occurs : ");
           printState();
       }
        System.out.println(count);
    }
}
