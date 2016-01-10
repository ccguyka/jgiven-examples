package org.ccguyka.steps;

import org.ccguyka.CoffeeMachine;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenCoffeeMachine extends Stage<GivenCoffeeMachine> {

    @ProvidedScenarioState
    CoffeeMachine coffeeMachine;

    public GivenCoffeeMachine have_a_coffee_machine() {
        coffeeMachine = new CoffeeMachine();
        return self();
    }

    public GivenCoffeeMachine add_coffee_beans(String beans) {
        coffeeMachine.addBeans(beans);
        return self();
    }

    public GivenCoffeeMachine add_hot_water() {
        coffeeMachine.addWater();
        return self();
    }
}
