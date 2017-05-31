package by.htp.library.entity.issues;

import by.htp.library.entity.Author;

public class ScientificPublication extends PrintedItem {
	private String scienceField;

	public ScientificPublication(String title, String issueYear, Author itemAuthor, String publisher,
			String scienceField) {
		super(title, issueYear, itemAuthor, publisher);
		this.scienceField = scienceField;
	}

	public String getScienceField() {
		return scienceField;
	}

	public void printIssue() {
		System.out.println("SCIENCE: " + this.getTitle() + "; AUTHOR: " + this.getItemAuthor().getName() + "; YEAR: "
				+ this.getIssueYear() + ";");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((scienceField == null) ? 0 : scienceField.hashCode());
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
		ScientificPublication other = (ScientificPublication) obj;
		if (scienceField == null) {
			if (other.scienceField != null)
				return false;
		} else if (!scienceField.equals(other.scienceField))
			return false;
		return true;
	}

	@Override
	public int compareTo(PrintedItem o) {
		int result = this.getTitle().compareTo(((ScientificPublication) o).getTitle());
		return result;
	}
}
