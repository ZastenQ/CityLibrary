package by.htp.library.action;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;
import by.htp.library.entity.issues.Book;
import by.htp.library.entity.issues.Magazine;
import by.htp.library.entity.issues.Newspaper;
import by.htp.library.entity.issues.PrintedItem;
import by.htp.library.entity.librarytype.CityLibrary;
import by.htp.library.entity.librarytype.Library;

public class CityLibrarian implements Librarian {

	private PriorityQueue<CityLibrary> storage;

	public CityLibrarian() {
		storage = new PriorityQueue<CityLibrary>();
	}

	public PriorityQueue<CityLibrary> getStorage() {
		return storage;
	}

	@Override
	public void viewAll() {
		Iterator<CityLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			it.next().printInfo();
		}
	}

	public void addLibrary(CityLibrary newLibrary) {
		this.storage.add(newLibrary);
	}

	@Override
	public void addBook(Library libraryEntry, PrintedItem issue) {
		((CityLibrary) libraryEntry).getStorage().put(issue, 1);
	}

	public void addBook(Library libraryEntry, PrintedItem issue, Integer count) {
		((CityLibrary) libraryEntry).getStorage().put(issue, count);
	}

	@Override
	public void remove(String title) {
		Iterator<CityLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			Set<Entry<PrintedItem, Integer>> set = it.next().getStorage().entrySet();
			Iterator<Entry<PrintedItem, Integer>> it2 = set.iterator();
			while (it2.hasNext()) {
				Entry<PrintedItem, Integer> ent = it2.next();
				if (ent.getKey().getTitle().equalsIgnoreCase(title)) {
					it2.remove();
				}
			}
		}
	}

	@Override
	public void search(String title) {
		Iterator<CityLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			Set<Entry<PrintedItem, Integer>> set = it.next().getStorage().entrySet();
			Iterator<Entry<PrintedItem, Integer>> it2 = set.iterator();
			while (it2.hasNext()) {
				Entry<PrintedItem, Integer> ent = it2.next();
				if (ent.getKey().getTitle().equalsIgnoreCase(title)) {
					if (ent.getKey() instanceof Book) {
						((Book) ent.getKey()).printIssue();
					} else if (ent.getKey() instanceof Magazine) {
						((Magazine) ent.getKey()).printIssue();
					} else if (ent.getKey() instanceof Newspaper) {
						((Newspaper) ent.getKey()).printIssue();
					}
				}
			}
		}
	}

	@Override
	public void search(String authorName, String title) {
		Iterator<CityLibrary> it = this.storage.iterator();
		while (it.hasNext()) {
			Set<Entry<PrintedItem, Integer>> set = it.next().getStorage().entrySet();
			Iterator<Entry<PrintedItem, Integer>> it2 = set.iterator();
			while (it2.hasNext()) {
				Entry<PrintedItem, Integer> ent = it2.next();
				if (ent.getKey().getTitle().contains(title)
						&& ent.getKey().getItemAuthor().getName().contains(authorName)) {
					if (ent.getKey() instanceof Book) {
						((Book) ent.getKey()).printIssue();
					} else if (ent.getKey() instanceof Magazine) {
						((Magazine) ent.getKey()).printIssue();
					} else if (ent.getKey() instanceof Newspaper) {
						((Newspaper) ent.getKey()).printIssue();
					}
				}
			}
		}
	}

	@Override
	public void sort() {
		SortedSet<PrintedItem> treeSort = new TreeSet<PrintedItem>();
		Iterator<CityLibrary> it1 = this.storage.iterator();
		while (it1.hasNext()) {
			Set<Entry<PrintedItem, Integer>> set = it1.next().getStorage().entrySet();
			Iterator<Entry<PrintedItem, Integer>> it = set.iterator();
			while (it.hasNext()) {
				Entry<PrintedItem, Integer> ent = it.next();
				/*
				 * if (ent.getKey() instanceof Book) { ((Book)
				 * ent.getKey()).printIssue(); } else if (ent.getKey()
				 * instanceof Magazine) { ((Magazine)
				 * ent.getKey()).printIssue(); } else if (ent.getKey()
				 * instanceof Newspaper) { ((Newspaper)
				 * ent.getKey()).printIssue(); }
				 */
				treeSort.add(ent.getKey());
			}
		}
		for (PrintedItem issue : treeSort) {
			if (issue instanceof Book) {
				((Book) issue).printIssue();
			} else if (issue instanceof Magazine) {
				((Magazine) issue).printIssue();
			} else if (issue instanceof Newspaper) {
				((Newspaper) issue).printIssue();
			}
		}
	}

}
