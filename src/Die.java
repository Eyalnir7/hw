import java.util.*;
public class Die {
    private int lowestValue;
    private int highestValue;

    public Die(int lowestValue, int highestValue)
    {
        this.lowestValue = lowestValue;
        this.highestValue = highestValue;
    }

    public Die()
    {
        this.lowestValue = 0;
        this.highestValue = 7;
    }

    public int roll()
    {
        Random rand = new Random();
        return rand.nextInt(lowestValue, highestValue);
    }
}
