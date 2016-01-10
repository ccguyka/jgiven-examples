package org.ccguyka.nested;

public class MissingIngrediantException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String ingrediant;

	public MissingIngrediantException(String ingrediant) {
		this.ingrediant = ingrediant;
	}

	public String getMissingIngrediant() {
		return ingrediant;
	}
}
