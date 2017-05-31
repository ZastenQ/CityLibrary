package by.htp.library;

import by.htp.library.action.ChildrenLibrarian;
import by.htp.library.action.CityLibrarian;
import by.htp.library.action.ScientificLibrarian;
import by.htp.library.entity.Author;
import by.htp.library.entity.City;
import by.htp.library.entity.issues.Book;
import by.htp.library.entity.issues.ChildrenBook;
import by.htp.library.entity.issues.Magazine;
import by.htp.library.entity.issues.Newspaper;
import by.htp.library.entity.issues.ScientificPublication;
import by.htp.library.entity.librarytype.ChildrenLibrary;
import by.htp.library.entity.librarytype.CityLibrary;
import by.htp.library.entity.librarytype.ScientificLibrary;

public class Main {

	public static void main(String[] args) {

		// creating city libraries
		ChildrenLibrary childLib1 = new ChildrenLibrary("NY, 1-str 15", "City Children Library #1");
		ChildrenLibrary childLib2 = new ChildrenLibrary("NY, 67-str 34", "City Children Library #2");
		ScientificLibrary scienceLib1 = new ScientificLibrary("NY, 23-str 3", "City Science Library #1");
		ScientificLibrary scienceLib2 = new ScientificLibrary("NY, 2-str 86", "City Science Library #2");
		CityLibrary cityLib1 = new CityLibrary("NY, 45-str 345", "City Library #1");
		CityLibrary cityLib2 = new CityLibrary("NY, 18-str 1", "City Library #2");

		// creating librarians
		ChildrenLibrarian childLibrarian = new ChildrenLibrarian();
		childLibrarian.addLibrary(childLib1);
		childLibrarian.addLibrary(childLib2);

		ScientificLibrarian scienceLibrarian = new ScientificLibrarian();
		scienceLibrarian.addLibrary(scienceLib1);
		scienceLibrarian.addLibrary(scienceLib2);

		CityLibrarian cityLibrarian = new CityLibrarian();
		cityLibrarian.addLibrary(cityLib1);
		cityLibrarian.addLibrary(cityLib2);

		// adding children books
		childLibrarian.addBook(childLib1,
				new ChildrenBook("Children book #12", "2000", new Author("Author A", "1956"), "Publisher #1", "G5"));
		childLibrarian.addBook(childLib1,
				new ChildrenBook("Children book #24", "2009", new Author("Author B", "1945"), "Publisher #2", "G8"));
		childLibrarian.addBook(childLib1,
				new ChildrenBook("Children book #3", "2005", new Author("Author C", "1974"), "Publisher #2", "G2"));
		childLibrarian.addBook(childLib2,
				new ChildrenBook("Children book #14", "2003", new Author("Author A", "1956"), "Publisher #2", "G13"));
		childLibrarian.addBook(childLib2,
				new ChildrenBook("Children book #5", "2002", new Author("Author B", "1945"), "Publisher #3", "G12"));
		childLibrarian.addBook(childLib2,
				new ChildrenBook("Children book #36", "2014", new Author("Author C", "1974"), "Publisher #3", "G13"));
		childLibrarian.addBook(childLib2,
				new ChildrenBook("Children book #17", "2014", new Author("Author C", "1974"), "Publisher #3", "G13"));

		// viewing all children books catalogue
		childLibrarian.viewAll();

		// adding scientific publications
		scienceLibrarian.addBook(scienceLib1, new ScientificPublication("Physics of bla-bla", "2005",
				new Author("David Lynch", "1984"), "N/A", "Physics"));
		scienceLibrarian.addBook(scienceLib1, new ScientificPublication("Physics of stupid things", "2006",
				new Author("Stewart Davidson", "1987"), "N/A", "Physics"));
		scienceLibrarian.addBook(scienceLib1, new ScientificPublication("Biology of bla-bla", "2009",
				new Author("Angela Davis", "1965"), "N/A", "Biology"));
		scienceLibrarian.addBook(scienceLib1, new ScientificPublication("Biology of stupids", "2001",
				new Author("Mylo Johnson", "1979"), "N/A", "Biology"));
		scienceLibrarian.addBook(scienceLib1, new ScientificPublication("Chemistry of bla-bla", "2011",
				new Author("John Davis", "1990"), "N/A", "Chemistry"));
		scienceLibrarian.addBook(scienceLib2, new ScientificPublication("Physics of bla-bla v2.0", "2007",
				new Author("David Lynch", "1984"), "N/A", "Physics"));
		scienceLibrarian.addBook(scienceLib2, new ScientificPublication("Physics of stupid things v2.0", "2008",
				new Author("Stewart Davidson", "1987"), "N/A", "Physics"));
		scienceLibrarian.addBook(scienceLib2, new ScientificPublication("Biology of bla-bla v2.0", "2011",
				new Author("Angela Davis", "1965"), "N/A", "Biology"));
		scienceLibrarian.addBook(scienceLib2, new ScientificPublication("Biology of stupids v2.0", "2003",
				new Author("Mylo Johnson", "1979"), "N/A", "Biology"));
		scienceLibrarian.addBook(scienceLib2, new ScientificPublication("Chemistry of bla-bla v2.0", "2015",
				new Author("John Davis", "1990"), "N/A", "Chemistry"));
		scienceLibrarian.addBook(scienceLib2, new ScientificPublication("Chemistry of bla-bla v1.5", "2012",
				new Author("John Davis", "1990"), "N/A", "Chemistry"));

		// viewing all scientific publication
		scienceLibrarian.viewAll();

		// adding magazines, newspapers, books
		cityLibrarian.addBook(cityLib1,
				new Magazine("Vogue", "2016", new Author("Vogue (c)", "2000"), "VoguePublisher", 1), 5);
		cityLibrarian.addBook(cityLib1,
				new Magazine("Vogue", "2015", new Author("Vogue (c)", "2000"), "VoguePublisher", 2), 3);
		cityLibrarian.addBook(cityLib1,
				new Book("StarWars", "2012", new Author("John Douglas", "1972"), "SciFiPublisher", "SciFi"), 10);
		cityLibrarian.addBook(cityLib1,
				new Newspaper("Daily Mirror", "2016", new Author("Daily & Co", "1990"), "NewsPublisher", "25/2016"), 4);
		cityLibrarian.addBook(cityLib1,
				new Newspaper("Daily Mirror", "2016", new Author("Daily & Co", "1990"), "NewsPublisher", "78/2016"), 3);
		cityLibrarian.addBook(cityLib2,
				new Magazine("Vogue", "2015", new Author("Vogue (c)", "2000"), "VoguePublisher", 1), 2);
		cityLibrarian.addBook(cityLib2,
				new Magazine("Vogue", "2015", new Author("Vogue (c)", "2000"), "VoguePublisher", 2), 1);
		cityLibrarian.addBook(cityLib2,
				new Book("StarWars", "2012", new Author("John Douglas", "1972"), "SciFiPublisher", "SciFi"), 8);
		cityLibrarian.addBook(cityLib2,
				new Newspaper("Daily Mirror", "2016", new Author("Daily & Co", "1990"), "NewsPublisher", "25/2016"), 1);
		cityLibrarian.addBook(cityLib2,
				new Newspaper("Daily Mirror", "2016", new Author("Daily & Co", "1990"), "NewsPublisher", "78/2016"), 1);
		cityLibrarian.addBook(cityLib2,
				new Book("StarWars2", "2012", new Author("John Douglas", "1972"), "SciFiPublisher", "SciFi"), 8);

		// viewing all issues
		cityLibrarian.viewAll();

		// removing issues
		childLibrarian.remove("Children book #17");
		scienceLibrarian.remove("Chemistry of bla-bla v1.5");
		cityLibrarian.remove("StarWars2");

		// searching...
		childLibrarian.search("book #17");
		// childLibrarian.search("Author A", "book #4");
		// scienceLibrarian.search("Physics of bla-bla");
		// scienceLibrarian.search("Mylo Johnson", "Biology");
		// cityLibrarian.search("Starwars");
		// cityLibrarian.search("Daily", "Mirror");

		// sorting libraries
		childLibrarian.sort();
		scienceLibrarian.sort();
		cityLibrarian.sort();

		// creating City and adding libraries to the City
		City cityMinsk = new City();
		cityMinsk.add(childLib1);
		cityMinsk.add(childLib2);
		cityMinsk.add(scienceLib1);
		cityMinsk.add(scienceLib2);
		cityMinsk.add(cityLib1);
		cityMinsk.add(cityLib2);

		// viewing all libraries and catalogue from City
		cityMinsk.viewLibraries();
		cityMinsk.view("City Children Library #1");
	}

}
