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

    //constructo me orisma ton organismo
    public App(Organization org) {
        this.org=org;
    }

    //methodos gia ekinnhsh menu
    public void entermenu(){
        if(this.itteration==0){
            org.addInitial(org);//Prosthesh arxikwn xrhstwn sthn lista
            this.itteration=this.itteration+1;
            System.out.println("Admin    PhoneNumber: 123");
            org.showDonatorList();
            org.showBeneficiaryList();
        }

        this.org.getDonatorList();
        this.org.getBeneficiaryList();
        this.phonenumber=checkuser();

        int isuser=checkuserlist(this.phonenumber);
        
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
    
    //methodos gia eggrafh xrhsth an den einai hdh melos
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
    }

    //methodos gia na eisageis ari8mo thlefwnou kai an eisai melos eiserxesai sto susthma
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
        return phonenumber;
    }
    
    //output1->Admin
    //output2->Donator
    //output3->Beneficiary
    //output-1->Not registered
    public int checkuserlist(int phonenum){
        int flag;
        if(("123").equals(Integer.toString(phonenum)))
            flag=1;
        else {
            flag= org.checkList(phonenum);
        }
     return flag;
    }

    //menu donator
    public void donatorMenu(Donator don) {

        int index = org.returnDonatorIndexWithPhone(this.phonenumber);
        don = (Donator) org.getDonatorList().get(index);
        System.out.println("\nΚαλησπέρα σας, καλώς ήλθατε " +   don.getName() + " από τον Οργανισμό: " + don.getOrg().getName()); 
        System.out.println("\n1.Add Offer\n"+"2. Show Offers\n" + " 3.Logout\n"+ "4.Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice;
        choice = scan.nextInt();
        switch(choice){
            case 1:
                addoffer();
                break;
            case 2:
                showoffers();
                donatorMenu(don);
                break;
           case 3:
                entermenu();
                break;
            case 4:
                System.out.println("Byeeeeeee");    
                System.exit(0);
                break;
            default:
                break;

        }
    }
    
    //methodos gia na pros8etei mia prosfora tou donator
    public void addoffer(){
        Scanner scan = new Scanner(System.in);
        int choice,choice1,choice2,choice3;
        double quan;
        System.out.println("1. Material\n" + "2. Services\n" + " (Άλλο) Επιστροφή στο μενού");
        choice = scan.nextInt();
        
        if(choice==1) {
            org.showListEntities(1);
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
                    this.org.addQuantityMaterial1(quan, choice1-1);
                    this.donatorMenu(this.donator);
                }
                else if(choice1==2){
                    System.out.println("Εισάγετε την ποσότητα που θέλετε να προσφέρετε:");
                    quan = scan.nextDouble();
                    this.org.addQuantityMaterial(quan, choice1-1);
                    this.org.addQuantityMaterial1(quan, choice1-1);
                    this.donatorMenu(this.donator);
                }
                else if(choice1==3){
                    System.out.println("Εισάγετε την ποσότητα που θέλετε να προσφέρετε:");
                    quan = scan.nextDouble();
                    this.org.addQuantityMaterial(quan, choice1-1);
                    this.org.addQuantityMaterial1(quan, choice1-1);
                    this.donatorMenu(this.donator);
                }
                else {
                    System.out.println("Επιστροφή στο μενού!"); 
                    this.donatorMenu(this.donator);
                }
            }
        else if(choice==2){
            System.out.println("Επιστροφή στο μενού!");
            this.donatorMenu(this.donator);
            }
        else {
            System.out.println("Επιστροφή στο μενού!"); 
            this.donatorMenu(this.donator);
        }
    }
        
                
        else if(choice==2) {
            org.showListEntities(0);
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
                        this.org.addQuantityService1(quan, choice1-1);
                        this.donatorMenu(this.donator);
                    }
                    else if(choice1==2){
                        System.out.println("Εισάγετε τις ώρες που θέλετε να προσφέρετε:");
                        quan = scan.nextDouble();
                        this.org.addQuantityService(quan, choice1-1);  
                        this.org.addQuantityService1(quan, choice1-1);
                        this.donatorMenu(this.donator);
                    }
                    else if(choice1==3){
                        System.out.println("Εισάγετε τις ώρες που θέλετε να προσφέρετε:");
                        quan = scan.nextDouble();
                        this.org.addQuantityService(quan, choice1-1); 
                        this.org.addQuantityService1(quan, choice1-1);
                        this.donatorMenu(this.donator);
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
        else this.donatorMenu(this.donator);
    }
    
    //methodos gia na emfanizei tis prosfores twn donators
    public void showoffers(){
        Scanner scan = new Scanner(System.in);
        int choice1,indexchoice;
        double quan;

        //Αρχικά εμφανίζεται αριθμημένη λίστα με τα RequestDonation που προσφέρει ο Donator,διαφορετικά μήνυμα ότι δεν έχει προσφορές αυτή τη στιγμή.
        org.showListEntities1(1);
        org.showListEntities1(0);
        System.out.println("1.Materials 2.Services 3.Διαγραφή όλων των παροχών 4.Μενού");
        choice1=scan.nextInt();
        if(choice1==1) {
            System.out.println("Παρακαλώ είσάγετε το ID του αντικειμένου προς τροποποίηση:");
            indexchoice = scan.nextInt();
            org.getMaterialList1().get(indexchoice-1);
            System.out.println("Τι θα θέλατε να κάνετε σε αυτό το αντικείμενο;");
            System.out.println("1.Διαγραφή παροχής 2.Τροποποίηση ποσότητας");
            choice1=scan.nextInt();
            
            switch (choice1){
            case 1:
                org.deleteQuantity1(choice1);
                break;
            case 2:
                System.out.println("Πληκτρολογήστε την νέα ποσότητα:");
                quan=scan.nextDouble();
                org.setQuantity1(indexchoice,quan);
                org.addQuantityMaterial(quan, indexchoice-1);
                break;
            default:
                break;
        }
        }
        else if(choice1==2) {
            System.out.println("Παρακαλώ είσάγετε το ID του αντικειμένου προς τροποποίηση:");
            indexchoice = scan.nextInt();
            org.getServiceList1().get(indexchoice-1);
            System.out.println("Τι θα θέλατε να κάνετε σε αυτή την υπηρεσία;");
            System.out.println("1.Διαγραφή παροχής 2.Τροποποίηση ποσότητας");
            choice1=scan.nextInt();
            
            switch (choice1){
            case 1:
                org.deleteQuantity2(choice1);
                break;
            case 2:
                System.out.println("Πληκτρολογήστε την νέα ποσότητα:");
                quan=scan.nextDouble();
                org.setQuantity2(indexchoice,quan);
                org.addQuantityService(quan, indexchoice-1);
                break;
            default:
                break;
        }
        }
        else if(choice1==3){
            org.deleteAll1();
           org.deleteAll2();
        }
        
        else { System.out.println("Επιστροφή στο μενού!"); this.donatorMenu(this.donator);}
    }

    //menu beneficiary
    public void beneficiaryMenu(Beneficiary ben) { 
        int index = org.returnBeneficiaryIndexWithPhone(this.phonenumber);
        ben = (Beneficiary) org.getBeneficiaryList().get(index);
        System.out.println("Καλησπέρα σας, καλώς ήλθατε " + ben.getName() + " από τον Οργανισμό: " + ben.getOrg().getName());
        System.out.println("1. Add Requests\n"+"2. Show Requests\n" + " 3.Logout\n" +  "4.Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice;
        choice = scan.nextInt();
        switch(choice){
            case 1:
                addRequest();
                break;
            case 2:
                showRequests();
                beneficiaryMenu(ben);
                break;
            case 3:
            System.out.println("Logging out...\n");
                entermenu();
                break;
            case 4:
                System.out.println("Goodnight...\n");
                System.exit(0);
                break;
            default:
                break;

        }
    }
    
    //methodos gia na pros8etei aithmata apo beneficiary
    public void addRequest(){
        Scanner scan = new Scanner(System.in);
        int choice,choice1;
        double quan;
        System.out.println("Επιλέξτε τι θέλετε να ζητήσετε:");
        System.out.println("1. Material\n" + "2. Services\n" + "(Άλλο) Επιστροφή στο μενού");
        choice = scan.nextInt();
        if(choice==1){
            org.showListEntities(1);
            System.out.println("Επιλέξτε αντικείμενο:");
            System.out.println("1.Milk 2.Sugar 3.Rice");
            choice1 = scan.nextInt();
            if(choice1==1){
                System.out.println("Επιλέξτε την ποσότητα που θα θέλατε:");
                quan=scan.nextDouble();
                org.checkRequest(quan, choice1-1);
                this.beneficiaryMenu(this.beneficiary);
            }
            else if(choice1==2){
                System.out.println("Επιλέξτε την ποσότητα που θα θέλατε:");
                quan=scan.nextDouble();
                org.checkRequest(quan, choice1-1);
                this.beneficiaryMenu(this.beneficiary);
            }
            else if(choice1==3){
                System.out.println("Επιλέξτε την ποσότητα που θα θέλατε:");
                quan=scan.nextDouble();
                org.checkRequest(quan, choice1-1);
                this.beneficiaryMenu(this.beneficiary);
            }
            else{
                this.beneficiaryMenu(this.beneficiary);
            }
        }
        else if(choice==2){
            org.showListEntities(0);
            System.out.println("Θέλετε να ζητήσετε;\n1. Ναι\n2. Όχι\n" + " (Άλλο) Επιστροφή στο μενού");
            choice1 = scan.nextInt();
            if(choice1==1){
                System.out.println("Επιλέξτε την υπηρεσία που θα θέλατε:");
                System.out.println("1.Medical Support 2.Nursery Support 3.Baby Sitting" + "(Άλλο) Επιστροφή στο μενού");
                choice1 = scan.nextInt();
                if(choice1==1){
                    System.out.println("Επιλέξτε τις ώρες που θα θέλατε:");
                    quan=scan.nextDouble();
                    org.checkRequest1(quan, choice1-1);
                    this.beneficiaryMenu(this.beneficiary);
                }
                else if(choice1==2){
                    System.out.println("Επιλέξτε τις ώρες που θα θέλατε:");
                    quan=scan.nextDouble();
                    org.checkRequest1(quan, choice1-1);
                    this.beneficiaryMenu(this.beneficiary);
                }
                else if(choice1==3){
                    System.out.println("Επιλέξτε τις ώρες που θα θέλατε:");
                    quan=scan.nextDouble();
                    org.checkRequest1(quan, choice1-1);
                    this.beneficiaryMenu(this.beneficiary);
                }
            }
            else {
                this.beneficiaryMenu(this.beneficiary);
            }
        }
    }

    //methodos gia na emfanizei ta aithmata
    public void showRequests(){
        Scanner scan = new Scanner(System.in);
        int choice1,indexchoice;
        double quan;
        
        org.showListEntities2(1);
        org.showListEntities2(0);
        System.out.println("1.Materials 2.Services 3.Διαγραφή όλων των αιτημάτων 4.Μενού");
        choice1=scan.nextInt();
        if(choice1==1) {
            System.out.println("Παρακαλώ είσάγετε το ID του αντικειμένου προς τροποποίηση:");
            indexchoice = scan.nextInt();
            org.getMaterialList2().get(indexchoice-1);
            System.out.println("Τι θα θέλατε να κάνετε σε αυτό το αντικείμενο;");
            System.out.println("1.Διαγραφή παροχής 2.Τροποποίηση ποσότητας");
            choice1=scan.nextInt();
            
            switch (choice1){
            case 1:
                org.deleteQuantity3(choice1);
                
                break;
            case 2:
                System.out.println("Πληκτρολογήστε την νέα ποσότητα:");
                quan=scan.nextDouble();
                org.setQuantity3(indexchoice,quan);
                org.addRequest(quan, indexchoice-1);
                break;
            default:
                break;
        }
        }
        else if(choice1==2) {
            System.out.println("Παρακαλώ είσάγετε το ID του αντικειμένου προς τροποποίηση:");
            indexchoice = scan.nextInt();
            org.getServiceList2().get(indexchoice-1);
            System.out.println("Τι θα θέλατε να κάνετε σε αυτή την υπηρεσία;");
            System.out.println("1.Διαγραφή παροχής 2.Τροποποίηση ποσότητας");
            choice1=scan.nextInt();
            
            switch (choice1){
            case 1:
                org.deleteQuantity4(choice1);
                break;
            case 2:
                System.out.println("Πληκτρολογήστε την νέα ποσότητα:");
                quan=scan.nextDouble();
                org.setQuantity4(indexchoice,quan);
                org.addRequest(quan, indexchoice-1);
                break;
            default:
                break;
        }
        }
        else if(choice1==3){
            org.deleteAll3();
            org.deleteAll4();
        }
        
        else { System.out.println("Επιστροφή στο μενού!"); this.beneficiaryMenu(this.beneficiary);}
    }

    //menu admin
    public void adminMenu(Admin adm) {
        System.out.println("Καλησπέρα σας, είστε ο διαχειρηστής του συστήματος, καλώς ήλθατε!");
        System.out.println("1. View\n"+"2. Monitor organization\n"+"3. Logout\n"+"4. Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice;
        choice = scan.nextInt();
        switch(choice){
            case 1:
                view();
                break;
            case 2:
                monitororganization();
                adminMenu(adm);
                break;
            case 3: 
                entermenu();
                break;
            case 4:
                 System.out.println("Byeeeeee");
                 System.exit(0);
                break;
            default:
                break;
        }
    }

    //methodos gia na emfanizei ta materials h ta services
    public void view(){
        System.out.println("Επιλέξτε ποια κατηγορία θέλετε να δείτε:");
        System.out.println("1. Material\n" + "2. Services\n");
        Scanner scan = new Scanner(System.in);
        int choice,choice1;
        choice = scan.nextInt();
        if(choice==1){
            org.showListEntities(1);
            System.out.println("Θέλετε να επιστρέψετε στο μενού;");
            System.out.println("1.Ναι 2.Οχι");
            choice1=scan.nextInt();
            if(choice1==1){
                this.adminMenu(this.admin);
            }
            else if(choice1==2){
                System.out.println("Byeeeeeee");
                System.exit(0);
            }
        }
        else if(choice==2){
            org.showListEntities(0);
            System.out.println("Θέλετε να επιστρέψετε στο μενού;");
            System.out.println("1.Ναι 2.Οχι");
            choice1=scan.nextInt();
            if(choice1==1){
                this.adminMenu(this.admin);
            }
            else if(choice1==2){
                System.out.println("Byeeeeeee");
                System.exit(0);
            }
        }
        else{
            System.out.println("Επιστροφή στο μενού!");
            this.adminMenu(this.admin);
        }
        
    }

    //methodos gia na emfanizei tis parakatw epiloges
    public void monitororganization() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Λίστα επωφελούμενων \n 2.Λίστα δωρητών\n 3.Καθαρισμός επωφελούμενης λίστας \n 4.Back\n");
        int choice,choice1;
        choice=scan.nextInt();
        switch (choice){
            case 1:
                adminBeneficiarySubmenu();
                break;
            case 2:
                adminDonatorSubmenu();
                break;
            case 3:
                org.deleteAll3();
                org.deleteAll4();
                break;
            case 4:
                this.adminMenu(this.admin);
                break;
            default:
                break;
        }
    }

    //upomenou beneficiary gia na kanei se afto energeies o admin
    public void adminBeneficiarySubmenu(){

        Scanner scan= new Scanner(System.in);

        int indexchoice;
        int optionchoice;
            
        this.org.showBeneficiaryList();
        System.out.println("Παρακαλώ, επιλέξτε έναν επωφελούμενο:");
        indexchoice = scan.nextInt();
        org.getBeneficiaryList().get(indexchoice-1);
        System.out.println("Επιλέξατε τον χρήστη: " + org.getBeneficiaryList().get(indexchoice-1).getName());
        System.out.println("Παρακαλώ, επιλέξτε μια ενέργεια:");
            
        System.out.println("1.Συνολικά ωφέλη που έχουν παρθεί\n 2.Καθαρισμός λίστας \n 3.Διαγραφή επωφελούμενου\n");
        optionchoice = scan.nextInt();
        switch (optionchoice){
            case 1:
                org.showListEntities2(1);
                org.showListEntities2(0);
                 break;
            case 2:
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
    }
    
    //upomenou donator gia na kanei se afto energeies o admin
    public void adminDonatorSubmenu(){
        Scanner scan= new Scanner(System.in);

        int indexchoice;
        int optionchoice;
            
        this.org.showDonatorList();
        System.out.println("Παρακαλώ, επιλέξτε έναν δωρητή:");
        indexchoice = scan.nextInt();
        org.getDonatorList().get(indexchoice-1);
        System.out.println("Επιλέξατε τον χρήστη: " + org.getDonatorList().get(indexchoice-1).getName());
        System.out.println("Παρακαλώ, επιλέξτε μια ενέργεια:");
            
        System.out.println("1.Συνολική προσφερόμενη ποσότητα\n 2.Διαγραφή δωρητή");
        optionchoice = scan.nextInt();
            
        switch (optionchoice){
            case 1:
                org.showListEntities1(1);
                org.showListEntities1(0);
                break;
            case 2:
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