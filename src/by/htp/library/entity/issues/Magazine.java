package by.htp.library.entity.issues;

import by.htp.library.entity.Author;

public class Magazine extends PrintedItem {
	private int issueNumber;

	public Magazine(String title, String issueYear, Author itemAuthor, String publisher, int issueNumber) {
		super(title, issueYear, itemAuthor, publisher);
		this.issueNumber = issueNumber;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void printIssue() {
		System.out.println("CITY: " + this.getTitle() + "; AUTHOR: " + this.getItemAuthor().getName() + "; YEAR: "
				+ this.getIssueYear() + "; ISSUE #: " + this.getIssueNumber() + ";");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + issueNumber;
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
		Magazine other = (Magazine) obj;
		if (issueNumber != other.issueNumber)
			return false;
		return true;
	}

	@Override
	public int compareTo(PrintedItem o) {
		int result = ((PrintedItem) this).getTitle().compareTo(o.getTitle());
		return result;
	}
}
