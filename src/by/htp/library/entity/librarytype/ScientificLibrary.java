package by.htp.library.entity.librarytype;

import java.util.HashSet;
import java.util.Iterator;

import by.htp.library.entity.issues.ScientificPublication;

public class ScientificLibrary extends Library implements Comparable<Library> {

	private HashSet<ScientificPublication> storage;
	private static final LibraryType libraryType = LibraryType.SCIENCE;

	public ScientificLibrary(String address, String name) {
		super(address, name);
		this.storage = new HashSet<ScientificPublication>();
	}

	public HashSet<ScientificPublication> getStorage() {
		return storage;
	}

	public static LibraryType getLibrarytype() {
		return libraryType;
	}

	public void printLibrary() {
		System.out.println("SCIENCE: " + this.getName() + "; ADDRESS: " + this.getAddress() + ";");
	}

	public void printInfo() {
		System.out.println(this.getName());
		Iterator<ScientificPublication> it = this.storage.iterator();
		while (it.hasNext()) {
			it.next().printIssue();
		}
	}

	@Override
	public int compareTo(Library o) {
		int result = this.getName().compareToIgnoreCase(((ScientificLibrary) o).getName());
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
		ScientificLibrary other = (ScientificLibrary) obj;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}

}
