package br.ufc.carteus.st;

public interface Graph<T> {

	//retorna o n´umero de v´ertices do grafo
	int countVertices();
	
	//retorna o n´umero de arestas do grafo
	int countEdges();
	
	//retorna o indice do vertice v, que indica, na sequencias de
	//insercoes, a posição de insercão do vértice
	int index(T v);

	//retorna o rótulo do vértice cujo índice é index
	T label(int index);

	//vérifica se existe vértice com rótulo v
	boolean contains(T v);

	//adiciona uma aresta entre os vértices v1 e v2
	void addEdge(T v1, T v2);

	//retorna os v´ertices adjacentes a v
	Iterable<T> adjacents(T v);

	//retorna o grau do vertice v
	int degree(T v);
}
