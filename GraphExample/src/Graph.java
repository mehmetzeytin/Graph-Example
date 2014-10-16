import java.util.LinkedList;
import java.util.Queue;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//@XmlRootElement
public class Graph {
	
	private int adjMatrix [][];
	//@XmlJavaTypeAdapter(MatrixAdapter.class)
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	
	private int nodeNum;
	//@XmlElement
	private Node nodeList[];
	private final int maxVertex = 15;
	private Queue<Integer> queue;
	private int component = 0; // Graphtaki bile�en say�s�n� bulmak i�in yarat�lan de�i�ken.
	private int count = 0; // Her bile�endeki Node say�s�n� bulmak i�in yarat�lan de�i�ken.
	
	public Graph () { // Graph Yap�land�r�c�s�. Burada belirlenen maksimum say�da bir Node dizisi ve kom�uluk matrisi olu�turuluyor.
					  //Ayr�ca kom�uluk Matrisinin t�m elemanlar�na ilk de�er olarak 0 atan�yor. Ve BFS aramay� yapabilmek ad�na 
					  //bir Kuyruk olu�turuluyor.
		nodeList = new Node[maxVertex];
		adjMatrix = new int[maxVertex][maxVertex];
		nodeNum = 0;
		
		for(int i = 0; i < maxVertex; i++ )
			for(int j = 0; j < maxVertex; j++)
				adjMatrix[i][j] = 0;
		queue = new LinkedList<Integer>();
	}
	
	public void addNode(String nodeValue) { // Graph i�erisine Node eklemeye yarayan Metod.
		nodeList[nodeNum++] = new Node(nodeValue);
	}
	
	public void addEdge(int node1, int node2, int distance) { // Node' lar aras�ndaki ba�� kurmaya yarayan Metod.
		adjMatrix[node1][node2] = distance;
		adjMatrix[node2][node1] = distance;
	}

	public int getNodeNum() { // Main' den toplam node say�s�na eri�ebilmek i�in olu�turdu�um Getter Metodu.
		return nodeNum;
	}
	public int totalDistance () { // Graph' taki Node' lar aras�ndaki toplam mesafeyi bulup d�nd�ren Metod.
		int total = 0;
		for (int i = 0; i < nodeNum; i++)
			for(int j = i; j < nodeNum; j++) // Tekrar ayn� Node' u dola�mas�n� engellemek ad�na daha �nce bak�lanlar� atl�yor.
				if(adjMatrix[i][j] != 0)
					total += adjMatrix[i][j];
		return total;
	}
	
	public void BFS() { // Graphtaki bile�enleri bulmak ve graph�n ba�l� elemanlar�na eri�ip bunlar� listelemek i�in yarat�lan BFS Metodu.
		for(int j = 0; j < nodeNum; j++) { // Node listesindeki t�m elemanlar� dola��yor.
			if(nodeList[j].getVisiting() == false) { // �lk tur i�in Node lar� yazd�r�yor 
													 //ve ilk turdan sonra ba�ka bile�en olup olmad���n� kontrol ediyor. 
				component++;
				nodeList[j].setVisiting(true); // Dola��lan her Node i�aretleniyor.
				display(j);
				queue.add(j); // Bile�en i�in ilk eleman kuyru�a ekleniyor.
				int n2;
		
				while( !queue.isEmpty() ) { 
					int n1 = queue.remove();
					count++;
					while( (n2 = getUnvisitedNodes(n1)) != -1 ) { // ��aretlenmmei� kom�u varsa bu d�ng�ye girip devam ediyor.
						nodeList[n2].setVisiting(true);
						System.out.print(", ");
						display(n2);
						queue.add(n2);
					}
				}
				System.out.println();
				System.out.println(component + ". bile�enin sonu. Bu bile�ende " + count + " adet node bulunmaktadir.");
				System.out.println();
			}
			count = 0;
		}
		for(int i = 0; i < getNodeNum(); i++) { // Node lar�n tutuldu�u dizinin elemanlar�n� tekrar gezilmemi� olarak de�i�tiren d�ng�.
			nodeList[i].setVisiting(false);
		}
	}
	
	public int BFS(String value) { // BFS Methodunu Overload edip sadece girilen Node degerinin Graph' ta bulunup bulunmadigini BFS arama ile kontrol 
								   // etmek icin olsturulan yeni BFS Metodu. 
		for(int j = 0; j < nodeNum; j++) { // Node listesindeki t�m elemanlar� dola��yor.
			if(nodeList[j].getVisiting() == false) { // �lk tur i�in Node lar� yazd�r�yor 
													 //ve ilk turdan sonra ba�ka bile�en olup olmad���n� kontrol ediyor. 			
				nodeList[j].setVisiting(true); // Dola��lan her Node i�aretleniyor.
				if(nodeList[j].getNodeValue().equals(value))
					return 1;

				queue.add(j); // Bile�en i�in ilk eleman kuyru�a ekleniyor.
				int n2;
		
				while( !queue.isEmpty() ) { 
					int n1 = queue.remove();
					while( (n2 = getUnvisitedNodes(n1)) != -1 ) { // ��aretlenmmei� kom�u varsa bu d�ng�ye girip devam ediyor.
						nodeList[n2].setVisiting(true);
						queue.add(n2);
						if(nodeList[n2].getNodeValue().equals(value))
							return 1;
					}
				}
			}
		}
		for(int i = 0; i < getNodeNum(); i++) { // Node lar�n tutuldu�u dizinin elemanlar�n� tekrar gezilmemi� olarak de�i�tiren d�ng�.
			nodeList[i].setVisiting(false);
		}
		return -1;
	}
	
	/*public void displayTheDegrees() { // T�m Node' lar�n derecelerini Kom�uluk Matrisi yard�m�yla bulup ekrana yazd�ran Metod.
		int degree = 0;
		
		for(int i = 0; i < nodeNum; i++){
			for(int j = 0; j < nodeNum; j++){
				if(adjMatrix[i][j] == 1 )
					degree ++;
			}
			System.out.println(nodeList[i].getNodeValue() + " Node unun derecesi : " + degree);
			degree = 0;
		}
	}
	*/
	
	public int displayDegree(String value) { // �stenilen Node' un de�erini al�p o Node' un derecesini d�nd�ren Metod.
		int degree = 0 ;
		for(int i = 0; i < nodeNum; i++)
		{
			if(nodeList[i].getNodeValue().equals(value)){
				for(int j = 0; j < nodeNum; j++){
					if(adjMatrix[i][j] != 0)
						degree++;
				}
			}
		}
		return degree;
	}
	
	public int getUnvisitedNodes(int n) { // Her Node' un BFS ile ziyaret edilmeyen bir kom�usu olup olmad���n� bulmaya yarayan Metod.
		for(int i = 0; i < getNodeNum(); i ++)
			if(adjMatrix[n][i] != 0 && nodeList[i].getVisiting() == false)
				return i;
		return -1;
	}
	
	public void graphReset() { // �stenildi�i takdirde graph� s�f�rlay�p yeni bir nesne olu�turmadan ayn� graph �zerinde devam etmeye yarayan metod.
		for(int i = 0; i < nodeNum; i++)
			for(int j = 0; j < nodeNum; j++)
				adjMatrix[i][j] = 0;
	}
	
	public void display(int n) { // �lgili Node bilgisini ekrana yazd�ran Metod.
		System.out.print(nodeList[n].getNodeValue());
	}

}
