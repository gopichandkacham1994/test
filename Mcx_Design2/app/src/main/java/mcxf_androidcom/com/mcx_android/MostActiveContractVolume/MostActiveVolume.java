package mcxf_androidcom.com.mcx_android.MostActiveContractVolume;

/**
 * Created by Krishna Karthik on 4/1/2016.
 */
public class MostActiveVolume {

    private String Product;
    private String Expiry;
    private String PQU;
    private String QL;
    private String LTP;
    private String Value;

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

    public String getLTP() {
        return LTP;
    }

    public void setLTP(String LTP) {
        this.LTP = LTP;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
