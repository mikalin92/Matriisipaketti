package main;

import matriisipaketti.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pieni testi
		Matriisi m=new Matriisi(3,3);
		m.asetaArvo(0, 0, 1);
		m.asetaArvo(1, 0, 4);
		m.asetaArvo(2, 0, 7);
		m.asetaArvo(0, 1, 2);
		m.asetaArvo(1, 1, 5);
		m.asetaArvo(2, 1, 8);
		m.asetaArvo(0, 2, 3);
		m.asetaArvo(1, 2, 6);
		m.asetaArvo(2, 2, 10);//10, ei 9. 9 aiheuttaa singulaarisuuden.
		m.inverssi().tulosta();
		
		System.out.println("------------");
		
		m.tulosta();

		System.out.println("------------");
		m.lis‰‰Matriisilla(m).tulosta();;
		
		
		
	}

}
