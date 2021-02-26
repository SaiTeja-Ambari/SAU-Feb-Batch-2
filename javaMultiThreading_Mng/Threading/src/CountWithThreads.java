import java.io.BufferedReader;
import java.io.FileReader;


public class CountWithThreads implements Runnable{

	@Override
	public void run() {
		try{
		    int co=0;
		    FileReader file = new FileReader("F:\\accolite\\javaMultiThreading_Mng\\Words.txt");  
		    BufferedReader br = new BufferedReader(file);  
		    String ip;
		    long start=System.nanoTime();
		    while((ip = br.readLine()) != null) {  
		        String w[] = ip.split(" ");  
		        co = co + w.length;  
		    }  
		    br.close(); 
		    long end=System.nanoTime();
		      
		    System.out.println("Number of words  " + co + " time :" + (end-start)  );  
		    
		
	}
		catch(Exception e){
			
		}
	}
	public static void  main(String ab[]){
    int n = 4; 
    for (int i = 0; i < n; i++) {
        Thread object
            = new Thread(new CountWithThreads(	));
        object.start();
    }
			
	}
}
