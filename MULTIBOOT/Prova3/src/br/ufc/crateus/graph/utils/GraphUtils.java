package br.ufc.crateus.graph.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Soundbank;

import br.ufc.carteus.st.AdjacencyListGraph;
import br.ufc.carteus.st.AdjacencyMatrixGraph;
import br.ufc.carteus.st.Graph;

public class GraphUtils {

	private static boolean[] marked;
	private static int[] edgeTo;
	private static int[] distTo;

	public static <T> LinkedList shortestPath(Graph<T> G, T from, T to) {
		Queue<T> q = new LinkedList<T>();
		LinkedList<T> output = new LinkedList<T>();

		marked = new boolean[G.countVertices()];
		distTo = new int[G.countVertices()];
		edgeTo = new int[G.countVertices()];
		q.add(from);
		int ind = G.index(from);
		
		marked[ind] = true;
		distTo[ind] = 0;

		while (!q.isEmpty()) {
			T m = q.remove();
			for (T w : G.adjacents(m)) {
				int indiceDeW = G.index(w);
				if (!marked[indiceDeW]) {
					q.add(w);
					marked[indiceDeW] = true;
					edgeTo[indiceDeW] = G.index(m);
					distTo[indiceDeW] = distTo[G.index(m)] + 1;
				}
			}
		}
		int indTo = G.index(to);
		System.out.println("A menor distancia é: " + distTo[indTo]);
		int j = indTo;
		while (j != ind) {
			output.add(G.label(j));
			j = edgeTo[j];
		}
		return output;
	}

	static public Graph<String> readFromFile(InputStream is, String sep) {
		Graph<String> graph = new AdjacencyListGraph<String>(198990);
		int k = 0;
		Scanner scanner = new Scanner(is);
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while (br.ready()) {
				String[] vs = br.readLine().split(sep);

				for (int i = 1; i < vs.length; i++) {
					graph.addEdge(vs[0], vs[i]);

				}
				System.out.println(k);
				k++;
			}

			br.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException e) {
			System.out.println(e);
		}
		return graph;
	}
}
