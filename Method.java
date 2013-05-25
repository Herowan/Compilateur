/** Classe Methode ou INFOMethod, cad TDS de la methode */


public class Method {

    /* attributs */
    boolean isMainMethod;
    ArrayList<Attribut> liste_params;
    ArrayList<Attribut> liste_varlocales;
    TYPE t_retour;
    String name;


    // constructeur d'un constructeur
    public Method(String name,ArrayList<Attribut> l){
        this.liste_params = l;
        this.name = name;
        this.isMainMethod = false ;
    }

    // constructeur d'une procedure
    public Method(String name, ArrayList<Attribut> l, Type type ){
        this.liste_params = l;
        this.name = name;
        this.isMainMethod = name.equals("main") && type==null && (l==null || l.size()==0) ;//voidtype a ajouter
        if type != null t_retour = type;
        liste_varlocales = new ArrayList<Attribut>();
    }


    public boolean isConstructeur(){
    return t_retour==null;
    }

    public Type getType(){
        return t_retour;
    }

    public void setType(Type t){
        this.t_retour = t;
    }

    public ArrayList<Attribut> getParams(){
        return this.liste_params;
    }

    public void addParam(Attribut a){
        this.liste_params.add(a);
    }
    public Attribut chercherLocalement(String nom,Type t){
        Iterator<Attribut> i = liste_varlocales.iterator();
        while(i.hasNext()){
            if(i.nom == nom && i.type == t) return i;
        }
        Iterator<Attribut> j = liste_params.iterator();
        while(j.hasNext()){
            if(j.nom == nom && j.type == t) return j;
        }

        return null;
    }

    public ArrayList<Attribut> getVarlocales(){
        return this.liste_varlocales;
    }

    public void addVarlocale(Attribut a){
        this.liste_varlocales.add(a);
    }





        



}
