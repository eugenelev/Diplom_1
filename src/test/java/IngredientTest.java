import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {


    @Test
    public void getNameReturnsRightName(){
        //Arrange
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 100);
        String expectedName = "sour cream";

        //Act
        String actualName = ingredient.getName();

        //Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsRightPrice() {
        //Arrange
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 100);
        float expectedPrice = 100;

        //Act
        float actualPrice = ingredient.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice,  0.0f);
    }

}
