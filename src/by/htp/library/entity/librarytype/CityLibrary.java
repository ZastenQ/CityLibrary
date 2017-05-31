package by.htp.library.entity.librarytype;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import by.htp.library.entity.issues.Book;
import by.htp.library.entity.issues.Magazine;
import by.htp.library.entity.issues.Newspaper;
import by.htp.library.entity.issues.PrintedItem;

public class CityLibrary extends Library implements Comparable<Library> {

	private HashMap<PrintedItem, Integer> storage;
	private static final LibraryType libraryType = LibraryType.CITY;

	public CityLibrary(String address, String name) {
		super(address, name);
		this.storage = new HashMap<PrintedItem, Integer>();
	}

	public HashMap<PrintedItem, Integer> getStorage() {
		return storage;
	}

	public static LibraryType getLibrarytype() {
		return libraryType;
	}

	public void printLibrary() {
		System.out.println("CITY: " + this.getName() + "; ADDRESS: " + this.getAddress() + ";");
	}

	public void printInfo() {
		System.out.println(this.getName());
		Set<Entry<PrintedItem, Integer>> set = this.storage.entrySet();
		Iterator<Entry<PrintedItem, Integer>> it = set.iterator();
		while (it.hasNext()) {
			Entry<PrintedItem, Integer> ent = it.next();
			if (ent.getKey() instanceof Book) {
				((Book) ent.getKey()).printIssue();
			} else if (ent.getKey() instanceof Magazine) {
				((Magazine) ent.getKey()).printIssue();
			} else if (ent.getKey() instanceof Newspaper) {
				((Newspaper) ent.getKey()).printIssue();
			}
		}
	}

	@Override
	public int compareTo(Library o) {
		int result = this.getName().compareToIgnoreCase(((CityLibrary) o).getName());
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityLibrary other = (CityLibrary) obj;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}

}
