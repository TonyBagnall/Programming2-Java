/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week12.topic13_threads;

import java.util.ArrayList;

/**
 *
 * @author ajb
 */
public class SharedMemory {
    public void alterSharedMemory(){}
    synchronized public void alterSharedMemorySynchronized(){}

    
    public ArrayList<Integer> id;
    
    public boolean contains(Integer i){ return id.contains(i);}
    public boolean remove(Integer i){ return id.remove(i);}
    public boolean add(Integer i){ return id.add(i);}
    
    
}
