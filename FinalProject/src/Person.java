import java.util.Objects;

public class Person {
    private int ID;
    private String FName;
    private String LName;

    public Person(int id, String first, String last){
        setID(id);
        setFName(first);
        setLName(last);
    }

    public Person(String first, String last){ // For existence tests
        setID(0);
        setFName(first);
        setLName(last);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    @Override
    public String toString() {
        return getFName() + " " + getLName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getFName(), person.getFName()) && Objects.equals(getLName(), person.getLName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFName(), getLName());
    }
}
