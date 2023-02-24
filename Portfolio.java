import java.util.ArrayList;
import java.io.*;

/**
 * This class handels the entire profolio by using the StockHolding class
 * and calculates both investment and payout
 *
 * @author Brian Maloney
 * @version 2/24/2023
 */

public class Portfolio
{
    private ArrayList<StockHolding> stocks = new ArrayList<StockHolding>();
    private double investment;
    private double payout;

    public Portfolio(){
        investment = 0;
        payout = 0;
        stocks = new ArrayList <> ();
    }

    /**
    * Returns the lifetime payout for the portfolio.
    *
    * @return the lifetime payout for the portfolio.
    */
    public double getPayout(){
        return payout;
    }

    /**
    * Returns the lifetime investment for the portfolio.
    *
    * @return the lifetime investment for the portfolio.
    */
    public double getInvestment(){
        return investment;
    }

    /**
    * takes as input a stock symbol and 
    * should return the index of the stock in the ArrayList instance variable that has the same 
    * stock symbol as the actual parameter, else -1 is returned.
    * 
    * @param symbol the stock symbol.
    *
    * @return the index of the stock in the ArrayList instance variable that has the same stock symbol as the actual parameter, else -1 is returned.
    */
    private int getIndex(String symbol){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Takes input the symbol, name, shares to buy, and the current price per share. It determins if the stock is already in the list, 
     * it should be bought, if not then adds it to the list. 
     * 
     * @param symbol the stock symbol.
     * @param name the stock name.
     * @param buy the number of shares to buy.
     * @param price the current price per share.
     * 
     * @return the cost of buying this stock.
     */
    public double buyStock(String symbol, String name, int buy, double price){
        if(getIndex(symbol) != -1){
            stocks.get(getIndex(symbol)).buyShares(buy, price);
        } else {
            stocks.add(new StockHolding(symbol, name, buy, price));
        }
        investment += buy * price;
        return (buy * price);
    }

    /**
     * Takes the symbol and the number of shares to sell. If the symbol can be found, then it determins if selling the shares would be 0. 
     * If so, then it removes the stock from the list. If not, then it just subtracts the stocks.
     * It also updates the payout whether it leads to zero or not and returns the payout from selling this input number of shares of the input stock.
     * 
     * @param symbol a stock symbol.
     * @param sell the number of shares to sell.
     * 
     * @return the payout from selling this input number of shares of the input stock.
     */
    public double sellStock(String symbol, int sell){
        if(getIndex(symbol) != -1){
            if(stocks.get(getIndex(symbol)).sellShares(sell) == 0){
                stocks.remove(getIndex(symbol));
            } else {
                stocks.get(getIndex(symbol)).sellShares(sell);
            }
        }
        payout += stocks.get(getIndex(symbol)).sellShares(sell);
        return stocks.get(getIndex(symbol)).sellShares(sell);
    }

    /**
     * Does not take any input and returns the current value of the portfolio.
     * 
     * @return the current value of the portfolio.
     */
    public double getCurrentValue(){
        double total = 0;
        for(int i = 0; i < stocks.size(); i++){
            total += stocks.get(i).getPrice() * stocks.get(i).getShares();
        }
        return total;
    }

    /**
     * Returns a string bu using the toString from the StockHolding class.
     * 
     * @return A string describing the state of the object.
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
