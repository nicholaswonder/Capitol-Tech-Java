
public class human
{
    // Variables
    private String fName;
    private String lName;
    private int ID;
    private int zip;
    private int birthYear;

    public human()
    {
        fName = "John";
        lName = "Doe";
        ID = 0;
        zip = 0;
        birthYear = 0;
    }

    public human(String first, String last, int idNum, int zipCode, int year)
    {
        setfName(first);
        setlName(last);
        setID(idNum);
        setZip(zipCode);
        setBirthYear(year);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        if (zip > 0)
        {
            this.zip = zip;
        }
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear > 0)
        {
            this.birthYear = birthYear;
        }
    }

    public String toString()
    {
        return(fName + " " + lName + "\n" + "ID: " + ID + "\n" +
                "Zip code: " + zip + "\n" + "Birth Year: " + birthYear);
    }
}
