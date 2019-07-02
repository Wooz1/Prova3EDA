package br.ufc.carteus.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import br.ufc.carteus.st.AdjacencyListGraph;
import br.ufc.carteus.st.AdjacencyMatrixGraph;
import br.ufc.carteus.st.Graph;
import br.ufc.crateus.graph.utils.GraphUtils;

public class ListAndGraphMain {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Graph<String> gpList = new AdjacencyListGraph<String>(198990);
		Iterable<String> adjList = new LinkedList<String>();
		LinkedList<String> output = new LinkedList<String>();
		
		InputStream is = new FileInputStream("filmes.txt");
		
		gpList = GraphUtils.readFromFile(is, ",");
		
		System.out.println(GraphUtils.GraphConexos(gpList));
				

	}
}
