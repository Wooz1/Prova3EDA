package br.ufc.carteus.st;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class AdjacencyMatrixGraph<T> implements Graph<T> {
	
	int qtdMaxV = 0;
	public int qtdV = 0;
	int qtdE = 0;
	private boolean[][] matriz;
	Map<Integer,T> adjMap;
	
	public AdjacencyMatrixGraph(int v) {
		this.qtdMaxV = v;
		this.matriz = new boolean[qtdMaxV][qtdMaxV];
		adjMap = new HashMap<Integer,T>();
		
	}
	
	@Override
	public void addEdge(T v1, T v2) {

		int i = hasEdge(v1);
		int j = hasEdge(v2);
		if(i != -1 && j != -1 ) {
			if(matriz[i][j] == false && matriz[j][i] == false) {
			matriz[i][j] = true;
			matriz[j][i] = true;	
			qtdE++;
			}
			else {
				System.out.println("O vertice de rotulo "+adjMap.get(i)+" e "+adjMap.get(j)+" ja estão conectados");
			}
		}
	}
	private int hasEdge(T v1) {
		for(int i =0;i<qtdV;i++) {
			if(adjMap.get(i).equals(v1)) {
				return i;
			}
		}
		if(qtdV < qtdMaxV) {
			adjMap.put(qtdV,v1);
			qtdV++;
			return qtdV - 1 ;
		}		
		return -1;
	}
	@Override
	public int index(T v) {
		for(int i = 0;i<qtdV;i++) {
			if(adjMap.get(i).equals(v)) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public int countVertices() {
		return qtdV;
	}
	@Override
	public int countEdges() {
		return qtdE;
	}
	

	@Override
	public T label(int index) {
		return adjMap.get(index);
	}
	@Override
	public boolean contains(T v) {
		if(index(v)!=-1) {
			return true;
		}
		return false;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		LinkedList<T> adj = new LinkedList<T>();
		int ind = index(v);
		for(int i = 0;i<qtdV;i++) {
			if(matriz[ind][i]==true) {
				adj.add(label(i));
			}
		}
		return adj;
	}
	@Override
	public int degree(T v) {
		int c = 0;
		for(T i : adjacents(v)) {
			c++;
		}
		return c;
	}
	
}
