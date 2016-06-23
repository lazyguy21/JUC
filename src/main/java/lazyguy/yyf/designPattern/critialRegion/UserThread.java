package lazyguy.yyf.designPattern.critialRegion;

/**
 * Created by tobi on 16-6-22.
 */
public class UserThread extends Thread{
    private final String myName;
    private final String myAddress;
    private final Gate gate;
    public UserThread(String myName,String myAddress,Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName+" in "+myAddress +" begin !");
     while (true){
         gate.pass(myName,myAddress);
     }
    }
}
