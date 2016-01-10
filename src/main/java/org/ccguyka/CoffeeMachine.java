package org.ccguyka;

import org.ccguyka.nested.MissingIngrediantException;

public class CoffeeMachine {

	private String beans;
	private boolean hasWater;
	private Coffee coffee;

	public void addBeans(String beans) {
		this.beans = beans;
	}

	public void addWater() {
		hasWater = true;
	}

	public void brew() throws MissingIngrediantException {
		checkIngrediants();

		coffee = new Coffee();
	}

	private void checkIngrediants() throws MissingIngrediantException {
		if (!hasWater) {
			throw new MissingIngrediantException("Water");
		}

		if (beans == null) {
			throw new MissingIngrediantException("Beans");
		}
	}

	public Coffee getCoffee() {
		return coffee;
	}
}
