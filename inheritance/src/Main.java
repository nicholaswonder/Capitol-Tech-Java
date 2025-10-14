import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        int option = -1;
        int count;

        Scanner scan = new Scanner(System.in);
        List<employee> list = new LinkedList<>();
        ListIterator<employee> iter = list.listIterator();

        while (option != 0)
        {
            System.out.println("Choose an option: ");
            System.out.println("1: View all employees");
            System.out.println("2. Add new staff member");
            System.out.println("3. Add new faculty member");
            System.out.println("4. Remove Employee");
            System.out.println("0. End Program");

            option = scan.nextInt();

            switch (option)
            {
                case 1:
                    for (int i = 0; i < list.size(); i++)
                    {
                        System.out.println(list.get(i).toString());
                    }
                    break;

                case 2:
                    System.out.println("Enter in new staff member");
                    System.out.println("First Name, Last Name, Age, Employee ID, Salary, Role");
                    staff newStaff = new staff(
                            scan.next(),
                            scan.next(),
                            scan.nextInt(),
                            scan.nextInt(),
                            scan.nextInt(),
                            scan.next()
                    );
                    System.out.println(newStaff);
                    list.add(newStaff);
                    break;

                case 3:
                    System.out.println("Enter in new faculty member");
                    System.out.println("First Name, Last Name, Age, Employee ID, Salary, Subject");
                    faculty newFac = new faculty(
                            scan.nextLine(),
                            scan.nextLine(),
                            scan.nextInt(),
                            scan.nextInt(),
                            scan.nextInt(),
                            scan.nextLine()
                    );
                    System.out.println(newFac);
                    list.add(newFac);
                    break;

                case 4:
                    System.out.println("Select employee to remove");
                    for (int i = 0; i < list.size(); i++)
                    {
                        System.out.println(i + ". " + list.get(i).getFirstName());
                    }
                    list.remove(scan.nextInt());
                    break;
            }
        }
    }
}