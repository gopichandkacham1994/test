package mcxf_androidcom.com.mcx_android.MainMarketWatch;

/**
 * Created by Krishna Karthik on 4/26/2016.
 */
public class MainMarketwatch_Get_Set {


    private String Product;
    private String Expiry;
    private String TotalQtyTraded;
    private String LTP;
    private String PCP;
    private String PercentageChange;
    private String value;
    private String PQU;
    private String QL;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPQU() {
        return PQU;
    }

    public void setPQU(String PQU) {
        this.PQU = PQU;
    }

    public String getQL() {
        return QL;
    }

    public void setQL(String QL) {
        this.QL = QL;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
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

}