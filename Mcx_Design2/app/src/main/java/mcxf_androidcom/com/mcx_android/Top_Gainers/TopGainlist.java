package mcxf_androidcom.com.mcx_android.Top_Gainers;

/**
 * Created by Krishna Karthik on 4/1/2016.
 */
public class TopGainlist {
    private String Product;
    private String Expiry;
    private String PCP;
    private String LTP;
    private String PercentageChange;
    private String change;

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

    public String getPCP() {
        return PCP;
    }

    public void setPCP(String PCP) {
        this.PCP = PCP;
    }

    public String getLTP() {
        return LTP;
    }

    public void setLTP(String LTP) {
        this.LTP = LTP;
    }

    public String getPercentageChange() {
        return PercentageChange;
    }

    public void setPercentageChange(String percentageChange) {
        PercentageChange = percentageChange;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}


