

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {
		// 배열 활용 로또번호
		int[] abc = new int[6];
		
		for (int i = 0; i < abc.length; i++) {
			abc[i]=(int)(Math.random()*45)+1;
			for (int j = 0; j < i; j++) {
				if(abc[i]==abc[j]) {
					i--;
					break;
				}
			}
		}
		System.out.print("배열 로또 번호 : ");
		Arrays.sort(abc);
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]+" ");
		}
		
		//--------------------------------------------
		System.out.println();

		// HashSet 활용 로또번호
		System.out.print("HashSet 로또 번호 : ");
		Set lotto2 = new HashSet();
		while(!(lotto2.size()==6)){
			lotto2.add((int)(Math.random()*45)+1);
		}

		ArrayList a = new ArrayList(lotto2);
		Collections.sort(a);

		Iterator ab = a.iterator();
		while(ab.hasNext()) {
			System.out.print(ab.next()+" ");
		}
	}
}


