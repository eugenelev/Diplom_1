import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Spy
    Ingredient ingredient = new Ingredient(FILLING, "sour cream", 50);

    @Test
    public void setBunsSetBunForBurger(){
        //Arrange
        Burger burger = new Burger();
        burger.setBuns(new Bun("red bun", 300));
        String expectedName = "red bun";
        float expectedPrice = 300;

        //Act
        String actualName = burger.bun.name;
        float actualPrice = burger.bun.price;

        //Assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void addIngredientAddIngredientToListIngredients(){
        //Arrange
        Ingredient ingredient = new Ingredient(FILLING, "sour cream", 1030);
        Burger burger = new Burger();
        int expectedSizeListIngredient = 1;

        //Act
        burger.addIngredient(ingredient);

        //Assert
        assertEquals(expectedSizeListIngredient, burger.ingredients.size());
    }

    @Test
    public void removeIngredientDeleteIngredientFromListIngredient(){
        //Arrange
        Ingredient ingredient = new Ingredient(FILLING, "sour cream", 1030);
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        int expectedSizeListIngredient = 0;

        //Act
        burger.removeIngredient(0);

        //Assert
        assertEquals(expectedSizeListIngredient, burger.ingredients.size());
    }

    @Test
    public void moveIngredientChangePositionIngredientInList(){
        //Arrange
        Ingredient ingredientFilling = new Ingredient(FILLING, "sour cream", 100);
        Ingredient ingredientSauce = new Ingredient(SAUCE, "hot sauce", 200);
        Burger burger = new Burger();
        burger.ingredients.add(ingredientFilling);
        burger.ingredients.add(ingredientSauce);
        IngredientType expectedIngredientType = FILLING;
        String expectedName = "sour cream";
        float expectedPrice = 100;

        //Act
        burger.moveIngredient(0, 1);

        //Assert
        assertEquals(expectedIngredientType, burger.ingredients.get(1).type);
        assertEquals(expectedName, burger.ingredients.get(1).name);
        assertEquals(expectedPrice, burger.ingredients.get(1).price, 0.0f);
    }

    @Test
    public void getPriceReturnsAmountOfBurger(){
        //Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.00F);

        float expectedPrice = 450.0F;

        //Act
        float actualPrice = burger.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void getReceiptReturnsReceiptForBurger(){
        //Arrange
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(burger.getPrice()).thenReturn(50.00F);

        String expectedReceipt = "(==== black bun ====)\n= sauce chili sauce =\n(==== black bun ====)\n\nPrice: 50.000000\n";

        //Act
        String actualReceipt = burger.getReceipt();

        //Assert
        assertEquals(expectedReceipt, actualReceipt);
    }

}
