package by.htp.library.entity.librarytype;

import java.util.LinkedList;

import by.htp.library.entity.issues.ChildrenBook;

public class ChildrenLibrary extends Library {

	private LinkedList<ChildrenBook> storage;
	private static final LibraryType libraryType = LibraryType.CHILD;

	public ChildrenLibrary(String address, String name) {
		super(address, name);
		this.storage = new LinkedList<ChildrenBook>();
	}

	public LinkedList<ChildrenBook> getStorage() {
		return storage;
	}

	public static LibraryType getLibrarytype() {
		return libraryType;
	}

	public void printLibrary() {
		System.out.println("CHILD: " + this.getName() + "; ADDRESS: " + this.getAddress() + ";");
	}

	public void printInfo() {
		for (int i = 0; i < this.storage.size(); i++) {
			this.storage.get(i).printIssue();
		}
	}

	@Override
	public int compareTo(Library o) {
		int result = this.getName().compareTo(((ChildrenLibrary) o).getName());
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
		ChildrenLibrary other = (ChildrenLibrary) obj;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}

}
