package mcxf_androidcom.com.mcx_android.BhavCopy;

/**
 * Created by Krishna Karthik on 3/22/2016.
 */
public class BhavCopy {
    private String Date;
    private String Commodity;
    private String Expiry;
    private String PCP;
    private String Volume;
    private String Value;
    private String OI;
    private String Close;
    private String ATP;


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCommodity() {
        return Commodity;
    }

    public void setCommodity(String commodity) {
        Commodity = commodity;
    }

    public String getExpiry() {
        return Expiry;
    }

    public void setExpiry(String expiry) {
        Expiry = expiry;
    }

    public String getClose() {
        return Close;
    }

    public void setClose(String close) {
        Close = close;
    }

    public String getPCP() {
        return PCP;
    }

    public void setPCP(String PCP) {
        this.PCP = PCP;
    }

    public String getATP() {
        return ATP;
    }

    public void setATP(String ATP) {
        this.ATP = ATP;
    }


    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getOI() {
        return OI;
    }

    public void setOI(String OI) {
        this.OI = OI;
    }

}
