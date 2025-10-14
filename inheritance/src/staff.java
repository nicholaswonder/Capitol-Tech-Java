public class staff extends employee
{
    // role is used for recording staff roles like "principal", "janitor", "cafeteria attendee"
    private String role;

    public staff()
    {
        super();
        role = "NULL";
    }

    public staff(String firstName, String lastName, int age, int employeeID, int salary, String role)
    {
        super(firstName, lastName, age, employeeID, salary);
        setRole(role);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString()
    {
        return super.toString() + "ROLE: " + role + "\n";
    }
}
