/*

                                                            ABDULLAH.
                                                          FA22-BCT-004.
                                                 STUDENT PORTAL MANAGEMENT SYSTEM.

*/


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentManagementSystem
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
            int log_out = 0;
            int user_choice = 0;
            int tea_choice = 0;

            //Here all the Student data is loaded and stored in program.

            String [] stud_array = new String[100];
            loadDataFromFile(stud_array, "StudentFile\\student.txt");

            //Here all the Student passwords are stored in program.

            String [] pass_array = new String [50];
            loadDataFromFile(pass_array,"StudentFile\\Passwords.txt");

            //Here all the Email of the admins are stored in program.

            String[] email_array = new String[6];
            loadDataFromFile(email_array,"StudentFile\\email.txt");

            //Here all the Emails along with the password of admins is stored in program.

            String[][] em_pa_array = new String[5][2];
            loadDataFromFile(em_pa_array, "StudentFile\\emailPasswords.txt");

            //Here all the roll number are stored in program.

            String[] roll_array = new String[20];
            loadDataFromFile(roll_array, "StudentFile\\rollNumber.txt");

            //Here all the name of the students are stored in the program.

            String[] name_array = new String[20];
            loadDataFromFile(name_array, "StudentFile\\name.txt");

            //Here all the roll number and password are stored in program.

            String[][] ro_pa_array = new String[20][2];
            loadDataFromFile(ro_pa_array, "StudentFile\\rollPassword.txt");

            //Here all the fees status of the student are stored in program.

            String[] fees_array = new String[20];
            loadDataFromFile(fees_array, "StudentFile\\fees.txt");

            //Here all the attendance status of the student are stored in program.

            String[] att_array = new String[80];
            loadDataFromFile(att_array, "StudentFile\\attendance.txt");

            //Here all the marks of students are stored in program.

            String[] marks_array = new String[80];
            loadDataFromFile(marks_array, "StudentFile\\marks.txt");

            //Here all the teacher information are stored in program.

            String[] tea_array = new String[5];
            loadDataFromFile(tea_array, "StudentFile\\teacher.txt");

            //Here all the challan statuses of students are stored in program.

            String[] ch_array = new String[20];
            loadDataFromFile(ch_array, "StudentFile\\challan.txt");

            //Start of the Student portal Management System.

            System.out.println("-----------------------------------------------------------");
            System.out.println("Welcome to Student Portal Management System.");
            System.out.println("-----------------------------------------------------------");

            // Here the user will make an identification that whether he is an admin or user.

            System.out.println("Do you want to login as a Student or Admin enter 1 or 2 respectively:");
            try
            {
                user_choice = input.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Error");
            }

            // Based on user choice he/she will be given access to the required service.

            switch (user_choice)
            {
                case 1:
                System.out.println("Enter your Registration Number:");
                String roll_no = input.next();
                System.out.println("Enter your Password:");
                String pass_word = input.next();

                    /*

                    After Entering the Registration number and password it will be passed
                    To a boolean function below and the called and if it is correct it will be
                    passed to true statement and if not it will be invalid.

                     */

                boolean call_check = student_cred(roll_no, pass_word, roll_array, pass_array);
                if (call_check)
                {

                    //If the call_check will be true the program will start from here.

                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Access Granted!");
                    System.out.println("-----------------------------------------------------------");
                    do
                    {

                        //menu where the user can access his/her data.

                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Enter the service number you want to use:");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("1. Fees Status.");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("2. Attendance.");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("3. Course Information.");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("4. Challan Status.");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("5. Result Card.");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("6. Profile Section.");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("7. Log out.");
                        System.out.println("-----------------------------------------------------------");
                        int stud_fac_cho = input.nextInt();

                        // Here the output will be given on the basis of user input using switch cases.

                        switch (stud_fac_cho)
                        {
                            case 1:
                                //Here he/she will be shown his/her fee status.
                                feesStatus(roll_no, roll_array, fees_array);
                                break;
                            case 2:
                                //Here he/she will be shown his/her attendance status.
                                attendanceStatus(roll_no, roll_array, att_array);
                                break;
                            case 3:
                                //Here the teacher his/her enrolled for will be shown.
                                teachers(tea_array);
                                break;
                            case 4:
                                //Here his/her challan status will be shown.
                                challan(roll_no, roll_array, ch_array);
                                break;
                            case 5:
                                //Here his/her result will be shown.
                                result(roll_no, roll_array, marks_array);
                                break;
                            case 6:
                                //Here his her profile will be shown.
                                profile(roll_no, roll_array, name_array, tea_array);
                                break;
                            case 7:
                                //Here he/she can log out.
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Do you want to log out. Enter 1 to log out.");
                                log_out = input.nextInt();
                                break;
                            default:
                                System.out.println("Invalid Command.");
                        }
                    }
                    while (log_out != 1);

                    //If the user wants to log out he will enter 1 as yes option, and it will exit the code.

                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Thanks for using Student Portal Management System.");
                    System.out.println("-----------------------------------------------------------");
                }
                else
                {
                    System.out.println("Invalid registration number and password!");
                }
                break;

                //If the user is admin he/she will be asked his/her credential.

                case 2:
                   System.out.println("Enter your email:");
                   String teacher_email = input.next();
                   System.out.println("Enter your password:");
                   String teacher_password = input.next();
                   /*

                    After Entering the Email and password it will be passed
                    To a boolean function below and the called and if it is correct it will be
                    passed to true statement and if not it will be invalid.

                     */
                   boolean user_cred = checkUserCredential(teacher_email, teacher_password, em_pa_array);
                       if (user_cred)
                       {
                           System.out.println("-----------------------------------------------------------");
                           System.out.println("Access Granted!");
                           System.out.println("-----------------------------------------------------------");
                           do
                           {
                               //Here admin can make choice which function he/she have to perform.
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("Enter the service number you want to use:");
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("1. Add New Student");
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("2. View All Students");
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("3. Search Student");
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("4. Delete Student Record");
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("5. Get list of paid and unpaid student");
                               System.out.println("-----------------------------------------------------------");
                               System.out.println("6. Log out.");
                               System.out.println("-----------------------------------------------------------");
                               try
                               {
                                   tea_choice = input.nextInt();
                               }
                               catch (InputMismatchException e)
                               {
                                   System.out.println("Error");
                               }
                               switch (tea_choice)
                               {
                                   case 1:
                                       //Here admin can enter a new student into file.
                                       StudentEntry(roll_array, name_array, pass_array, fees_array, att_array, ch_array, marks_array);
                                       break;

                                   case 2:
                                       //Here admin can view all the student.
                                       ViewStudents(roll_array, name_array);
                                       break;

                                   case 3:
                                       //Here admin can search student depending on their credential.
                                       SearchStudent(roll_array, name_array, fees_array, att_array, ch_array);
                                       break;
                                   case 4:
                                       //Here admin can delete any student.
                                       DeleteEntry(roll_array, name_array, marks_array, pass_array, fees_array, att_array, ch_array);
                                       break;
                                   case 5:
                                       PUlist(roll_array, fees_array);
                                       break;
                                   case 6:
                                       //Here admin will be allowed to log out.
                                       System.out.println("-----------------------------------------------------------");
                                       System.out.println("Do you want to log out. Enter 1 to log out.");
                                       log_out = input.nextInt();
                                       break;
                                   default:
                                       System.out.println("Invalid Command.");
                               }

                           }
                           while (log_out != 1);
                           System.out.println("-----------------------------------------------------------");
                           System.out.println("Thanks for using Student Portal Management System.");
                           System.out.println("-----------------------------------------------------------");
                       }
                       else
                       {
                           System.out.println("Invalid email or Password");
                       }

            }
        }


    public static void PUlist(String [] a, String [] b) {
        System.out.println("\nRoll No.\tFees");
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != null)
            {
                if (b[i].equals("Unpaid"))
                {
                System.out.println(a[i] + "\t" + b[i]);
                }
            }
        }
//        String temp = "";
//        for (int i = 0; i<b.length; i++)
//     {
//            if (b[i] != null && b[i].equals("Paid") || b[i].equals("Unpaid")){
//                temp = b[i];
//
//            }
//            System.out.println(temp);
//
//        }

    }

    //This function will be used to save all the data individually and collectively into respective files.

    public static void saveStudentToFile(String[] roll_array, String[] name_array,String[] fees_array, String[] att_array, String[] ch_array, String [] pass_array, String [] marks_array)
    {
        try (FileWriter file = new FileWriter("StudentFile\\student.txt");
             PrintWriter writer = new PrintWriter(file))
        {
            for (int i = 0; i < 20; i++)
            {
                if (roll_array[i] != null)
                {
                    writer.println("The roll number of student is: " + roll_array[i]);
                    saveDataToFile(roll_array,"StudentFile\\rollNumber.txt" );
                    writer.println("The password of student is: " + pass_array[i]);
                    saveDataToFile(pass_array,"StudentFile\\Passwords.txt");
                    writer.println("The name of student is: " + name_array[i]);
                    saveDataToFile(name_array,  "StudentFile\\name.txt");
                    writer.println("The fees status of student is: " + fees_array[i]);
                    saveDataToFile(fees_array, "StudentFile\\fees.txt");
                    writer.println("The attendance of student is: "+att_array[i]);
                    saveDataToFile(att_array, "StudentFile\\attendance.txt");
                    writer.println("The challan status of student is : " + ch_array[i]);
                    saveDataToFile(ch_array, "StudentFile\\challan.txt");
                    writer.println("The marks of student is: " + marks_array[i]);
                    saveDataToFile(marks_array,"StudentFile\\marks.txt");
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while saving the student file.");
        }
    }


    /*
    In this particular function we are using boolean function to check whether the user is entering his/her
    credentials correct or not
    */

    public static boolean checkUserCredential(String a, String b, String[][]c)
    {
        for (int i = 0; i<c.length; i++)
        {
            for (int j =0; j<c[0].length; j++)
            {
                if (c[i][j].equals(a) && c[i + 1][j].equals(b))
                {
                    return true;
                }
            }
        }
        return false;
    }

    //Here user is given the output on the basis of his/her indexes as his registration number is stored.

    public static String val_return(String a, String [] c, String [] b)
    {
        String temp = "";
        for (int i =0; i< c.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                if (c[i] != null && c[i].equals(a))
                {
                    if (i == j)
                    {
                        temp = b[j];
                    }
                }

            }
        }
        return temp;
    }

    //Here this function is used to load data from the text file saved in the disk.

    public static void saveDataToFile(String [] a, String textFile)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(textFile)))
        {
            for (int i = 0; i < a.length; i++)
            {
                if (a[i]!= null)
                {
                    writer.println(a[i]);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Failed to save data to file.");
        }
    }

    //Here this function is used to save 2D arrays data to file.

    public static void saveDataToFile(String [][] a, String textFile)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(textFile)))
        {
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j<a[0].length; j++)
                {
                if (a[i][j] != null)
                {
                    writer.println(a[i][j]);
                }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Failed to save data to file.");
        }
    }

    //Here this function is used to load data from file.

    public static void loadDataFromFile(String [] a, String textFiles)
    {
        try (Scanner fileScanner = new Scanner(new File(textFiles)))
        {
            int index = 0;
            while (fileScanner.hasNextLine() && index < a.length)
            {
                String line = fileScanner.nextLine();
                a[index] = line;
                index++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
    }

    //Here this function is used to load 2D array data from file.

    public static void loadDataFromFile(String [][] a, String textFiles)
    {
        try (Scanner fileScanner = new Scanner(new File(textFiles)))
        {
            int index = 0;
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                if (index < a.length)
                {
                    int j;
                    for ( j = 0; j < a[index].length; j++)
                    {
                        a[index][j] = line;
                    }
                }
                index++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }

    }

    //From here the fees Status will be called.

    public static void feesStatus(String roll_no, String[]roll_array, String [] fees_array)
    {
        System.out.println("-----------------------------------------------------------");
        String status_ch = val_return(roll_no, roll_array, fees_array);
        System.out.println("Your fees status is currently in the list of: " + status_ch);
    }

    //From here attendance status will be called.

    public static void attendanceStatus(String roll_no, String [] roll_array, String [] att_array)
    {
        System.out.println("-----------------------------------------------------------");
        String attend_ch = val_return(roll_no, roll_array, att_array);
        System.out.println("Your Attendance is:\n" + attend_ch);
    }

    //From here teachers status will be called.

    public static void teachers(String [] tea_array)
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println("The teachers for your course are:");
        for (int i = 0; i < tea_array.length; i++)
        {
            System.out.println(tea_array[i]);
        }
    }

    //From here challan status will be called.

    public static void challan(String roll_no, String [] roll_array, String [] ch_array)
    {
        System.out.println("-----------------------------------------------------------");
        String ch_call = val_return(roll_no, roll_array, ch_array);
        System.out.println("You have " + ch_call);
    }

    //From here result will be called.

    public static void result(String roll_no, String [] roll_array, String [] marks_array)
    {
        System.out.println("-----------------------------------------------------------");
        String res_call = val_return(roll_no, roll_array, marks_array);
        System.out.println("-------------------Result Card-----------------------------");
        System.out.println(res_call);
        System.out.println("-----------------------------------------------------------");
    }

    //From here student profile will be called.

    public static void profile(String roll_no, String [] roll_array, String [] name_array, String [] tea_array)
    {
        System.out.println("-----------------------------------------------------------");
        String name_call = val_return(roll_no, roll_array, name_array);
        System.out.println("-------------------Profile Card-----------------------------");
        System.out.println("Student Name: " + name_call);
        System.out.println("-----------------------------------------------------------");
        System.out.println("The teachers for your course are:");
        for (int i = 0; i < tea_array.length; i++)
        {
            System.out.println(tea_array[i]);
        }
    }

    //From here student entry will be called.

    public static void StudentEntry(String [] roll_array, String [] name_array, String [] pass_array, String [] fees_array, String [] att_array, String [] ch_array, String [] marks_array)
    {
            Scanner input = new Scanner(System.in);
            int j;
            for (j = 0; j < 20; j++)
            {
                if (roll_array[j] == null)
                {
                    break;
                }
            }

            input.nextLine();

            System.out.println("Enter the Name of the Student: ");
            String name = input.nextLine();
            name_array[j] = name;

            System.out.println("Enter the Registration Number of the Student: ");
            String roll_number = input.nextLine();
            roll_array[j] = roll_number;

            System.out.println("Enter the Password of the Student: ");
            String password = input.nextLine();
            pass_array[j] = password;

            System.out.println("Enter the marks of Student: ");
            String marks = input.nextLine();
            marks_array[j] = marks;

            System.out.println("Enter the Fees status of the Student: ");
            String fees = input.nextLine();
            fees_array[j] = fees;

            System.out.println("Enter the Attendance of the Student: ");
            String attendance = input.nextLine();
            att_array[j] = attendance;

            System.out.println("Enter the Challan Status: ");
            String challan = input.nextLine();
            ch_array[j] = challan;

        System.out.println("Student Added Successfully!");
        saveStudentToFile(roll_array, name_array, fees_array, att_array, ch_array, pass_array, marks_array);
    }

    //From here view student will be called.

    public static void ViewStudents(String [] roll_array, String [] name_array)
    {
        System.out.println("\n\t\tAll Students");
        System.out.println("\nRoll No.\tName");
        for (int i = 0; i < roll_array.length; i++)
        {
            if (roll_array[i] != null)
            {
                System.out.println(roll_array[i] + "\t" + name_array[i]);
            }
        }
    }

    //From here student search will be called.

    public static void SearchStudent(String [] roll_array, String [] name_array, String [] fees_array, String [] att_array, String [] ch_array)
    {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter the Roll Number of the Student: ");
            String search_roll = input.next();

            int found = 0;
            for (int i = 0; i < 20; i++) {
                if (roll_array[i] != null && roll_array[i].equals(search_roll))
                {
                    System.out.println("\n\t\tStudent Details");
                    System.out.println("Roll Number: " + roll_array[i]);
                    System.out.println("Name: " + name_array[i]);
                    System.out.println("Fees: " + fees_array[i]);
                    System.out.println("Attendance: " + att_array[i]);
                    System.out.println("Challan: " + ch_array[i]);
                    found = 1;
                    break;
                }
            }
            if (found == 0)
            {
                System.out.println("\nStudent Not Found!");
            }
        }

    //From here Delete student entry will be called.

    public static void DeleteEntry(String [] roll_array, String [] name_array, String [] marks_array, String [] pass_array, String [] fees_array, String [] att_array, String [] ch_array)
    {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter the Roll Number of the Student: ");
            String delete_roll = input.next();
            int delete_found = 0;
            for (int i = 0; i < 20; i++)
            {
                if (roll_array[i] != null && roll_array[i].equals(delete_roll))
                {
                    roll_array[i] = null;
                    name_array[i] = null;
                    pass_array[i] = null;
                    fees_array[i] = null;
                    att_array[i] = null;
                    marks_array[i] = null;
                    ch_array[i] = null;
                    saveStudentToFile(roll_array, name_array, fees_array, att_array, ch_array, pass_array, marks_array);
                    System.out.println("\nStudent Record Deleted Successfully!");
                    delete_found = 1;
                    break;
                }
            }
            if (delete_found == 0)
            {
                System.out.println("\nStudent Not Found!");
            }
        }


    //from here Student credential check will be called.

    public static boolean student_cred(String a, String b, String [] c,String [] d)
    {
        for (int i = 0; i< c.length; i++)
        {
            if (a.equals(c[i]) && b.equals(d[i]))
                return true;
        }
        return false;
    }
}
