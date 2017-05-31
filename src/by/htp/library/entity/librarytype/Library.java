package by.htp.library.entity.librarytype;

public abstract class Library implements Comparable<Library> {
	private String address;
	private String name;
	private LibraryType libraryType;

	public Library(String address, String name) {
		this.address = address;
		this.name = name;
		this.libraryType = LibraryType.CHILD;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public LibraryType getLibraryType() {
		return libraryType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((libraryType == null) ? 0 : libraryType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (libraryType != other.libraryType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
