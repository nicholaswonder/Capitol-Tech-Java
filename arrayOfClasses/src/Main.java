import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        List<sphere> spheres = new LinkedList<>();
        ListIterator<sphere> iter;

        int option = -1;
        float size;
        float searchSize;
        String searchColor;
        boolean exists = false;

        while (option != 0)
        {
            System.out.println("Select an option:");
            System.out.println("0. Exit Program");
            System.out.println("1: List Spheres");
            System.out.println("2: Search by Color");
            System.out.println("3. Search by Radius");
            System.out.println("4. Add New Sphere");
            System.out.println("5. Remove Sphere");
            System.out.print("Your option: ");
            option = scan.nextInt();

            switch (option)
            {
                case 0: // Quit
                    System.out.println("Exiting program");
                    break;

                case 1: // List all spheres
                    iter = spheres.listIterator();
                    while (iter.hasPrevious()) // Move iterator to beginning
                    {
                        iter.previous();
                    }

                    if (iter.hasNext()) // List Contents
                    {
                        while(iter.hasNext())
                        {
                            System.out.println(iter.next());
                        }
                    }
                    else // If list is empty
                    {
                        System.out.println("No Spheres!");
                    }
                    break;

                case 2:
                    iter = spheres.listIterator();
                    while (iter.hasPrevious()) // Move iterator to beginning
                    {
                        iter.previous();
                    }

                    if (iter.hasNext()) // List Contents
                    {
                        System.out.print("Enter color to search for: ");
                        searchColor = scan.next();

                        while(iter.hasNext())
                        {
                            if (iter.next().getColor().equals(searchColor))
                            {
                                iter.previous();
                                System.out.println(iter.next());
                            }
                        }
                        break;
                    }
                    else // If list is empty
                    {
                        System.out.println("No Spheres!");
                        break;
                    }

                case 3:
                    iter = spheres.listIterator();
                    while (iter.hasPrevious()) // Move iterator to beginning
                    {
                        iter.previous();
                    }

                    if (iter.hasNext()) // List Contents
                    {
                        System.out.print("Enter size to search for: ");
                        searchSize = scan.nextFloat();

                        while(iter.hasNext())
                        {
                            size = iter.next().getRadius();
                            if ((searchSize - 5) <= size && size <= (searchSize + 5))
                            {
                                iter.previous();
                                System.out.println(iter.next());
                            }
                        }
                        break;
                    }
                    else // If list is empty
                    {
                        System.out.println("No Spheres!");
                        break;
                    }

                case 4:
                    iter = spheres.listIterator();
                    // Reusing variables to save space
                    System.out.print("Enter new sphere radius: ");
                    searchSize = scan.nextFloat();

                    System.out.print("Enter new sphere color: ");
                    searchColor = scan.next();

                    sphere newSphere = new sphere(searchSize, searchColor);

                    while (iter.hasPrevious()) // Move iterator to beginning
                    {
                        iter.previous();
                    }

                    if (iter.hasNext()) // Search for existing sphere
                    {
                        while(iter.hasNext())
                        {
                            if(iter.next().equals(newSphere))
                            {
                                System.out.println("Sphere already exists!");
                                exists = true;
                                break;
                            }
                        }
                        if (!exists)
                        {
                            spheres.add(newSphere);
                        }
                    }
                    else // If list is empty
                    {
                        spheres.add(newSphere);
                    }
                    exists = false;
                    break;

                case 5:
                    iter = spheres.listIterator();
                    while (iter.hasPrevious()) // Move iterator to beginning
                    {
                        iter.previous();
                    }
                    searchSize = 0;

                    if (iter.hasNext()) // List Contents
                    {
                        while(iter.hasNext())
                        {
                            System.out.println((int)searchSize + ": " + iter.next());
                            searchSize++;
                        }
                        System.out.print("Enter which sphere to delete: ");
                        searchSize = scan.nextInt();

                        spheres.remove((int)searchSize);
                        break;
                    }
                    else // If list is empty
                    {
                        System.out.println("No Spheres!");
                        break;
                    }

                default:
                    System.out.println("Not a valid selection");
            }
        }

    }
}