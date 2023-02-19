/**
 * Write a description of class Asset here.
 *
 * @author Brian Maloney
 * @version 2/18/2023
 */
public class StockHolding
{
    public String symbol;
    public String name;
    public int numShares;
    public Double price;
    
    public StockHolding(String sym, String names, int share, Double prices){
        symbol = sym;
        name = names;
        numShares = share;
        price = prices;
    }
    
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
    }
}
