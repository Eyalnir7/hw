/*
Can be used in order to generate a random number between two given values
 */
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

    //Returns a random number between two numbers
    public int roll()
    {
        return Main.rnd.nextInt(lowestValue, highestValue);
    }
}
