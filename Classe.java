package mjc.mcjava;

import java.util.ArrayList;

public class Classe { 

	public ArrayList<Attribut> attributs;
	public ArrayList<Method> methodes; // a revoir si séparer de constructeurs !
	public Classe ClasseMere;
	boolean hasMain;
	String name;
	// penser a import , faire une liste des import , utile pourquoi?
    	
	
	
	public Classe(String name){		
		this.name = name;
		this.attributs = new ArrayList<Attribut>();
		this.methodes = new ArrayList<Method>();		
	}
	
	public boolean addMethode(Method m){		
		if (isDefined(m != null)) { return false;}
		else {
			methodes.add(m);
			return true;
		}
	}
	
	public Method getMethod(String name){
		for (Method m : methodes)
			if (m.name.equals(name))
				return m;
		   
		 if (ClasseMere != null)
			 return ClasseMere.getMethod(name);
		
			return null;
		
	}
	public boolean addAttribute(Attribut a){
		if (isDefined(a != null)) {return false;}
		else {
			attributs.add(a);
			return true;
		}
	}
	
	public Attribut getAttribute(String name){
		for (Attribut a : attributs)
			if (a.name.equals(name))
				return a;
		    if (ClasseMere !=null)
		    	return ClasseMere.getAttribute(name);
		    
		return null;
	}
	//traitement du extends
	public boolean SetParent(Classe c){ //retour d'un message d'erreur en cas d'erreur
		
		if (c!=null)
			{ClasseMere = c;
			return true;}
			
		else
		{	return false;}		
	}
	
	//sert pour le cas de Point p = pt; Point Colore p = pt , a voir encore !
	
	@Override
	public boolean equals(Object o){
	
		if (o == null) {return false;}
		
		if (this.equals(o))
			return true;
		if (ClasseMere != null)
		 return ClasseMere.equals(o);
		
		return false;
		
	}
	
	//utile si on veut redéclarer une méthode main ou qu'on veuille éxecuter une classe sans main => Error !
	public boolean hasMain () { return hasMain; }
	
	public boolean isDefined(Method m){ //ca marche pas , faudra redéfinir equals dans Method.java !!
		for (Method a : methodes)
			if (a.equals(m))
				return true;
		return false;
	}
	
}
