import java.util.Scanner;

//import javax.xml.bind.*;

public class GraphTest {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		Scanner in = new Scanner(System.in);		
		
		graph.addNode("Coskun");
		graph.addNode("Erdal");
		graph.addNode("Onur");
		graph.addNode("Mehmet");
		graph.addNode("Sergen");
		graph.addNode("Aysu");
		graph.addNode("Gökçe");
		graph.addNode("Tugay");
		graph.addNode("Özge");
		graph.addNode("Ugurcan");
		graph.addNode("Zeliha");
		graph.addNode("Tuna");
		graph.addNode("Ülker");
		graph.addNode("Yavuz");
		graph.addNode("Enis");
		
		graph.addEdge(0, 1, 50);
		graph.addEdge(0, 2, 20);
		graph.addEdge(1, 2, 30);
		graph.addEdge(3, 4, 10);
		graph.addEdge(3, 5, 100);
		graph.addEdge(3, 6, 20);
		graph.addEdge(3, 7, 25);
		graph.addEdge(3, 9, 35);
		graph.addEdge(5, 6, 24);
		graph.addEdge(5, 8, 12);
		graph.addEdge(10, 11, 16);
		graph.addEdge(10, 12, 24);
		graph.addEdge(12, 13, 33);
		graph.addEdge(0, 3, 432);
		graph.addEdge(6, 8, 500);
		graph.addEdge(4, 14, 1);
		graph.addEdge(3,  3, 22);

		System.out.println("Bu graphta toplam " + graph.getNodeNum() + " adet node bulunmaktadýr.");
		System.out.println();
		graph.BFS();
		
		System.out.println("Derecesini gormek istediginiz Node degerini giriniz : ");
		if(graph.BFS(in.nextLine()) == -1)
			System.out.println("Graph' ta boyle bir node bulunmamaktadir!");
		else{
			int degree = graph.displayDegree(in.nextLine());
			System.out.println("Bu Node' un derecesi : " + degree);
		}
	
		System.out.println("Graph'ýn toplam mesafesi : " + graph.totalDistance() );

		in.close();
		

		/*Graph graph = new Graph();
		try {
			File file = new File("D:\\file.xml");
			JAXBContext jaxb = JAXBContext.newInstance(Graph.class);
			Marshaller jaxbMarshaller = jaxb.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(graph, file);
			jaxbMarshaller.marshal(graph, System.out);
			

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Graph.class);
			
			Unmarshaller unmarshallx = jaxb.createUnmarshaller();
			File xml = new File("D:\\file.xml");
			Graph graph = (Graph) unmarshallx.unmarshal(xml);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		*/
	}

}
