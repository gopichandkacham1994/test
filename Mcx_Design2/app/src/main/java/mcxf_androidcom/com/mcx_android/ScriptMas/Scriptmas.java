package mcxf_androidcom.com.mcx_android.ScriptMas;

/**
 * Created by Krishna Karthik on 3/24/2016.
 */
public class Scriptmas {
    private String Instrument_Code;
    private String Lot_Size;
    private String Tick_Size;
    private String Instrument_Description;
    private String Trading_Unit;

    public String getInstrument_Code() {
        return Instrument_Code;
    }

    public void setInstrument_Code(String instrument_Code) {
        Instrument_Code = instrument_Code;
    }

    public String getLot_Size() {
        return Lot_Size;
    }

    public void setLot_Size(String lot_Size) {
        Lot_Size = lot_Size;
    }

    public String getTick_Size() {
        return Tick_Size;
    }

    public void setTick_Size(String tick_Size) {
        Tick_Size = tick_Size;
    }

    public String getInstrument_Description() {
        return Instrument_Description;
    }

    public void setInstrument_Description(String instrument_Description) {
        Instrument_Description = instrument_Description;
    }

    public String getTrading_Unit() {
        return Trading_Unit;
    }

    public void setTrading_Unit(String trading_Unit) {
        Trading_Unit = trading_Unit;
    }
}
