package br.ufc.carteus.test;

import br.ufc.carteus.st.LeftistHeap;

public class LeftistHeapMain {

	public static void main(String[] args) {

		LeftistHeap<Integer> hp = new LeftistHeap<Integer>();
		
		hp.insert(1);
		hp.insert(2);
		hp.insert(3);
		hp.insert(4);
		hp.insert(5);
		hp.insert(6);
		hp.insert(7);
		hp.teste();
		System.out.println();
		hp.deleteMin();
		
		
		hp.teste();

		
		
		
	}

}
