package by.htp.library.action;

import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import by.htp.library.entity.issues.ChildrenBook;
import by.htp.library.entity.issues.PrintedItem;
import by.htp.library.entity.librarytype.ChildrenLibrary;
import by.htp.library.entity.librarytype.Library;

public class ChildrenLibrarian implements Librarian {

	private LinkedHashSet<ChildrenLibrary> storage;

	public ChildrenLibrarian() {
		storage = new LinkedHashSet<ChildrenLibrary>();
	}

	public LinkedHashSet<ChildrenLibrary> getStorage() {
		return storage;
	}

	@Override
	public void viewAll() {
		for (ChildrenLibrary lib : this.storage) {
			System.out.println(lib.getName());
			lib.printInfo();
		}
	}

	public void addLibrary(ChildrenLibrary newLibrary) {
		this.storage.add(newLibrary);
	}

	@Override
	public void addBook(Library libraryEntry, PrintedItem issue) {
		((ChildrenLibrary) libraryEntry).getStorage().add((ChildrenBook) issue);
	}

	@Override
	public void remove(String title) {
		for (ChildrenLibrary lib : this.storage) {
			for (int i = 0; i < lib.getStorage().size(); i++) {
				if (lib.getStorage().get(i).getTitle().equalsIgnoreCase(title)) {
					lib.getStorage().remove(i);
				}
			}
			lib.getStorage().remove(title);
		}
	}

	@Override
	public void search(String title) {
		for (ChildrenLibrary lib : this.storage) {
			for (int i = 0; i < lib.getStorage().size(); i++) {
				if (lib.getStorage().get(i).getTitle().contains(title)) {
					lib.getStorage().get(i).printIssue();
				}
			}
		}
	}

	@Override
	public void search(String authorName, String title) {
		for (ChildrenLibrary lib : this.storage) {
			for (int i = 0; i < lib.getStorage().size(); i++) {
				if (lib.getStorage().get(i).getTitle().contains(title)
						&& lib.getStorage().get(i).getItemAuthor().getName().contains(authorName)) {
					lib.getStorage().get(i).printIssue();
				}
			}
		}
	}

	@Override
	public void sort() {
		SortedSet<ChildrenBook> treeSort = new TreeSet<ChildrenBook>();
		for (ChildrenLibrary lib : this.storage) {
			treeSort.addAll(lib.getStorage());
		}
		for (ChildrenBook issue : treeSort) {
			issue.printIssue();
		}
	}

}
