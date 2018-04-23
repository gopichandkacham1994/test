package mcxf_androidcom.com.mcx_android.Graph;

/**
 * Created by Krishna Karthik on 5/11/2016.
 */
public class Table {

    private String Expiry;
    private String PCP;
    private String LTP;
    private String Percentagechange;
    private String Time;

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

    public String getPercentagechange() {
        return Percentagechange;
    }

    public void setPercentagechange(String percentagechange) {
        Percentagechange = percentagechange;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
