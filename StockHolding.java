/**
 * Write a description of class Asset here.
 *
 * @author Brian Maloney
 * @version (a version number or a date)
 */
public class StockHolding
{
    public int symbol;
    public String name;
    public int numShares;
    public int price;
    
    
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
    }
}
