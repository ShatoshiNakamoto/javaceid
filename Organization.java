import java.util.*;

public class Organization {
    private String name;
    private Admin admin;
    private List<Entity> entityList;
    private ArrayList<Donator> donatorList;
    private List<Beneficiary> beneficiaryList;
    private List<RequestDonation> currentDonations;
    
    public Organization(String name) {
        this.name=name;
        this.entityList=new ArrayList<>();
        this.currentDonations=new ArrayList<>();
        this.donatorList= new ArrayList<>();
        this.beneficiaryList= new ArrayList<>();
    }
    
    // public void printLists(){
    //     for (Donator donator: donatorList){
    //         System.out.println(donator.getDonatorList());
    //     }
    // }

    public void addDonator(Donator dntr){
        if(this.donatorList.contains(dntr)) System.out.println("The Donator already exists!");
        else this.donatorList.add(dntr);
    }


    public void addInitial(Organization org){
        Donator don= new Donator("Tasos",456, org);
        Donator don1= new Donator("Diomudhs", 554, org);
        Beneficiary ben=new Beneficiary("Axilleas", 789, org);
        Beneficiary ben1=new Beneficiary("Petros", 887, org);

        this.donatorList.add(don);
        this.donatorList.add(don1);

        this.beneficiaryList.add(ben);
        this.beneficiaryList.add(ben1);
    }


    public void addBeneficiary(Beneficiary bnf){
        if(this.beneficiaryList.contains(bnf)) System.out.println("The Beneficiary already exists!");
        else this.beneficiaryList.add(bnf);

    }

    public List<Donator> getDonatorList(){
        System.out.println("\nDONATOR LIST");
        for(Donator donator: donatorList){
            System.out.println("Name: "+donator.getName()+"     PhoneNumber: "+donator.getPhone());
        }
        return this.donatorList;
    }

    public int checkList(int phonenum) {
        int flag=-1;
        for(Donator donator: donatorList){
            if (phonenum==donator.getPhone()) flag=2;
        }
        for(Beneficiary beneficiary: beneficiaryList){
            if (phonenum==beneficiary.getPhone()) flag=3;
        }
        return flag;
    }

    public int getIndexOfDonator(Donator don){
        int index=-1;
        for(Donator donator: donatorList){
            System.out.println(donator);
            // if(donator.getPhone()==don.getPhone()) {
               
            //index= donatorList.indexOf(donator);// GIATI CRASHAREI?
    
            // }
        }
        return index;
    }

    public List<Beneficiary> getBeneficiaryList(){
        System.out.println("\nBENEFICIARY LIST");
        for(Beneficiary beneficiary: beneficiaryList){
            System.out.println("Name: "+beneficiary.getName()+"     PhoneNumber: "+beneficiary.getPhone());
        }
        return this.beneficiaryList;
    }



    public int returnDonatorIndexWithPhone(int phone){
        int index=-1;
        for(Donator donator: donatorList){
            if (phone== donator.getPhone()) {
                index= donatorList.indexOf(donator) ;
            }
        }
        return index;
    }


    public int returnBeneficiaryIndexWithPhone(int phone){

        int index=-1;
        for(Beneficiary beneficiary: beneficiaryList){
            if (phone== beneficiary.getPhone()) {
                index= beneficiaryList.indexOf(beneficiary) ;
            }
        }
        return index;
    }

    public String getName(){
        return this.name;
        
    }
    
    public void setAdmin(Admin admin) {
        this.admin=admin;
    }
    
    public Admin getAdmin() {
        return this.admin;
    }

    public void addInList(Entity a){
        this.entityList.add(a);//error???
    }

    
    public void addEntity(Entity entity) {
        if(this.entityList.contains(entity)) System.out.println("The entity already exists!");
        else this.entityList.add(entity);
    }
    
    public void removeEntity(Entity entity) { //einai mono gia admin
         if(this.entityList.contains(entity)) this.entityList.remove(entity);
         else System.out.println("This entity does not exist!");
    }
    
    /*public void insertDonator(Donator donator) {
        if(this.donatorList.contains(donator)) System.out.println("The donator already exists!");
        else this.donatorList.add(donator);
    } */
    
    /* public void removeDonator(Donator donator) { 
         if(this.donatorList.contains(donator)) this.donatorList.remove(donator);
         else System.out.println("This donator does not exist!");
    } */
    
    /* public void insertBeneficiary(Beneficiary beneficiary) {
        if(this.beneficiaryList.contains(beneficiary)) System.out.println("The beneficiary already exists!");
        else this.beneficiaryList.add(beneficiary);
    } */
    
    /* public void removeBeneficiary(Beneficiary beneficiary) { 
         if(this.beneficiaryList.contains(beneficiary)) this.beneficiaryList.remove(beneficiary);
         else System.out.println("This beneficiary does not exist!");
    } */
    
    // public void listEntities() {
    //     List<Material> materialList=new ArrayList<>(); 
    //     List<Service> serviceList=new ArrayList<>();
        
    //     for(Entity entity: this.entityList){
    //         if(entity instanceof Material) materialList.add((Material)entity);
    //         else serviceList.add((Service)entity);
    //     }
        
    //     System.out.println("This list contains:");
    //     if(!materialList.isEmpty()) System.out.println("Material Objects!");
    //     if(!serviceList.isEmpty()) System.out.println("Service Objects!");
        
    //     System.out.println("Materials:");
    //     for(Material material: materialList){
    //         System.out.println(material.getEntityInfo());
    //     }
        
    //     System.out.println("Services:");
    //     for(Service service: serviceList){
    //         System.out.println(service.getEntityInfo());
    //     }
    // }
    

    public void listEntities(int choice) {
        List<Material> materialList=new ArrayList<>(); 
        List<Service> serviceList=new ArrayList<>();
    

        for(Entity entity: this.entityList){
            if(entity instanceof Material) materialList.add((Material)entity);
            else serviceList.add((Service)entity);
        }
        
        System.out.println("This list contains:");
        if((!materialList.isEmpty()) && choice==1) System.out.println("Material Objects!");
        if((!serviceList.isEmpty()) && choice!=1) System.out.println("Service Objects!");
        
        if (choice==1){
            System.out.println("Materials: ("+ materialList.size()+")\n");
                for(Material material: materialList)
                    System.out.println(material.getEntityInfo());
        }
        else{
            System.out.println("Services: ("+ serviceList.size()+")\n");
                for(Service service: serviceList){
                    System.out.println(service.getEntityInfo());
                }
        }

    }

    public void addToCurrentDonations(RequestDonation rd){
        this.currentDonations.add(rd);
    }

    public List<RequestDonation> getCurretnDonations(){
    return this.currentDonations;
    }

    public void printRequestDonationsList(){
        System.out.println(this.currentDonations);
    }
}