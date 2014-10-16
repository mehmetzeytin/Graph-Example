import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType
public class Node {
	private boolean isVisited;
	private String nodeValue;
	
	public Node (String nodeValue) { // Node Yap�land�r�c�s�. Node yarat�ld���nda 
		                             //BFS aramas�n� do�ru yapabilmek i�in ziyaret edilmemi� olarak i�aretleniyor.
		this.nodeValue = nodeValue;
		setVisiting(false);
	}

	// Di�er s�n�flardan Node s�n�f�n�n private elemanlar�na eri�ebilmek i�in olu�turulan Getter ve Setter Metodlar� : 
	public boolean getVisiting() { 
		return isVisited;
	}

	public void setVisiting(boolean isVisited) {
		this.isVisited = isVisited;
	}
	@XmlAttribute
	public String getNodeValue() {
		return nodeValue;
	}
	
	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}
}
