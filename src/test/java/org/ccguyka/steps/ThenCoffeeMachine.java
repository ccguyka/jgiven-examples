package org.ccguyka.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.ccguyka.CoffeeMachine;
import org.ccguyka.nested.MissingIngrediantException;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class ThenCoffeeMachine extends Stage<ThenCoffeeMachine> {

    @ProvidedScenarioState
    CoffeeMachine coffeeMachine;

    @ProvidedScenarioState
    MissingIngrediantException missingIngrediantException;

    public ThenCoffeeMachine the_coffee_tastes_good() {
        assertThat(coffeeMachine.getCoffee()).isNotNull();
        return self();
    }

    public ThenCoffeeMachine some_ingrediant_is_missing(String ingrediant) {
        assertThat(missingIngrediantException.getMissingIngrediant()).isEqualTo(ingrediant);
        return self();
    }
}