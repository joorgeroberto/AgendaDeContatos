package dados;
import  java.util.Comparator;
public class Comparador implements Comparator<Contato>
{
	public int compare(Contato o1, Contato o2)
	{  
	    Contato c1 = (Contato) o1;  
	    Contato c2 = (Contato) o2;  
	  
	    return c1.getNome().compareTo(c2.getNome());  
	}  
}
