package week10;

public class Wrapper <E>{
    E mydata;
    public void set(E x){
        mydata = x;
    }
    public E get(){ return mydata;}
}
