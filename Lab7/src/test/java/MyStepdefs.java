import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {

    product pr = new product();

    double inputA;
    double inputB;
    double quotient;
    boolean excptornot = false;

    @Given("two double")
    public void input(){
        inputA = 8.1;
        inputB = 0.9;
    }


    @When("I ask their quotient$")
    public void ask(){
        try {
            quotient = pr.divide(inputA, inputB);
        }
        catch(IllegalArgumentException excep){
            excptornot = true;
        }

    }

    @Then("I should be told 9")
    public void be_told(){
        assertEquals(9,quotient);
    }

    @Given("two double inputB = zero")
    public void twoDoubleAnd() {
        inputA = 8.1;
        inputB = 0.0;
    }

    @Then("throw exception")
    public void throwException() {
        assertTrue(excptornot);
//        System.out.println("bbb"+exception+"bbb");
    }
}

