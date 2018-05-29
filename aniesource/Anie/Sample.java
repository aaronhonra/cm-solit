package Anie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.org.apache.xpath.internal.FoundIndex;


public class Sample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//String st = "*******";
//		for (int z=0; z<st.length(); z++) {
//			System.out.println(st);
//			st.replace(z, " ");
//		}
		//System.out.println("sample");
		for (int x=0; x<8; x++) {
			list.add("*");
		}
		System.out.println();
		//System.out.println("list: " + list);
		for (int y=7, z=0; y>0; y--, z++) {
			for (int j=7, i=z; j>0; j--, i--) {
				if(i > 0) {
					System.out.print(" ");					
				}else {
					System.out.print("*");					
				}
			}
			System.out.println();
//			if (y == 0) {
//				System.out.println(list);
//			}
//			list.remove(y);
//			//list.replaceAll(operator);
//			
//			System.out.println(list);
			
		}
			
			
	}

}
