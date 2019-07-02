package br.ufc.carteus.st;

public interface Graph<T> {

	//retorna o n�umero de v�ertices do grafo
	int countVertices();
	
	//retorna o n�umero de arestas do grafo
	int countEdges();
	
	//retorna o indice do vertice v, que indica, na sequencias de
	//insercoes, a posi��o de inserc�o do v�rtice
	int index(T v);

	//retorna o r�tulo do v�rtice cujo �ndice � index
	T label(int index);

	//v�rifica se existe v�rtice com r�tulo v
	boolean contains(T v);

	//adiciona uma aresta entre os v�rtices v1 e v2
	void addEdge(T v1, T v2);

	//retorna os v�ertices adjacentes a v
	Iterable<T> adjacents(T v);

	//retorna o grau do vertice v
	int degree(T v);
}
