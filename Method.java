package mjc.gc;

import java.util.ArrayList;

public class INFOCLASS  extends INFO{ 

    public ArrayList<INFOATTRIBUTE> attributs;  // plutot tds d'attribut
	public ArrayList<INFOMETHOD> methodes; // a revoir si séparer de constructeurs !
	public INFOCLASS ClasseMere;
	boolean hasMain;
	String name;
	// penser a import , faire une liste des import , utile pourquoi?
    	
//ajouter une méthode getType() qui renvoie un DTYPE ou il ya le nom de la classe	
	
	public INFOCLASS(String name){	
		this.name = name;
		this.attributs = new ArrayList<INFOATTRIBUTE>();
		this.methodes = new ArrayList<INFOMETHOD>();		
	}
	
	public INFOCLASS(String name, INFOCLASS mere){
		this.name = name;
		this.attributs = new ArrayList<INFOATTRIBUTE>();
		this.methodes = new ArrayList<INFOMETHOD>();	
		this.ClasseMere = mere; 
	}
	
	public boolean addMethode(INFOMETHOD m){		
		if (isDefined(m != null)) { return false;}
		else {
			methodes.add(m);
			return true;
		}
	}
	
	public INFOMETHOD getMethod(String name){
		for (INFOMETHOD m : methodes)
			if (m.name.equals(name))
				return m;
		   
		 if (ClasseMere != null)
			 return ClasseMere.getMethod(name);
		
			return null;
		
	}
	public boolean addAttribute(INFOATTRIBUTE a){
		if (isDefined(a != null)) {return false;}
		else {
			attributs.add(a);
			return true;
		}
	}
	
	public INFOATTRIBUTE getattribute(String name){
		for (INFOATTRIBUTE a : attributs)
			if (a.name.equals(name))
				return a;
		    if (ClasseMere !=null)
		    	return ClasseMere.getAttribute(name);
		    
		return null;
	}
	//traitement du extends
	public boolean SetParent(INFOCLASS c){ //retour d'un message d'erreur en cas d'erreur
		
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
	
	public boolean isDefined(INFOMETHOD m){ //ca marche pas , faudra redéfinir equals dans Method.java !!
		for (INFOMETHOD a : methodes)
			if (a.equals(m))
				return true;
		return false;
	}
	
}
