import java.util.*;
public class PC { 
        LinkedList<Integer> l = new LinkedList<>(); 
        int q = 5; 
        public void produce() throws InterruptedException 
        { 
            int c = 0; 
            while (true) { 
                synchronized (this) 
                { 
                    while (l.size() == q) 
                        wait(); 
  
                    System.out.println("Producer produced "
                                       + c); 
                    l.add(c++); 
                    notify(); 
                    Thread.sleep(1000); 
                } 
            } 
        } 
  
        public void consume() throws InterruptedException 
        { 
            while (true) { 
                synchronized (this) 
                { 
                    while (l.size() == 0) 
                        wait(); 
  
                    int val = l.removeFirst(); 
  
                    System.out.println("Consumer consumed "
                                       + val); 
                    notify(); 
                    Thread.sleep(1000); 
                } 
            } 
        } 
    } 
