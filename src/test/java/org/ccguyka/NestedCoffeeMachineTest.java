package org.ccguyka;

import static org.assertj.core.api.Assertions.assertThat;

import org.ccguyka.nested.MissingIngrediantException;
import org.junit.Test;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.SimpleScenarioTest;

public class NestedCoffeeMachineTest extends SimpleScenarioTest<NestedCoffeeMachineTest.NestedStage> {

    @Test
    public void brew_coffee() throws Exception {
        given().have_a_coffee_machine()
            .and().add_coffee_beans("Nicaragua")
            .and().add_hot_water();

        when().i_brew_coffee();

        then().the_coffee_tastes_good();
    }

    @Test
    public void brew_coffee_without_water() throws Exception {
        given().have_a_coffee_machine()
            .and().add_coffee_beans("Nicaragua");

        when().i_brew_coffee();

        then().some_ingrediant_is_missing("Water");
    }

    @Test
    public void brew_coffee_without_beans() throws Exception {
        given().have_a_coffee_machine()
            .and().add_hot_water();

        when().i_brew_coffee();

        then().some_ingrediant_is_missing("Beans");
    }

    static class NestedStage extends Stage<NestedStage> {

        @ProvidedScenarioState
        CoffeeMachine coffeeMachine;

        @ProvidedScenarioState
        MissingIngrediantException missingIngrediantException;

        public Stage<NestedStage> have_a_coffee_machine() {
            coffeeMachine = new CoffeeMachine();
            return self();
        }

        public NestedStage add_coffee_beans(String beans) {
            coffeeMachine.addBeans(beans);
            return self();
        }

        public NestedStage add_hot_water() {
            coffeeMachine.addWater();
            return self();
        }

        public NestedStage i_brew_coffee() throws Exception {
            try {
                coffeeMachine.brew();
            } catch (MissingIngrediantException e) {
                missingIngrediantException = e;
            }

            return self();
        }

        public NestedStage the_coffee_tastes_good() {
            assertThat(coffeeMachine.getCoffee()).isNotNull();
            return self();

        }

        public NestedStage some_ingrediant_is_missing(String ingrediant) {
            assertThat(missingIngrediantException.getMissingIngrediant()).isEqualTo(ingrediant);
            return self();
        }
    }
}
