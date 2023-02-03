import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnsRightName(){
        //Arrange
        Bun bun = new Bun("black bun", 100);
        String expectedName = "black bun";

        //Act
        String actualName = bun.getName();

        //Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsRightPrice() {
        //Arrange
        Bun bun = new Bun("black bun", 100);
        float expectedPrice = 100;

        //Act
        float actualPrice = bun.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice,  0.0f);
    }

}
