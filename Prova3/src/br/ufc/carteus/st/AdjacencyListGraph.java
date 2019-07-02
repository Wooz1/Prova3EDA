package br.ufc.carteus.st;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.lang.model.element.NestingKind;

public class AdjacencyListGraph<T> implements Graph<T> {

	Map<Integer, ArrayList<T>> adjListMap;
	private int qtdMaxV = 0;
	public int qtdV = 0;
	private int qtdE = 0;

	public AdjacencyListGraph(int v) {
		this.qtdMaxV = v;
		adjListMap = new HashMap<Integer, ArrayList<T>>();
		for (int i = 0; i < v; i++) {
			ArrayList<T> vizinhos = new ArrayList<T>();
			adjListMap.put(i, vizinhos);
		}
	}

	@Override
	public void addEdge(T v1, T v2) {
		int i;
		int j;
		i = hasEdge(v1);
		j = hasEdge(v2);

		if (i != -1 && j != -1) {
			if (!(adjListMap.get(i).contains(v2)) && !(adjListMap.get(j).contains(v1))) {
				(adjListMap.get(i)).add(v2);
				(adjListMap.get(j)).add(v1);
				qtdE++;
			} else {
				System.out.println("O vertice de rotulo " + v1 + " e " + v2 + " já estão conectados");
			}
		} else {
			System.out.println("Não foi possivel concluir a inserção");
		}
	}

	private int hasEdge(T v1) {
		for (int i = 0; i < qtdV; i++) {
			if (adjListMap.get(i).get(0).equals(v1)) {
				return i;
			}
		}
		if (qtdV < qtdMaxV) {
			(adjListMap.get(qtdV)).add(v1);
			qtdV++;
			return qtdV - 1;
		}
		return -1;
	}

	public int getIndex(T v1) {
		for (int i = 0; i < qtdV; i++) {
			if (adjListMap.get(i).get(0).equals(v1)) {
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
	public int index(T v) {
		for (int i = 0; i < qtdV; i++) {
			if (adjListMap.get(i).get(0).equals(v)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T label(int index) {
		if (index >= qtdV) {
			System.out.println("Não existe tal index");
			return null;
		} else {
			return (adjListMap.get(index)).get(0);
		}

	}

	@Override
	public boolean contains(T v) {
		for (int i = 0; i < qtdV; i++) {
			if ((adjListMap.get(i)).get(0).equals(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		int verifica = getIndex(v);
		if (verifica != -1) {
			LinkedList<T> lista = new LinkedList<T>();
			for (int i = 1; i < adjListMap.get(verifica).size(); i++) {
				lista.add((adjListMap.get(verifica)).get(i));
			}
			return lista;
		}
		return null;
	}

	public Iterable<Integer> adjacentsInt(T v) {
		int verifica = getIndex(v);
		if (verifica != -1) {
			LinkedList<Integer> lista = new LinkedList<Integer>();
			for (int i = 1; i < adjListMap.get(verifica).size(); i++) {
				lista.add(getIndex((adjListMap.get(verifica)).get(i)));
			}
			return lista;
		}
		return null;
	}

	@Override
	public int degree(T v) {

		int c = 0;
		int index = getIndex(v);
		if (index != -1) {
			for (int i = 1; i < adjListMap.get(index).size(); i++) {
				c++;
			}
			return c;
		}
		return index;
	}
}
