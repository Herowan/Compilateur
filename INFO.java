
public class INFO {
  // le type
	protected DTYPE type;

	public DTYPE getType() {
		return type;
	}

	// constructeur
	public INFO(DTYPE t) {
		type = t;
	}

	//
	// affichage
	public String toString() {
		return "; INFO : " + "type=" + type ;
	}
}
