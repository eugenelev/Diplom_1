import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;


public class IngredientTypeTest {

    @Test
    public void checkThatIngredientTypeContainsSauceAndFilling() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

}
