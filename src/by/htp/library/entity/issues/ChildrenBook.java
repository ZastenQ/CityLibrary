package by.htp.library.entity.issues;

import by.htp.library.entity.Author;

public class ChildrenBook extends PrintedItem {
	private String ageRating;

	public ChildrenBook(String title, String issueYear, Author itemAuthor, String publisher, String ageRating) {
		super(title, issueYear, itemAuthor, publisher);
		this.ageRating = ageRating;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void printIssue() {
		System.out.println("CHILD: " + this.getTitle() + "; AUTHOR: " + this.getItemAuthor().getName() + "; YEAR: "
				+ this.getIssueYear() + ";");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ageRating == null) ? 0 : ageRating.hashCode());
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
		ChildrenBook other = (ChildrenBook) obj;
		if (ageRating == null) {
			if (other.ageRating != null)
				return false;
		} else if (!ageRating.equals(other.ageRating))
			return false;
		return true;
	}

	@Override
	public int compareTo(PrintedItem o) {
		int result = this.getTitle().compareTo(((ChildrenBook) o).getTitle());
		return result;
	}
}
