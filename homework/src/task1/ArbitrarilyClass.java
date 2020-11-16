package task1;

public class ArbitrarilyClass implements Comparable<ArbitrarilyClass> {

	private String string;
	private int integer;

	public ArbitrarilyClass(String string, int integer) {
		this.string = string;
		this.integer = integer;
	}

	public String getString() {
		return string;
	}

	public int getInteger() {
		return integer;
	}

	@Override
	public String toString() {
		return "ArbitrarilyClass [string=" + string + ", integer=" + integer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + integer;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
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
		ArbitrarilyClass other = (ArbitrarilyClass) obj;
		if (integer != other.integer)
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

	@Override
	public int compareTo(ArbitrarilyClass anotherString) {

		return this.string.compareTo(anotherString.getString());
	}

}
