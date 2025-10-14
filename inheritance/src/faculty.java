public class faculty extends employee
{
    // What the faculty teaches
    private String subject;

    public faculty()
    {
        super();
        subject = "NULL";
    }

    public faculty(String firstName, String lastName, int age, int employeeID, int salary, String subject)
    {
        super(firstName, lastName, age, employeeID, salary);
        setSubject(subject);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString()
    {
        return super.toString() + "TEACHES: " + subject + "\n";
    }
}
