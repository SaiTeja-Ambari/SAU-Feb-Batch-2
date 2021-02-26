package javacore;
import java.util.List;  

import javax.xml.bind.annotation.*;  
@XmlRootElement  
public class Studs {  
private List<Stud> stud;  

public Studs() {}  
public Studs(List<Stud> stud) {  
    super(); 
    this.stud = stud;  
}  
  
@XmlElement  
public List<Stud> getStudent() {  
    return stud;  
}  
public void setStudent(List<Stud> stud) {  
    this.stud = stud;  
}  
}  
