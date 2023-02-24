/**
 * Write a description of class Asset here.
 *
 * @author Brian Maloney
 * @version 2/18/2023
 */
public class StockHolding
{
    private String symbol;
    private String name;
    private int numShares;
    private Double price;

    public StockHolding(String symbol, String name, int numShares, Double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    
    /**
    * Returns the stock symbol.
    *
    * @return The stock symbol.
    */
    public String getSymbol(){
        return symbol;
    }
    
    /**
    * Returns the stock name.
    *
    * @return The stock name.
    */
    public String getName(){
        return name;
    }
    
    /**
    * Returns the number of shares in the stock.
    *
    * @return the number of shares in the stock.
    */
    public int getShares(){
        return numShares;
    }
    
    /**
    * Returns the price of the stock.
    *
    * @return The price of the stock.
    */
    public Double getPrice(){
        return price;
    }
    
    /**
     * Takes the input buy and prices and assigns them to numShares and price.
     * 
     * @param buy the number of shares to buy.
     * @param the price per share.
     */
    public void buyShares(int buy, double prices){
        numShares = buy;
        price = prices;
    }

    /**
     * Takes input the number of shares to sell and 
     * if there is at least as many sell as there are numShares, it reurns 
     * the sell times price.
     * 
     * @param sell the number of shares to sell.
     * 
     * @return the dollar amount resulting from the sale of the shares.
     */
    public double sellShares(int sell){
        double money = 0;
        if(numShares >= sell){
            money = sell * price;
        }
        return money;
    }

    /**
     * Returns a string containing the stock symbol, name, number of shares, price,
     * and the number of shares times the price.
     * 
     * @return A string describing the state of the object.
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
            symbol, name, numShares, price, numShares * price); 
    }
}
