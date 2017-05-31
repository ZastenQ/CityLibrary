package by.htp.library.action;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import by.htp.library.entity.issues.PrintedItem;
import by.htp.library.entity.issues.ScientificPublication;
import by.htp.library.entity.librarytype.Library;
import by.htp.library.entity.librarytype.ScientificLibrary;

public class ScientificLibrarian implements Librarian {

	private TreeSet<ScientificLibrary> storage;

	public ScientificLibrarian() {
		storage = new TreeSet<ScientificLibrary>();
	}

	public TreeSet<ScientificLibrary> getStorage() {
		return storage;
	}

	@Override
	public void viewAll() {
		Iterator<ScientificLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			it.next().printInfo();
		}
	}

	public void addLibrary(ScientificLibrary newLibrary) {
		this.storage.add(newLibrary);
	}

	@Override
	public void addBook(Library libraryEntry, PrintedItem issue) {
		((ScientificLibrary) libraryEntry).getStorage().add((ScientificPublication) issue);
	}

	@Override
	public void remove(String title) {
		Iterator<ScientificLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			Iterator<ScientificPublication> it2 = it.next().getStorage().iterator();
			while (it2.hasNext()) {
				ScientificPublication sp = it2.next();
				if (sp.getTitle().equalsIgnoreCase(title)) {
					it2.remove();
				}
			}
		}
	}

	@Override
	public void search(String title) {
		Iterator<ScientificLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			Iterator<ScientificPublication> it2 = it.next().getStorage().iterator();
			while (it2.hasNext()) {
				ScientificPublication sp = it2.next();
				if (sp.getTitle().equalsIgnoreCase(title)) {
					sp.printIssue();
				}
			}
		}
	}

	@Override
	public void search(String authorName, String title) {
		Iterator<ScientificLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			Iterator<ScientificPublication> it2 = it.next().getStorage().iterator();
			while (it2.hasNext()) {
				ScientificPublication sp = it2.next();
				if (sp.getTitle().contains(title) && sp.getItemAuthor().getName().contains(authorName)) {
					sp.printIssue();
				}
			}
		}
	}

	@Override
	public void sort() {
		SortedSet<ScientificPublication> treeSort = new TreeSet<ScientificPublication>();
		Iterator<ScientificLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			treeSort.addAll(it.next().getStorage());
		}
		for (ScientificPublication issue : treeSort) {
			issue.printIssue();
		}
	}

}
