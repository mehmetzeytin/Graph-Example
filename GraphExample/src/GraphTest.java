
public class GraphTest {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.addNode("Coskun");
		graph.addNode("Erdal");
		graph.addNode("Onur");
		graph.addNode("Mehmet");
		graph.addNode("Sergen");
		graph.addNode("Aysu");
		graph.addNode("G�k�e");
		graph.addNode("Tugay");
		graph.addNode("�zge");
		graph.addNode("Ugurcan");
		graph.addNode("Zeliha");
		graph.addNode("Tuna");
		graph.addNode("�lker");
		graph.addNode("Yavuz");
		graph.addNode("Enis");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);
		graph.addEdge(3, 9);
		graph.addEdge(5, 6);
		graph.addEdge(5, 8);
		graph.addEdge(10, 11);
		graph.addEdge(10, 12);
		graph.addEdge(12, 13);
		graph.addEdge(0, 3);
		graph.addEdge(6, 8);
		graph.addEdge(4, 14);

		System.out.println("Bu graphta toplam " + graph.getNodeNum() + " adet node bulunmaktad�r.");
		System.out.println();
		graph.BFS();
		System.out.println();
		System.out.println("**Tum node lar�n dereceleri : **");
		System.out.println();
		graph.displayTheDegrees();
		

	}

}
