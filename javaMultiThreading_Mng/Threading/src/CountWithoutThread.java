import java.io.*;
public class CountWithoutThread {
public static void main(String ab[]) throws IOException{
	
	int co = 0;  
    try{
    
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
      
    System.out.println("Number of words  " + co +" time :" + (end-start) );  
    
} catch (FileNotFoundException e) {
  e.printStackTrace();
}
}
}
