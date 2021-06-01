import java.util.Scanner;
import java.util.*;

public class App {

    private Admin admin;
    private Donator donator;
    private Beneficiary beneficiary;
    private Organization org;
    private int phonenumber;
    private String name;
    ArrayList<String> phoneNumbers=new ArrayList<>();
    private int itteration=0;
    private Offers offer;
    public static Material mat;
    Main main=new Main();
    private RequestDonation rd;

    public App(Organization org) {
        this.org=org;
    }

    public void entermenu(){
        
        if(this.itteration==0){
            org.addInitial(org);//Prosthesh arxikwn xrhstwn sthn lista
            this.itteration=this.itteration+1;
        }

        this.org.getDonatorList();//Enai sth lista kai prosthetontai kai alla stoixeia olla pena
        this.org.getBeneficiaryList();//Enai sth lista kai prosthetontai kai alla stoixeia
        this.phonenumber=checkuser();

        int isuser=checkuserlist(this.phonenumber);
        //App app1=new App();
        switch(isuser){
            case 1:
                System.out.println("You are an Admin! Welcome!");
                this.adminMenu(this.admin);
                break;
            case 2:
                System.out.println("You are a Donator! Welcome!");
                this.donatorMenu(this.donator);
                break;
            case 3:
                System.out.println("You are a Beneficiary! Welcome!");
                this.beneficiaryMenu(this.beneficiary);
                break;
            case -1:
                this.register(this.phonenumber);
        }
        
    }

    public void register(int phone){

        Scanner scan = new Scanner(System.in);
        Scanner scanname= new Scanner(System.in);
        int check = -1;
        String name;
        
       
        System.out.println("\nΔεν είστε μέλος, παρακαλώ επιλέξτε ένα απο τα παρακάτω για εγγραφή:\n"
        + "1. Donator\n"
        + "2. Beneficiary\n"
        + "0. Exit\n");
        
        check = scan.nextInt();

        
        
        switch (check) {
            
            case 1:
                System.out.println("1. Επιλέξατε Donator\n");
                System.out.println("Παρακαλώ εισάγετε το όνομα σας:\n");
                name= scanname.nextLine();
                Donator don = new Donator(name, phone, this.org);
                this.org.addDonator(don);
                System.out.println("Εγγραφή επιτυχής!\n");
                this.donatorMenu(don);
                break;
            case 2:
                System.out.println("2.Επιλέξατε Beneficiary\n");
                System.out.println("Παρακαλώ εισάγετε το όνομα σας:\n");
                name = scanname.nextLine();
                Beneficiary ben = new Beneficiary(name, phone, this.org);
                this.org.addBeneficiary(ben);
                System.out.println("Εγγραφή επιτυχής!\n");
                this.beneficiaryMenu(ben);
                break;
            default: 
            System.out.println("Ciao!");
            System.exit(0);
        }
            

        System.out.println("Bye bye.");

        // System.out.println("Closing scanner...\n");
        // scan.close();

        // System.out.println("Scanner closed.\n");

    }


    public static int checkuser(){

        
        
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        
        int checknumber = -1;
        int phonenumber=0;

        while (checknumber!=1){
            System.out.println("\n\nΠαρακαλώ εισάγετε αριθμό τηλεφώνου:\n");
            phonenumber = scan1.nextInt();
            System.out.println( "Επιβεβαίωση: " + phonenumber
                + "\n1. Ναι\n"
                + "2. Όχι");
            checknumber = scan2.nextInt();
            
            
        }
     
        // System.out.println("Closing scanner...\n");
        // scan1.close();
        // scan2.close();
        // System.out.println("Scanner closed.\n");

        return phonenumber;
    }
    //output1->Admin
    //output2->Donator
    //output3->Beneficiary
    //output-1->Not registered
    public int checkuserlist(int phonenum){
        //Donator dn=new Donator(this.name,this.phonenumber,this.org);
        int flag;
        if(("123").equals(Integer.toString(phonenum)))
            flag=1;
        else {
            flag= org.checkList(phonenum);
        }
     return flag;
    }


    public void donatorMenu(Donator don) {

        int index = org.returnDonatorIndexWithPhone(this.phonenumber);
        don = (Donator) org.getDonatorList().get(index);
        System.out.println("\nΚαλησπέρα σας, καλώς ήλθατε " +   don.getName() + " από τον Οργανισμό: " + don.getOrg().getName()); //dhmiourgia methodou getname/number //enarksh menu donator
        System.out.println("\n1. Add Offer\n"+"2. Show Offers\n"+"3. Commit\n"+"4. Back\n"+"5. Logout\n"+"6. Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice;
        choice = scan.nextInt();
        switch(choice){
            case 1:
                addoffer(/*user*/);
                break;
            case 2:
                showoffers(/*user*/);
                donatorMenu(don);
                break;
            case 3: 
                //commit(user);//donator commit
                donatorMenu(don);
                break;
            case 4:
                System.out.println("Main Menu:\n");
                donatorMenu(don);
                break;
            case 5:
                entermenu();//logout();
                break;
            case 6:
                System.out.println("Byeeeeeee");    
                System.exit(0);
                break;
            default:
                break;

        }
    }

    public void addoffer(/*user*/){
        Scanner scan = new Scanner(System.in);
        int choice,choice1;
        double quan;
        System.out.println("1. Material\n" + "2. Services\n");
        choice = scan.nextInt();
        
        if(choice==1) {
            org.listEntities(1);
            System.out.println("Θέλετε να προφέρετε;\n1. Ναι\n2. Όχι\n");
            choice = scan.nextInt();
            if (choice==1) {
                System.out.println("Επιλέξτε το αντικείμενο που θέλετε να προσφέρετε:");
                System.out.println("1.Milk 2.Sugar 3.Rice");
                choice1=scan.nextInt();
                if(choice1==1){
                    System.out.println("Εισάγετε την ποσότητα που θέλετε να προσφέρετε:");
                    quan = scan.nextDouble();
                    this.org.addQuantityMaterial(quan, choice1-1);
                    //getMaterialList().get(choice1);
                }
                else if(choice1==2){
                    System.out.println("Εισάγετε την ποσότητα που θέλετε να προσφέρετε:");
                    quan = scan.nextDouble();
                    this.org.addQuantityMaterial(quan, choice1-1);
                    //sugar.setQuantity(quan);
                }
                else if(choice1==3){
                    System.out.println("Εισάγετε την ποσότητα που θέλετε να προσφέρετε:");
                    quan = scan.nextDouble();
                    this.org.addQuantityMaterial(quan, choice1-1);
                    //milk.setQuantity(quan);
                }
                else {
                    System.out.println("Επιστροφή στο μενού!"); 
                    this.donatorMenu(this.donator);
                }
            
                
                
                //System.out.println("Εισάγετε την ποσότητα που θέλετε να προσφέρετε:");
                //quan = scan.nextDouble();
                //mat.setQuantity(quan);
                //System.out.println("Οι νέες ποσότητες μετά την προσφορά σας:");
                //org.listEntities(1);
            }
            if(choice==2){
                System.out.println("Επιστροφή στο μενού!");
                this.donatorMenu(this.donator);
            }
             else {
            System.out.println("Επιστροφή στο μενού!"); 
            this.donatorMenu(this.donator);
        }
    }
        
                
        else if(choice==2) {
            org.listEntities(0);
            System.out.println("Θέλετε να προφέρετε;\n1. Ναι\n2. Όχι\n");
            choice = scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Επιλέξτε την υπηρεσία που θέλετε να προσφέρετε:");
                    System.out.println("1.Medical Support 2.Nursery Support 3.Baby Sitting");
                    choice1=scan.nextInt();
                    if(choice1==1){
                        System.out.println("Εισάγετε τις ώρες που θέλετε να προσφέρετε:");
                        quan = scan.nextDouble();
                        this.org.addQuantityService(quan, choice1-1);                
                    }
                    else if(choice1==2){
                        System.out.println("Εισάγετε τις ώρες που θέλετε να προσφέρετε:");
                        quan = scan.nextDouble();
                        this.org.addQuantityService(quan, choice1-1);                
                    }
                    else if(choice1==3){
                        System.out.println("Εισάγετε τις ώρες που θέλετε να προσφέρετε:");
                        quan = scan.nextDouble();
                        this.org.addQuantityService(quan, choice1-1);                
                    }
                    else {
                        System.out.println("Επιστροφή στο μενού!"); 
                        this.donatorMenu(this.donator);
                    }
                    this.donatorMenu(this.donator);
                break;
                case 2:
                    this.donatorMenu(this.donator);
                break;
            
            }
        }
    }

    //  public Material getMaterialList(int index){
    //     Material material = 
    //     return material;
    //  }

    public void showoffers(){
        
        Scanner scan = new Scanner(System.in);

        //requestdonationlist(user)?//Αρχικά εμφανίζεται αριθμημένη λίστα με τα RequestDonation που προσφέρει ο Donator,διαφορετικά μήνυμα ότι δεν έχει προσφορές αυτή τη στιγμή.
        org.listEntities(1);
        org.listEntities(0);
        System.out.println("Παρακαλώ είσάγετε το ID του αντικειμένου προς τροποποίηση:\n Αλλιώς πατήστε 0000 για να κανετε επιβεβαίωση ή -1 για διαγραφή όλλων.\n");
        int idRD = scan.nextInt();
        switch (idRD){
            case -1:
                //klhsh sunarthshs diagrafhs
            case 0000:
                //klhsh commit();
            default:
                System.out.println("1. Για διαγραφή μητρώου/2. Για τρποποίηση ποσότητας\n");
                int choice=-1;
                if(choice==1){
                    //klshsh sunarthshs diagrafhs entry
                }else{
                    //klhsh sunarthshs tropopoihshs
                }
        }
        



    }


    public void beneficiaryMenu(Beneficiary ben) { //prepei na pernei ws orisma ton user

        int index = org.returnBeneficiaryIndexWithPhone(this.phonenumber);
        ben = (Beneficiary) org.getBeneficiaryList().get(index);
        System.out.println("Καλησπέρα σας, καλώς ήλθατε " + ben.getName() + " από τον Οργανισμό: " + ben.getOrg().getName()); //dhmiourgia methodou getname/number //enarksh menu beneficiary
        System.out.println("1. Add Requests\n"+"2. Show Requests\n"+"3. Commit\n"+"4. Back\n"+"5. Logout\n"+"6. Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice;
        choice = scan.nextInt();
        switch(choice){
            case 1:
                addRequest(/*user*/);
                //beneficiaryMenu(ben);
                break;
            case 2:
                showRequests(/*user*/);
                beneficiaryMenu(ben);
                break;
            case 3: 
                //commit(user);
                beneficiaryMenu(ben);
                break;
            case 4:
                System.out.println("Main Menu:\n");
                beneficiaryMenu(ben);
                break;
            case 5:
            System.out.println("Logging out...\n");
                entermenu();
                break;
            case 6:
                System.out.println("Goodnight...\n");
                System.exit(0);
                break;
            default:
                break;

        }
    }

    public void addRequest(/*user*/){
        Scanner scan = new Scanner(System.in);
        int choice,choice1;
        double quan;
        System.out.println("Επιλέξτε τι θέλετε να ζητήσετε:");
        System.out.println("1. Material\n" + "2. Services\n");
        choice = scan.nextInt();
        if(choice==1){
            org.listEntities(1);
            System.out.println("Επιλέξτε αντικείμενο:");
            System.out.println("1.Milk 2.Sugar 3.Rice");
            choice1 = scan.nextInt();
            if(choice1==1){
                System.out.println("Επιλέξτε την ποσότητα που θα θέλατε:");
                quan=scan.nextDouble();
                //rd.RequestDonation(milk,quan);
            }
            else if(choice1==2){
                System.out.println("Επιλέξτε την ποσότητα που θα θέλατε:");
                quan=scan.nextDouble();
                //rd.RequestDonation(sugar,quan);
            }
            else if(choice1==3){
                System.out.println("Επιλέξτε την ποσότητα που θα θέλατε:");
                quan=scan.nextDouble();
                //rd.RequestDonation(rice,quan);
            }
            else{
                System.out.println("Επιστροφή στο μενού!");
                this.beneficiaryMenu(this.beneficiary);
            }
        }
        else if(choice==2){
            org.listEntities(0);
            System.out.println("Θέλετε να ζητήσετε;\n1. Ναι\n2. Όχι\n");
            choice1 = scan.nextInt();
            if(choice1==1){
                System.out.println("Επιλέξτε την υπηρεσία που θα θέλατε:");
                System.out.println("1.Medical Support 2.Nursery Support 3.Baby Sitting");
                choice1 = scan.nextInt();
                if(choice1==1){
                    System.out.println("Επιλέξτε τις ώρες που θα θέλατε:");
                    quan=scan.nextDouble();
                    //rd.RequestDonation(Medical Support,quan);
                }
                else if(choice1==2){
                    System.out.println("Επιλέξτε τις ώρες που θα θέλατε:");
                    quan=scan.nextDouble();
                    //rd.RequestDonation(Nursery Support,quan);
            }
                else if(choice1==3){
                    System.out.println("Επιλέξτε τις ώρες που θα θέλατε:");
                    quan=scan.nextDouble();
                    //rd.RequestDonation(Baby Sitting,quan);
            }
                
        }
            else {
                System.out.println("Επιστροφή στο μενού!");
                this.beneficiaryMenu(this.beneficiary);
            }
        }
        //user.getorg().listEntities(choice);//ektypwnei
        //choice = scan.nextInt();
        //user.getorg().getEntityInfo(choice);//ektypwnei? oxi, tha eprepe
        
        
    }

    public void showRequests(){
        
        Scanner scan = new Scanner(System.in);

        //requestdonationlist(user)?//Αρχικά εμφανίζεται αριθμημένη λίστα με τα RequestRequest??? που ζητάει ο Beneficiary,διαφορετικά μήνυμα ότι δεν έχει ζητήσεις αυτή τη στιγμή.
        System.out.println("Παρακαλώ είσάγετε το ID του αντικειμένου προς τρποποίηση:\n Αλλιώς πατήστε 0000 για να κανετε επιβεβαίωση ή -1 για διαγραφή όλλων.\n");
        int idRD = scan.nextInt();
        switch (idRD){
            case -1:
                //klhsh sunarthshs diagrafhs
            case 0000:
                //klhsh commit();
            default:
                System.out.println("1. Για διαγραφή μητρώου/2. Για τρποποίηση ποσότητας\n");
                int choice=-1;
                if(choice==1){
                    //klshsh sunarthshs diagrafhs entry
                }else{
                    //klhsh sunarthshs tropopoihshs modify()?
                }
        }
        



    }


    public void adminMenu(Admin adm) {

        System.out.println("Καλησπέρα σας, είστε ο διαχειρηστής του συστήματος, καλώς ήλθατε!");
        System.out.println("1. View\n"+"2. Monitor organization\n"+"3. Back\n"+"4. Logout\n"+"5. Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice;
        choice = scan.nextInt();
        switch(choice){
            case 1:
                view();
                //adminMenu();
                break;
            case 2:
                monitororganization();
                adminMenu(adm);
                break;
            case 3: 
                System.out.println("Main Menu:\n");
                //adminMenu();
                break;
            case 4:
                //logout
                entermenu();
                break;
            case 5:
                 System.out.println("Byeeeeee");
                 System.exit(0);
                break;
            default:
                break;

        }

    }

    public void view(/*user*/){
        System.out.println("Επιλέξτε ποια κατηγορία θέλετε να δείτε:");
        System.out.println("1. Material\n" + "2. Services\n");
        Scanner scan = new Scanner(System.in);
        int choice,choice1;
        choice = scan.nextInt();
        if(choice==1){
            org.listEntities(1);
            System.out.println("Θέλετε να επιστρέψετε στο μενού;");
            System.out.println("1.Ναι 2.Οχι");
            choice1=scan.nextInt();
            if(choice1==1){
                this.adminMenu(this.admin);
            }
            else if(choice1==2){
                System.out.println("Byeeeeeee");
            }
        }
        else if(choice==2){
            org.listEntities(0);
            System.out.println("Θέλετε να επιστρέψετε στο μενού;");
            System.out.println("1.Ναι 2.Οχι");
            choice1=scan.nextInt();
            if(choice1==1){
                this.adminMenu(this.admin);
            }
            else if(choice1==2){
                System.out.println("Byeeeeeee");
            }
        }
        else{
            System.out.println("Επιστροφή στο μενού!");
            this.adminMenu(this.admin);
        }
        
        
       
    }

    public void monitororganization() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. List Beneficiaries\n2. List Donators\n3. RESET Beneficiaries List\n4. Back\n");
        int choice,choice1;
        choice=scan.nextInt();
        switch (choice){
            case 1:
                //this.org.getBeneficiaryList();//Enai sth lista kai prosthetontai kai alla stoixeia olla pena
                adminBeneficiarySubmenu();
                break;
            case 2:
                //this.org.getDonatorList();
                adminDonatorSubmenu();
                break;
            case 3:
                //resetbeneficiarieslist();//prepei Για ΟΛΟΥΣ τους Beneficiaries γίνεται καθαρισμός του receivedList του κάθε ενός
                break;
            case 4:
                //adminMenu();
            default:
                //adminMenu();
                break;
        }

    }


        public void adminBeneficiarySubmenu(){

            Scanner scan= new Scanner(System.in);

            int indexchoice;
            int optionchoice;
            this.org.getBeneficiaryList();
            System.out.println("Παρακαλώ, επιλέξτε έναν επωφελούμενο:");
            indexchoice = scan.nextInt();
            org.getBeneficiaryList().get(indexchoice-1);
            System.out.println("Επιλέξατε τον χρήστη: " + org.getBeneficiaryList().get(indexchoice-1).getName());
            System.out.println("Παρακαλώ, επιλέξτε μια ενέργεια:");
            
            
            //Beneficiary ben = this.//assign chosen beneficiary to object so i can work on it
            System.out.println("1. Total Benefits Recieved\n2. CLEAR 'recieved' list\n3. DELETE Beneficiary\n");
            optionchoice = scan.nextInt();
            switch (optionchoice){
                case 1:
                    //totalBenefitsRecieved(/* ben*/);
                    break;
                case 2:
                    //cleanRecievedListOfBeneficiary(/*ben*/); prepei na uparei hdh kapou
                    break;
                case 3:
                    System.out.println("Είστε σίγουρος ότι θέλετε να διαγράψετε αυτό τον χρήστη; \n 1.Ναι 2.Οχι");
                    optionchoice=scan.nextInt();
                    if(optionchoice==1) { org.getBeneficiaryList().remove(indexchoice-1); org.getBeneficiaryList();}
                    else { System.out.println("Επιστροφή στο μενού!"); this.adminMenu(this.admin);}
                    break;
                default:
                    break;

            }

            //getDetailsByIndexDonatorList(int indexchoice-1)
            //adminMenu();

        }
    
        public void adminDonatorSubmenu(){
            Scanner scan= new Scanner(System.in);

            int indexchoice;
            int optionchoice;
            this.org.getDonatorList();
            System.out.println("Παρακαλώ, επιλέξτε έναν δωρητή:");
            indexchoice = scan.nextInt();
            org.getDonatorList().get(indexchoice-1);
            System.out.println("Επιλέξατε τον χρήστη: " + org.getDonatorList().get(indexchoice-1).getName());
            System.out.println("Παρακαλώ, επιλέξτε μια ενέργεια:");
            
            System.out.println("1. Total Benefits Recieved\n2. CLEAR 'recieved' list\n3. DELETE Beneficiary\n");
            optionchoice = scan.nextInt();
            
            switch (optionchoice){
                case 1:
                    //totalBenefitsRecieved(/* ben*/);
                    break;
                case 2:
                    //cleanRecievedListOfBeneficiary(/*ben*/); prepei na uparei hdh kapou
                    break;
                case 3:
                    System.out.println("Είστε σίγουρος ότι θέλετε να διαγράψετε αυτό τον χρήστη; \n 1.Ναι 2.Οχι");
                    optionchoice=scan.nextInt();
                    if(optionchoice==1) { org.getDonatorList().remove(indexchoice-1); org.getDonatorList();}
                    else { System.out.println("Επιστροφή στο μενού!"); this.adminMenu(this.admin);}
                    break;
                default:
                    break;

            }
        }
        

    }
