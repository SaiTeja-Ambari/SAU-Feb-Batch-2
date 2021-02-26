package JavaAdv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Merge {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, ParseException {
		
		Date myDate = new Date();
		String date = new SimpleDateFormat("dd/MM/yyyy").format(myDate);
		System.out.println("date is: " + date);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("MergeOP.xml");
		NodeList list = doc.getElementsByTagName("CSR_Producer");
		for(int i = 0; i < list.getLength(); i++) {
			Node s = list.item(i);
			if(s.getNodeType() == Node.ELEMENT_NODE) {
				Element listItem = (Element) s;
				System.out.println(listItem.getAttribute("NIPR_Number"));
				NodeList list2 = listItem.getElementsByTagName("License");
				for(int k = 0; k<list2.getLength(); k++) {
					Node s2 = list2.item(k);
					if(s2.getNodeType() == Node.ELEMENT_NODE) {
						Element l2 = (Element) s2;	
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						System.out.println(l2.getAttribute("License_Expiration_Date"));
							if(sdf.parse(l2.getAttribute("License_Expiration_Date")).before(sdf.parse(date))) {
								System.out.println("Invalid");
								String filename= "InvalidLicense.txt";
							    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
							    fw.write("Date_Status_Effective: " + l2.getAttribute("Date_Status_Effective") + ", License_Class: " + 
						    		l2.getAttribute("License_Class") + ", License_Class_Code: " + 
						    		l2.getAttribute("License_Class_Code") + ", License_Expiration_Date: " + 
						    		l2.getAttribute("License_Expiration_Date") + ", License_Issue_Date: " + 
						    		l2.getAttribute("License_Issue_Date") + ", License_Number: " + 
						    		l2.getAttribute("License_Number") + ", License_Status: " + 
						    		l2.getAttribute("License_Status") + ", Resident_Indicator: " + 
						    		l2.getAttribute("Resident_Indicator") + ", State_Code: " +
						    		l2.getAttribute("State_Code") + ", State_ID: " +
						    		l2.getAttribute("State_ID") + "\n\n\n"
						    	);//appends the string to the file
							    fw.close();

							}
							else if(sdf.parse(l2.getAttribute("License_Expiration_Date")).after(sdf.parse(date))) {
								String filename= "ValidLicense.txt";
							    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
							    fw.write("Date_Status_Effective: " + l2.getAttribute("Date_Status_Effective") + ", License_Class: " + 
							    		l2.getAttribute("License_Class") + ", License_Class_Code: " + 
						    		l2.getAttribute("License_Class_Code") + ", License_Expiration_Date: " + 
						    		l2.getAttribute("License_Expiration_Date") + ", License_Issue_Date: " + 
						    		l2.getAttribute("License_Issue_Date") + ", License_Number: " + 
						    		l2.getAttribute("License_Number") + ", License_Status: " + 
						    		l2.getAttribute("License_Status") + ", Resident_Indicator: " + 
						    		l2.getAttribute("Resident_Indicator") + ", State_Code: " +
						    		l2.getAttribute("State_Code") + ", State_ID: " +
						    		l2.getAttribute("State_ID") + "\n\n\n"
						    	);//appends the string to the file
							    fw.close();

								System.out.println("Valid");
							}
					}					
				}
			}
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("Merged_Output.xml"));
        transformer.transform(source, result);
	}
	
	
	
	
}