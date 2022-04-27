/*
Can be used in order to generate a random number between two given values
 */
public class Die {
    private int lowestValue;
    private int highestValue;

    public Die(int highestValue, int lowestValue)
    {
        this.lowestValue = lowestValue;
        this.highestValue = highestValue;
    }

    public Die()
    {
        this.lowestValue = 1;
        this.highestValue = 6;
    }

    //Returns a random number between two numbers
    public int roll()
    {
        return Main.rnd.nextInt(lowestValue, highestValue+1);
    }
}
