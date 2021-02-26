package javacore;
class Singleton 
{ 
	
	private static Singleton single_inst = null; 

	
	public String s; 

	
	private Singleton() 
	{ 
		s = "Sai Teja Ambari"; 
	} 

	
	public static Singleton getInstance() 
	{ 
		if (single_inst == null) 
			single_inst = new Singleton(); 

		return single_inst; 
	} 
} 

class Main 
{ 
	public static void main(String args[]) 
	{ 
		
		Singleton x = Singleton.getInstance(); 



	
		x.s = (x.s).toLowerCase(); 

		System.out.println("String " + x.s); 
		System.out.println("\n"); 


	
	} 
} 

