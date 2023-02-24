import java.util.ArrayList;
import java.io.*;

/**
 * Write a description of class Portfolio here.
 *
 * @author Brian Maloney
 * @version 2/20/2023
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

    public double getPayout(){
        return payout;
    }

    public double getInvestment(){
        return investment;
    }

    private int getIndex(String symbol){
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getSymbol().equals(symbol)){
                return i;
            }
        }
        return -1;
    }

    public double buyStock(String symbol, String name, int buy, double price){
        if(getIndex(symbol) != -1){
            stocks.get(getIndex(symbol)).buyShares(buy, price);
        } else {
            stocks.add(new StockHolding(symbol, name, buy, price));
        }
        investment += buy * price;
        return (buy * price);
    }

    public double sellStock(String symbol, int sell){
        if(getIndex(symbol) != -1){
            if(stocks.get(getIndex(symbol)).sellShares(sell) == 0){
                stocks.remove(getIndex(symbol));
            } else {
                stocks.get(getIndex(symbol)).sellShares(sell);
            }
        }
        return stocks.get(getIndex(symbol)).sellShares(sell);
    }

    public double getCurrentValue(){
        double total = 0;
        for(int i = 0; i < stocks.size(); i++){
            total += stocks.get(i).getPrice() * stocks.get(i).getShares();
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
