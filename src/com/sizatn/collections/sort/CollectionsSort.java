package com.sizatn.collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {

	public static void main(String[] args) {
		
		List<Menu> list = new ArrayList<Menu>();
		
		Menu menu1 = new Menu();
		menu1.setMenuName("aaa");
		menu1.setMenuSort("0");
		
		Menu menu2 = new Menu();
		menu2.setMenuName("bbb");
		menu2.setMenuSort("3");
		
		Menu menu3 = new Menu();
		menu3.setMenuName("eee");
		menu3.setMenuSort("9");
		
		Menu menu4 = new Menu();
		menu4.setMenuName("hhh");
		menu4.setMenuSort("6");

		list.add(menu1);
		list.add(menu2);
		list.add(menu3);
		list.add(menu4);
		
		// asc(升序)
		list.sort((Menu o1, Menu o2) -> o1.getMenuSort().compareTo(o2.getMenuSort()));
		list.forEach((Menu o1) -> System.out.println(o1.toString()));
		
		System.out.println("");
		
		// desc(降序)
		list.sort((Menu o1, Menu o2) -> o2.getMenuSort().compareTo(o1.getMenuSort()));
		list.forEach(System.out::println);
		
//		Collections.sort(list, new Comparator<Menu>() {
//
//			@Override
//			public int compare(Menu o1, Menu o2) {
//				return o1.getMenuSort().compareTo(o2.getMenuSort());
//			}
//		});
		
	}

}
