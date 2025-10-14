public class employee
{
    private String firstName;
    private String lastName;
    private int age;
    private int employeeID;
    private int salary;

    public employee()
    {
        firstName = "NULL";
        lastName = "NULL";
        age = 0;
        employeeID = 0;
        salary = 0;
    }

    public employee(String firstName, String lastName, int age, int employeeID, int salary)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setEmployeeID(employeeID);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18)
        {
            this.age = age;
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 0)
        {
            this.salary = salary;
        }
    }

    public String toString()
    {
        return firstName + lastName + "\n"
                + "ID: " + employeeID + "\n"
                + "SALARY: $" + salary + "\n";
    }
}
