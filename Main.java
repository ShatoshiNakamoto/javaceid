import java.util.*;

public class Main{
    //public static Organization org=new Organization("KRONOS");
    public static ArrayList<Integer> AdminPhone=new ArrayList();
    public static ArrayList<Integer> DonatorPhone=new ArrayList();
    public static ArrayList<Integer> BeneficiaryPhone=new ArrayList();
    


    
    
    

    public static void main(String[] args) {
        // Material mat=new Material();
        // Service ser=new Service(); 
        
        Organization org=new Organization("KRONOS");
        
        Admin adm=new Admin("Administrator","123",true);
       
        //Dhmiourgia antikeimenwn
        Material milk=new Material("Milk", 4.0, "boiii", 2.0, 4.0, 6.0, 001);
        org.addInList(milk);
        Material sugar=new Material("Sugar", 3, "damn son", 4, 8, 12, 002);
        org.addInList(sugar);
        Material rice=new Material("Rice", 2, "chinano1", 420, 69, 33, 003);
        org.addInList(rice);
        Service MedicalSupport=new Service("Medical Support", 20, "plisHelp", 101);
        org.addInList(MedicalSupport);
        Service NurserySupport=new Service("Nursery Support", 42, "verynice", 102);
        org.addInList(NurserySupport);
        Service BabySitting=new Service("Baby Sitting", 69, "juicybabe", 103);
        org.addInList(BabySitting);
        
         //Ektypwsh listwn gia elenxo leitourgias 
        org.listEntities();
        
        org.setAdmin(adm);
        
        
        App app2=new App(org);
        app2.entermenu();
        
        
        //Organization org=new Organization();
        //Material milk=new Material();
        //mat.addInList(milk);
        //Material sugar=new Material();
        //mat.getMaterialList().add(sugar);
        //Material rice=new Material();
        //mat.getMaterialList().add(rice);
        //Service MedicalSupport=new Service();
        //ser.getServiceList().add(MedicalSupport);
        //Service NurserySupport=new Service();
        //ser.getServiceList().add(NurserySupport);
        //Service BabySitting=new Service();
        //ser.getServiceList().add(BabySitting);
        //System.out.println(mat.getMaterialList());

        
        //Beneficiary ben1=new Beneficiary();
        //Beneficiary ben2=new Beneficiary();
        //Donator don=new Donator();
        
    }
}