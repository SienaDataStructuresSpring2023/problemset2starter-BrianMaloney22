import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Portfolio here.
 *
 * @author Brian Maloney
 * @version 2/20/2023
 */

public class Portfolio
{
    private StockHolding [] stocks;
    private int investment;
    private int payout;

    public Portfolio(){
        investment = 0;
        payout = 0;
        stocks = new StockHolding [5];
    }
    
    public int getPayout(){
        return payout;
    }

    public int getInvestment(){
        return investment;
    }
    
    private int getIndex(String symbol){
        for(int i = 0; i < stocks.length; i++){
            if(stocks[i].getSymbol().equals(symbol)){
              return i;
            }
        }
        return -1;
    }
    
    public double buyStock(String symbol, String name, int buy, double price){
        if(getIndex(symbol) != -1){
            stocks[getIndex(symbol)].buyShares(buy, price);
        } else {
            //stocks.add(symbol);
        }
        return (buy * price);
    }
    
    public double sellStock(String symbol, int sell){
        if(getIndex(symbol) != -1){
            if(stocks[getIndex(symbol)].sellShares(sell) == 0){
                stocks[getIndex(symbol)] = null;;
            } else {
                stocks[getIndex(symbol)].sellShares(sell);
            }
        }
        return stocks[getIndex(symbol)].sellShares(sell);
    }
    
    public int getCurrentValue(){
        int total = 0;
        for(int i = 0; i < stocks.length; i++){
            total += stocks[i].getPrice() * stocks[i].getShares();
        }
        return total;
    }
    
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
