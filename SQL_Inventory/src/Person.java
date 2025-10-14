import java.util.Objects;

public class Person {
    private final int id;
    private String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Person(String name){ // Only for equals method
        this.name = name;
        this.id = 0;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name){
        this.name = name;
    }

    public int GetID() {
        return id;
    }

    // id cannot be changed in sql, so it shouldn't be changed in the object

    public String toString() {
        return id + ", " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
