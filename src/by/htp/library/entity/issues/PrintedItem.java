package by.htp.library.entity.issues;

import by.htp.library.entity.Author;

public abstract class PrintedItem implements Comparable<PrintedItem> {
	private String title;
	private String issueYear;
	private Author itemAuthor;
	private String publisher;

	public PrintedItem(String title, String issueYear, Author itemAuthor, String publisher) {
		this.title = title;
		this.issueYear = issueYear;
		this.itemAuthor = itemAuthor;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public String getIssueYear() {
		return issueYear;
	}

	public Author getItemAuthor() {
		return itemAuthor;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueYear == null) ? 0 : issueYear.hashCode());
		result = prime * result + ((itemAuthor == null) ? 0 : itemAuthor.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		PrintedItem other = (PrintedItem) obj;
		if (issueYear == null) {
			if (other.issueYear != null)
				return false;
		} else if (!issueYear.equals(other.issueYear))
			return false;
		if (itemAuthor == null) {
			if (other.itemAuthor != null)
				return false;
		} else if (!itemAuthor.equals(other.itemAuthor))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
