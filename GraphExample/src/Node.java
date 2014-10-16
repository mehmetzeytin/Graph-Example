import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType
public class Node {
	private boolean isVisited;
	private String nodeValue;
	
	public Node (String nodeValue) { // Node Yapýlandýrýcýsý. Node yaratýldýðýnda 
		                             //BFS aramasýný doðru yapabilmek için ziyaret edilmemiþ olarak iþaretleniyor.
		this.nodeValue = nodeValue;
		setVisiting(false);
	}

	// Diðer sýnýflardan Node sýnýfýnýn private elemanlarýna eriþebilmek için oluþturulan Getter ve Setter Metodlarý : 
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
