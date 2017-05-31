package by.htp.library.action;

import by.htp.library.entity.issues.PrintedItem;
import by.htp.library.entity.librarytype.Library;

public interface Librarian {

	default void viewAll() {

	}

	default void addBook(Library libraryEntry, PrintedItem issue) {

	}

	default void remove(String title) {

	}

	default void search(String title) {

	}

	default void search(String authorName, String title) {

	}

	default void sort() {

	}
}
