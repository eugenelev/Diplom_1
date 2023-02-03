import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {
    public Ingredient ingredient;
    public IngredientType type;

    public IngredientGetTypeTest(Ingredient ingredient, IngredientType expectedType) {
        this.ingredient = ingredient;
        this.type = expectedType;
    }

    @Parameterized.Parameters
    public static Collection ingredients() {
        return Arrays.asList(new Object[][] {
                { new Ingredient(IngredientType.SAUCE, "sour cream", 100), SAUCE},
                { new Ingredient(IngredientType.FILLING, "sour cream", 100), FILLING}
        });
    }

    @Test
    public void getTypeReturnsRightType(){
        Ingredient new_ingredient = ingredient;
        IngredientType expectedType = type;

        IngredientType actual = new_ingredient.getType();

        assertEquals(expectedType, actual);

    }


}
