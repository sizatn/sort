package com.sizatn.collections.sort;

public class Menu {

	private String menuName;
	private String menuSort;

	public Menu() {
		super();
	}

	public Menu(String menuName, String menuSort) {
		super();
		this.menuName = menuName;
		this.menuSort = menuSort;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort;
	}

	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", menuSort=" + menuSort + "]";
	}

}
