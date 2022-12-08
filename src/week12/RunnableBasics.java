package week12;

public class RunnableBasics implements Runnable{
    String name;
    RunnableBasics(String n){
        name=n;
    }
    public void run(){
        for(int i=0;i<10;i++)
            System.out.println(name+i);
    }
}
