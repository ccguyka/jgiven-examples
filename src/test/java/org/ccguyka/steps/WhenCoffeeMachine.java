package org.ccguyka.steps;

import org.ccguyka.CoffeeMachine;
import org.ccguyka.nested.MissingIngrediantException;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class WhenCoffeeMachine extends Stage<WhenCoffeeMachine> {

    @ProvidedScenarioState
    CoffeeMachine coffeeMachine;

    @ProvidedScenarioState
    MissingIngrediantException missingIngrediantException;

    public WhenCoffeeMachine i_brew_coffee() throws Exception {
        try {
            coffeeMachine.brew();
        } catch (MissingIngrediantException e) {
            missingIngrediantException = e;
        }

        return self();
    }
}
