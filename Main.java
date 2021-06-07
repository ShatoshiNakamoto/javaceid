import java.util.*;

public class Main{
    public static ArrayList<Integer> AdminPhone=new ArrayList();
    public static ArrayList<Integer> DonatorPhone=new ArrayList();
    public static ArrayList<Integer> BeneficiaryPhone=new ArrayList();
    
    //methodos main
    public static void main(String[] args) {
        Organization org=new Organization("KRONOS");
        Donator don=new Donator();
        Beneficiary ben=new Beneficiary();
        Admin adm=new Admin("Administrator","123",true);
       
        //Dhmiourgia antikeimenwn
        Material milk=new Material("Milk", 5, "Mevgal", 2.0, 4.0, 6.0, 001);
        org.addInList(milk);
        don.addInList(milk);
        ben.addInList(milk);
        Material sugar=new Material("Sugar", 6, "Brown", 4, 8, 12, 002);
        org.addInList(sugar);
        don.addInList(sugar);
        ben.addInList(sugar);
        Material rice=new Material("Rice", 8, "China", 420, 69, 33, 003);
        org.addInList(rice);
        don.addInList(rice);
        ben.addInList(rice);
        Service MedicalSupport=new Service("Medical Support", 20, "Wounded", 101);
        org.addInList(MedicalSupport);
        don.addInList(MedicalSupport);
        ben.addInList(MedicalSupport);
        Service NurserySupport=new Service("Nursery Support", 40, "Ejections", 102);
        org.addInList(NurserySupport);
        don.addInList(NurserySupport);
        ben.addInList(NurserySupport);
        Service BabySitting=new Service("Baby Sitting", 60, "Babysitter", 103);
        org.addInList(BabySitting);
        don.addInList(BabySitting);
        ben.addInList(BabySitting);
        
        //pros8hkh antikeimenwn stis 3 listes 
        org.listEntities();
        org.listEntities1();
        org.listEntities2();
        
        //dhmiourgia enos admin
        org.setAdmin(adm);
        
        //dhmiourgia antikeimenou klashs App kai ekinnhsh efarmoghs
        App app2=new App(org);
        app2.entermenu();
    }
}