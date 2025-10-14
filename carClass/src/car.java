public class car
{
    private String make;
    private String model;
    private String color;
    private String vin;
    private int year;
    private int fuelCap;
    private int fuelLevel;


    public car()
    {
        make = "NULL";
        model = "NULL";
        color = "NULL";
        vin = "NULL";
        year = 0;
        fuelCap = 0;
        fuelLevel = 0;
    }

    public car(String make, String model, String color, String vin, int year, int fuelCap, int fuelLevel)
    {
        setMake(make);
        setModel(model);
        setColor(color);
        setVin(vin);
        setYear(year);
        setFuelCap(fuelCap);
        setFuelLevel(fuelLevel);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (1885 <= year)
        {
            this.year = year;
        }
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        if (0 <= fuelCap)
        {
            this.fuelCap = fuelCap;
        }
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel <= fuelCap)
        {
            this.fuelLevel = fuelLevel;
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return make + " " + model + "\n" +
                "COLOR: " + color + "\n" +
                "YEAR: " + year + "\n" +
                "VIN: " + vin + "\n" +
                "FUEL CAP: " + fuelCap + " GALLONS\n" +
                "FUEL LEVEL: " + fuelLevel + " GALLONS\n";
    }
}

