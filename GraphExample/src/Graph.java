import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	private int adjMatrix [][];
	private int nodeNum;
	private Node nodeList[];
	private final int maxVertex = 15;
	private Queue<Integer> queue;
	private int component = 0; // Graphtaki bileþen sayýsýný bulmak için yaratýlan deðiþken.
	private int count = 0; // Her bileþendeki Node sayýsýný bulmak için yaratýlan deðiþken.
	
	public Graph () { // Graph Yapýlandýrýcýsý. Burada belirlenen maksimum sayýda bir Node dizisi ve komþuluk matrisi oluþturuluyor.
					  //Ayrýca komþuluk Matrisinin tüm elemanlarýna ilk deðer olarak 0 atanýyor. Ve BFS aramayý yapabilmek adýna 
					  //bir Kuyruk oluþturuluyor.
		nodeList = new Node[maxVertex];
		adjMatrix = new int[maxVertex][maxVertex];
		nodeNum = 0;
		
		for(int i = 0; i < maxVertex; i++ )
			for(int j = 0; j < maxVertex; j++)
				adjMatrix[i][j] = 0;
		queue = new LinkedList<Integer>();
	}

	public void addNode(String nodeValue) { // Graph içerisine Node eklemeye yarayan Metod.
		nodeList[nodeNum++] = new Node(nodeValue);
	}
	
	public void addEdge(int node1, int node2) { // Node' lar arasýndaki baðý kurmaya yarayan Metod.
		adjMatrix[node1][node2] = 1;
		adjMatrix[node2][node1] = 1;
	}

	public void BFS() { // Graphtaki bileþenleri bulmak ve graphýn baðlý elemanlarýna eriþip bunlarý listelemek için yaratýlan BFS Metodu.
		for(int j = 0; j < nodeNum; j++) { // Node listesindeki tüm elemanlarý dolaþýyor.
			if(nodeList[j].getVisiting() == false) { // Ýlk tur için Node larý yazdýrýyor 
													 //ve ilk turdan sonra baþka bileþen olup olmadýðýný kontrol ediyor. 
				component++;
				nodeList[j].setVisiting(true); // Dolaþýlan her Node iþaretleniyor.
				display(j);
				queue.add(j); // Bileþen için ilk eleman kuyruða ekleniyor.
				int n2;
		
				while( !queue.isEmpty() ) { 
					int n1 = queue.remove();
					count++;
					while( (n2 = getUnvisitedNodes(n1)) != -1 ) { // Ýþaretlenmmeiþ komþu varsa bu döngüye girip devam ediyor.
						nodeList[n2].setVisiting(true);
						System.out.print(", ");
						display(n2);
						queue.add(n2);
					}
				}
				System.out.println();
				System.out.println(component + ". bileþenin sonu. Bu bileþende " + count + " adet node bulunmaktadir.");
				System.out.println();
			}
			count = 0;
		}
		for(int i = 0; i < getNodeNum(); i++) { // Node larýn tutulduðu dizinin elemanlarýný tekrar gezilmemiþ olarak deðiþtiren döngü.
			nodeList[i].setVisiting(false);
		}
	}
	
	public void displayTheDegrees() { // Tüm Node' larýn derecelerini Komþuluk Matrisi yardýmýyla bulup ekrana yazdýran Metod.
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
	
	public int getUnvisitedNodes(int n) { // Her Node' un BFS ile ziyaret edilmeyen bir komþusu olup olmadýðýný bulmaya yarayan Metod.
		for(int i = 0; i < getNodeNum(); i ++)
			if(adjMatrix[n][i] == 1 && nodeList[i].getVisiting() == false)
				return i;
		return -1;
	}
	
	public void graphReset() { // Ýstenildiði takdirde graphý sýfýrlayýp yeni bir nesne oluþturmadan ayný graph üzerinde devam etmeye yarayan metod.
		for(int i = 0; i < nodeNum; i++)
			for(int j = 0; j < nodeNum; j++)
				adjMatrix[i][j] = 0;
	}
	
	public void display(int n) { // Ýlgili Node bilgisini ekrana yazdýran Metod.
		System.out.print(nodeList[n].getNodeValue());
	}

	public int getNodeNum() { // Main' den toplam node sayýsýna eriþebilmek için oluþturduðum Getter Metodu.
		return nodeNum;
	}

}
