package by.htp.library.entity.issues;

import by.htp.library.entity.Author;

public class Newspaper extends PrintedItem {
	private String issueCode;

	public Newspaper(String title, String issueYear, Author itemAuthor, String publisher, String issueCode) {
		super(title, issueYear, itemAuthor, publisher);
		this.issueCode = issueCode;
	}

	public String getIssueCode() {
		return issueCode;
	}

	public void printIssue() {
		System.out.println("CITY: " + this.getTitle() + "; AUTHOR: " + this.getItemAuthor().getName() + "; YEAR: "
				+ this.getIssueYear() + "; ISSUE CODE #: " + this.getIssueCode() + ";");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((issueCode == null) ? 0 : issueCode.hashCode());
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
		Newspaper other = (Newspaper) obj;
		if (issueCode == null) {
			if (other.issueCode != null)
				return false;
		} else if (!issueCode.equals(other.issueCode))
			return false;
		return true;
	}

	@Override
	public int compareTo(PrintedItem o) {
		int result = ((PrintedItem) this).getTitle().compareTo(o.getTitle());
		return result;
	}
}
