package org.ccguyka;

import org.ccguyka.steps.GivenCoffeeMachine;
import org.ccguyka.steps.ThenCoffeeMachine;
import org.ccguyka.steps.WhenCoffeeMachine;
import org.junit.Test;

import com.tngtech.jgiven.junit.ScenarioTest;

public class CoffeMachineTest extends ScenarioTest<GivenCoffeeMachine, WhenCoffeeMachine, ThenCoffeeMachine> {

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
        given().have_a_coffee_machine().and().add_hot_water();

        when().i_brew_coffee();

        then().some_ingrediant_is_missing("Beans");
    }
}
