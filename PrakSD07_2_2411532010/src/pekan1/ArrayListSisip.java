package pekan1;

import java.util.ArrayList;

public class ArrayListSisip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		// add the number
		list.add(1);
		list.add(2);
		list.add(4);
		System.out.println(list);
		//insert missing element 3
		list.add(2, 3);
		System.out.println(list
				);
	}

}
