import java.util.ArrayList;

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
