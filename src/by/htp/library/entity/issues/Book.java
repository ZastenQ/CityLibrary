package by.htp.library.entity.issues;

import by.htp.library.entity.Author;

public class Book extends PrintedItem {
	private String genre;

	public Book(String title, String issueYear, Author itemAuthor, String publisher, String genre) {
		super(title, issueYear, itemAuthor, publisher);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void printIssue() {
		System.out.println("CITY: " + this.getTitle() + "; AUTHOR: " + this.getItemAuthor().getName() + "; YEAR: "
				+ this.getIssueYear() + ";");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		Book other = (Book) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		return true;
	}

	@Override
	public int compareTo(PrintedItem o) {
		int result = ((PrintedItem) this).getTitle().compareTo(o.getTitle());
		return result;
	}
}
