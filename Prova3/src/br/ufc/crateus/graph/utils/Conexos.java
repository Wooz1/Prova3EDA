package br.ufc.crateus.graph.utils;

import java.util.LinkedList;

import br.ufc.carteus.st.Graph;

public class Conexos {

	private boolean[] marked;
	private int[] id;
	private int count;

	public Conexos(Graph G) {
		marked = new boolean[G.countVertices()];
		id = new int[G.countVertices()];
		for (int s = 0; s < G.countVertices(); s++) {
			if (!marked[s]) {
				dfs(G, G.label(s));
				count++;
			}
		}
	}

	private <T> void dfs(Graph G, T v) {

		marked[G.index(v)] = true;
		id[G.index(v)] = count;
		for (T w : (LinkedList<T>) G.adjacents(v))
			if (!marked[G.index(w)])
				dfs(G, w);
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}
}
