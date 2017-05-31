package by.htp.library.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import by.htp.library.entity.librarytype.ChildrenLibrary;
import by.htp.library.entity.librarytype.CityLibrary;
import by.htp.library.entity.librarytype.Library;
import by.htp.library.entity.librarytype.LibraryType;
import by.htp.library.entity.librarytype.ScientificLibrary;

public class City {
	private Map<LibraryType, ArrayList<Library>> storage;
	private ArrayList<Library> childStorage;
	private ArrayList<Library> scienceStorage;
	private ArrayList<Library> cityStorage;

	public City() {
		this.storage = new HashMap<LibraryType, ArrayList<Library>>();
		this.childStorage = new ArrayList<Library>();
		this.scienceStorage = new ArrayList<Library>();
		this.cityStorage = new ArrayList<Library>();
	}

	public Map<LibraryType, ArrayList<Library>> getStorage() {
		return storage;
	}

	public void add(Library newLibrary) {
		if (newLibrary instanceof ChildrenLibrary) {
			ChildrenLibrary newChild = (ChildrenLibrary) newLibrary;
			if (this.childStorage == null) {
				this.childStorage.add(newChild);
			} else {
				this.childStorage.add(newChild);
			}
		} else if (newLibrary instanceof ScientificLibrary) {
			ScientificLibrary newScience = (ScientificLibrary) newLibrary;
			if (this.scienceStorage == null) {
				this.scienceStorage.add(newScience);
			} else {
				this.scienceStorage.add(newScience);
			}
		} else if (newLibrary instanceof CityLibrary) {
			CityLibrary newCity = (CityLibrary) newLibrary;
			if (this.cityStorage == null) {
				this.cityStorage.add(newCity);
			} else {
				this.cityStorage.add(newCity);
			}
		}
		if (this.childStorage != null) {
			this.storage.put(LibraryType.CHILD, childStorage);
		}
		if (this.scienceStorage != null) {
			this.storage.put(LibraryType.SCIENCE, scienceStorage);
		}
		if (this.cityStorage != null) {
			this.storage.put(LibraryType.CITY, cityStorage);
		}
	}

	public void viewLibraries() {
		Set<Entry<LibraryType, ArrayList<Library>>> set = this.storage.entrySet();
		Iterator<Entry<LibraryType, ArrayList<Library>>> it = set.iterator();
		while (it.hasNext()) {
			Entry<LibraryType, ArrayList<Library>> ent = it.next();
			if (ent.getKey() == LibraryType.CHILD) {
				for (int i = 0; i < ent.getValue().size(); i++) {
					((ChildrenLibrary) ent.getValue().get(i)).printLibrary();
				}
			} else if (ent.getKey() == LibraryType.SCIENCE) {
				for (int i = 0; i < ent.getValue().size(); i++) {
					((ScientificLibrary) ent.getValue().get(i)).printLibrary();
				}
			} else if (ent.getKey() == LibraryType.CITY) {
				for (int i = 0; i < ent.getValue().size(); i++) {
					((CityLibrary) ent.getValue().get(i)).printLibrary();
				}
			}
		}
	}

	public void view(String libraryName) {
		ArrayList<Library> temp = new ArrayList<Library>();
		temp.addAll(childStorage);
		temp.addAll(scienceStorage);
		temp.addAll(cityStorage);
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getName().equalsIgnoreCase(libraryName)) {
				if (temp.get(i).getLibraryType() == LibraryType.CHILD) {
					((ChildrenLibrary) temp.get(i)).printInfo();
				} else if (temp.get(i).getLibraryType() == LibraryType.SCIENCE) {
					((ScientificLibrary) temp.get(i)).printInfo();
				} else if (temp.get(i).getLibraryType() == LibraryType.CITY) {
					((CityLibrary) temp.get(i)).printInfo();
				}
			}
		}
	}
}
