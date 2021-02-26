package javacore;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;

//import com.opencsv.CSVWriter;

   
public class Change {  
    public static void main(String[] args) throws IOException {  
    		Map<Integer, Integer> Total = new HashMap();
    		Map<Integer, Integer> map = new HashMap();
    		
   
     try {  
   
        File file = new File("src/javacore/studs.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Studs.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Studs que= (Studs) jaxbUnmarshaller.unmarshal(file);  
        List<Stud> list=que.getStudent();  
        
        for(Stud s:list) {
			Total.put(s.getRoll(), Total.getOrDefault(s.getRoll(), 0)+s.getMarks());
		}
        for(Map.Entry m : Total.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());    
           }
        File file1 = new File("C:\\Users\\Ramchander\\OneDrive\\Desktop\\student.txt"); 
        BufferedWriter bf = null; 
        
        try { 
  
            // create new BufferedWriter for the output file 
            bf = new BufferedWriter(new FileWriter(file1));
            bf.write("ROLL  MARKS");
            bf.newLine();
            for (Entry<Integer, Integer> entry : 
                Total.entrySet()) { 
 
               // put key and value separated by a colon 
               bf.write(entry.getKey() + "    "
                        + entry.getValue()); 
 
               // new line 
               bf.newLine(); 
           } 
 
           bf.flush(); 
        }
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        finally { 
  
            try { 
  
                // always close the writer 
                bf.close(); 
            } 
            catch (Exception e) { 
            } 
        } 
        File file3 = new File("C:\\Users\\Ramchander\\OneDrive\\Desktop\\student.txt"); 
        
        BufferedReader br = new BufferedReader(new FileReader(file3)); 
        String st; 
        st=br.readLine();
        while ((st = br.readLine()) != null) 
          {String[] arr=st.split("    ");
          int x=Integer.parseInt(arr[0]);
          int y=Integer.parseInt(arr[1]);
          map.put(x, y);
          }
        int j=1;
        FileWriter writer = (new FileWriter("C:\\Users\\Ramchander\\OneDrive\\Desktop\\ranks.txt"));
        String l[]= {"RANK","ROLL","MARKS"};
        for(String k : l)
        	writer.write(k+" ,");
        for (Entry<Integer, Integer> entry : 
            map.entrySet()) {
        	String l1[]= {Integer.toString(j),Integer.toString(entry.getKey()),Integer.toString(entry.getValue())};
        	for(String k : l1)
            	writer.write(k+" ,");
            
        	j=j+1;
        }
      }
     
     catch (JAXBException e) {  
        e.printStackTrace();  
      }  
   
    }  
}  