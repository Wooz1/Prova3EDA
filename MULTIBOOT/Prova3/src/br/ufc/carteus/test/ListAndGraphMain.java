package br.ufc.carteus.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import br.ufc.carteus.st.AdjacencyListGraph;
import br.ufc.carteus.st.AdjacencyMatrixGraph;
import br.ufc.crateus.graph.utils.GraphUtils;

public class ListAndGraphMain {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		AdjacencyListGraph<String> gpList = new AdjacencyListGraph<String>(11);
		Iterable<String> adjList = new LinkedList<String>();

		gpList.addEdge("0", "3");
		gpList.addEdge("0", "2");
		gpList.addEdge("2", "3");
		gpList.addEdge("2", "8");
		gpList.addEdge("2", "1");
		gpList.addEdge("3", "8");
		gpList.addEdge("8", "1");
		gpList.addEdge("8", "10");
		gpList.addEdge("1", "4");
		gpList.addEdge("10", "4");
		gpList.addEdge("10", "7");
		gpList.addEdge("4", "7");
		gpList.addEdge("4", "5");
		gpList.addEdge("4", "9"); 	
		gpList.addEdge("5", "9");
		gpList.addEdge("5", "6");
		
		System.out.println("A quantidade de vertices que existe no grafo é: "+ gpList.countVertices());
		System.out.println("A quantidade de arestas que existe no grafo é: "+ gpList.countEdges());
		
		System.out.println("O indice do vertice com rotulo '3' é: "+gpList.index("3"));
		System.out.println("O label do indice 3 é: "+ gpList.label(3));
		System.out.println("O grau do vertice de rotulo '2'é: "+gpList.degree("2"));

		System.out.println("A chave de rotulo '0' existe no grafo!! --> "+gpList.contains("0"));
		System.out.println("A chave de rotulo '12' existe no grafo!! --> "+gpList.contains("12"));
		
		System.out.println("O indice de rotulo '2' possui adjacencia para os seguintes rotulos: ");
		adjList = gpList.adjacents("2");
		for(String i : adjList) {
			System.out.println(i);
		}
		
		LinkedList<String> output = new LinkedList<String>();
		output = GraphUtils.shortestPath(gpList, "0", "6");
		for(int i = output.size() -1;i>=0;i--) {
			System.out.println(output.get(i));
		}
		

		InputStream in = new FileInputStream("C:\\Users\\Admin\\Desktop\\EDA\\Prova3\\src\\filmesteste.txt");
		gpList = (AdjacencyListGraph<String>) GraphUtils.readFromFile(in, "/");
//		System.out.println("Os adjacestes de ''Breaker' Morant (1980)' são: ");
//		adjList = gpList.adjacents("'Breaker' Morant (1980)");
//		for(String i : adjList) {
//			System.out.println(i);
//		}
//		System.out.println("Os adjacestes de ''burbs, The (1989)' são: ");
//		adjList = gpList.adjacents("'burbs, The (1989)");
//		for(String i : adjList) {
//			System.out.println(i);
//		}
		System.out.println("Os adjacestes de 'Ôdishon (1999)' são: ");
		adjList = gpList.adjacents("You Can't Take It with You (1938)");
		for(String i : adjList) {
			System.out.println(i);
		}
		System.out.println(gpList.qtdV);
//=============================================================================================================================================
		System.out.println("PARTE DA ADJACENCY MATRIX");
		AdjacencyMatrixGraph<String> gpGraph = new AdjacencyMatrixGraph<String>(11);
		Iterable<String> adjMatrix = new LinkedList<String>();

		GraphUtils utilMatrix = new GraphUtils();
		gpGraph.addEdge("0", "3");
		gpGraph.addEdge("0", "2");
		gpGraph.addEdge("2", "3");
		gpGraph.addEdge("2", "8");
		gpGraph.addEdge("2", "1");
		gpGraph.addEdge("3", "8");
		gpGraph.addEdge("8", "1");
		gpGraph.addEdge("8", "10");
		gpGraph.addEdge("1", "4");
		gpGraph.addEdge("10", "4");
		gpGraph.addEdge("10", "7");
		gpGraph.addEdge("4", "7");
		gpGraph.addEdge("4", "5");
		gpGraph.addEdge("4", "9"); 	
		gpGraph.addEdge("5", "9");
		gpGraph.addEdge("5", "6");
		gpGraph.addEdge("6", "9");

		
		
		System.out.println("A quantidade de vertices que existe no grafo é: "+ gpGraph.countVertices());
		System.out.println("A quantidade de arestas que existe no grafo é: "+ gpGraph.countEdges());
		
		System.out.println("O indice do vertice com rotulo '4' é: "+gpGraph.index("4"));
		System.out.println("O label do indice 3 é: "+ gpGraph.label(2));
		System.out.println("O grau do vertice de rotulo '2'é: "+gpGraph.degree("6"));

		System.out.println("A chave de rotulo '0' existe no grafo!! --> "+gpGraph.contains("3"));
		System.out.println("A chave de rotulo '12' existe no grafo!! --> "+gpGraph.contains("15"));
		
		System.out.println("O indice de rotulo '6' possui adjacencia para os seguintes rotulos: ");
		adjMatrix = gpGraph.adjacents("6");
		for(String i : adjMatrix) {
			System.out.println(i);
		}
		
		LinkedList<String> outputMatrix = new LinkedList<String>();
		outputMatrix = GraphUtils.shortestPath(gpGraph, "10", "6");
		for(int i = outputMatrix.size() -1;i>=0;i--) {
			System.out.println(outputMatrix.get(i));
		}
		

		
		
		
		
		
		
		
		
	}
}
