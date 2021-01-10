package classes;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String fName;
    private String lName;
    private String password;
    private String department;
    private String alternameEmail;
    private String email;
    private int mailBoxCap = 4000;
    private int defaultPasswordLenght = 30;

    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

        this.password = setPassword(defaultPasswordLenght);
        this.department = setDepartment();
        this.email =  fName.toLowerCase() + lName.toLowerCase() +"@"+this.department.toLowerCase()+".email.com";

        System.out.println("Email created for: " +fName +""+ lName +"\n Email is: "+email );
        System.out.println("Department: " + this.department);
        System.out.println("Password is: " +this.password);



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

    public String getPassword() {
        return password;
    }

    private String setPassword( int lenght) {
        String passwordset= "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ1234567890$#%&@*";
        char[] password = new char[lenght];
        for (int i = 0; i < lenght; i++) {
         int rand =(int)(Math.random() * passwordset.length());
         password[i] = passwordset.charAt(rand);
        }
        return new String(password);
    }

    public String getDepartment() {
        return department;
    }

    private String setDepartment() {

        System.out.println("Department CODES: \n 1 SALES \n 2 ACCOUNTING\n 3 DEVELOPMENT \n 4 NO DEPARTMENT \n\n Enter department code then press enter: ");

        Scanner in = new Scanner(System.in);

        int depChoice = in.nextInt();


        if( depChoice == 1){  return "sales";}
        if( depChoice == 2){  return "Accounting";}
        if( depChoice == 3){ return  "Development";}
        if( depChoice == 4){ return  "No department";}
        else{
            return ("invalid input");


        }



    }

    public String getAlternameEmail() {
        return alternameEmail;
    }

    public void setAlternameEmail(String alternameEmail) {
        this.alternameEmail = alternameEmail;
    }

    public String changePassword() {
        System.out.println("Please write the old password to change to new one:");
        Scanner in = new Scanner(System.in);

        String oldPass = in.next();

        if(oldPass.equals(this.password)){

            System.out.println("Please write your desired password:");
            Scanner in2 = new Scanner(System.in);

            String newPass = in2.next();
            this.password = newPass;
            System.out.println(" new password set");
            return newPass;



        }else {
            System.out.println("wrong try again its :" +this.password);

            changePassword();
            return "bad value";
        }

    }

    public int getMailBoxCap() {
        return mailBoxCap;
    }

    public void setMailBoxCap(int mailBoxCap) {
        this.mailBoxCap = mailBoxCap;
    }
}


