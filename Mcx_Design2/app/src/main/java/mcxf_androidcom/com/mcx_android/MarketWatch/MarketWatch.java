package mcxf_androidcom.com.mcx_android.MarketWatch;


/**
 * Created by Krishna Karthik on 3/22/2016.
 */
public class MarketWatch {

    private String Product;
    private String Expiry;
    private String TotalQtyTraded;
    private String LTP;
    private String PCP;
    private String PercentageChange;
    private String BuyPrice1;
    private String BuyQty1;
    private String SellPrice1;
    private String SellQty1;


    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getExpiry() {
        return Expiry;
    }

    public void setExpiry(String expiry) {
        Expiry = expiry;
    }

//    public String getTotalQtyTraded() {
//        return TotalQtyTraded;
//    }
//
//    public void setTotalQtyTraded(String totalQtyTraded) {
//        TotalQtyTraded = totalQtyTraded;
//    }

    public String getLTP() {
        return LTP;
    }

    public Double setLTP(String LTP) {
        this.LTP = LTP;
        return null;
    }

    public String getPercentageChange() {
        return PercentageChange;
    }

    public void setPercentageChange(String percentageChange) {
        PercentageChange = percentageChange;
    }

    public String getPCP() {
        return PCP;
    }

    public Double setPCP(String PCP) {
        this.PCP = PCP;
        return null;
    }

    public String getBuyPrice1() {
        return BuyPrice1;
    }

    public void setBuyPrice1(String buyPrice1) {
        BuyPrice1 = buyPrice1;
    }

    public String getBuyQty1() {
        return BuyQty1;
    }

    public void setBuyQty1(String buyQty1) {
        BuyQty1 = buyQty1;
    }

    public String getSellPrice1() {
        return SellPrice1;
    }

    public void setSellPrice1(String sellPrice1) {
        SellPrice1 = sellPrice1;
    }

    public String getSellQty1() {
        return SellQty1;
    }

    public void setSellQty1(String sellQty1) {
        SellQty1 = sellQty1;
    }
}
