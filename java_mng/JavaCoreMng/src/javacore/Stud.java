package javacore;
import javax.xml.bind.*;
import java.io.*;
public class Stud {  
private int roll;  
private int marks;  
private String subject;  
public Stud() {}  
public Stud(int roll, int marks, String subject) {  
    super();  
    this.roll = roll;  
    this.marks = marks;  
    this.subject = subject;  
}  
public int getRoll() {  
    return roll;  
}  
public void setRoll(int roll) {  
    this.roll = roll;  
}  
public int getMarks() {  
    return marks;  
}  
public void setMarks(int marks) {  
    this.marks = marks;  
}  
public String getSubject() {  
    return subject;  
}  
public void setSubject(String subject) {  
    this.subject = subject;  
}  
  
}  