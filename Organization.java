import java.util.*;

public class Organization {
    //metavlhtes
    private String name;
    private Admin admin;
    private List<Entity> entityList;
    private ArrayList<Donator> donatorList;
    private List<Beneficiary> beneficiaryList;
    private List<RequestDonationList> currentDonations;
    private Material mat;
    private Service ser;
    private Entity ent;
    private List<Material> materialList=new ArrayList<>(); 
    private List<Service> serviceList=new ArrayList<>();
    private List<Material> materialList1=new ArrayList<>(); 
    private List<Service> serviceList1=new ArrayList<>();
    private List<Material> materialList2=new ArrayList<>(); 
    private List<Service> serviceList2=new ArrayList<>();
    private double quantity=0;
    
    //constructor me orisma thn metavlhth name
    public Organization(String name) {
        this.name=name;
        entityList=new ArrayList<>();
        currentDonations=new ArrayList<>();
        this.donatorList= new ArrayList<>();
        this.beneficiaryList= new ArrayList<>();
    }
    
    //methodos gia na orizei thn metavlhth quantity
    public double showQuantity(double quan){
        return this.quantity=quan;
    }
    
    //methodos gia na epistrefei to onoma tou donator apo donatorList, to material apo thn materialList1 kai thn posothta pou dinw san orisma
    public void quantityOffered(int choice, int choice1, double quan){
        System.out.println(getDonatorList().get(choice).getName() + materialList1.get(choice1) + showQuantity(quan));
    }
    
    //methodos gia na epistrefei thn lista MaterialList1
    public List<Material> getMaterialList1(){
        return this.materialList1;
    }
    
    //methodos gia na epistrefei thn lista ServiceList
    public List<Service> getServiceList(){
        return this.serviceList1;
    }
    
    //methodos gia na epistrefei thn lista ServiceList1
    public List<Service> getServiceList1(){
        return this.serviceList1;
    }
    
    //methodos gia na epistrefei thn lista MaterialList2
    public List<Material> getMaterialList2(){
        return this.materialList2;
    }
    
    //methodos gia na epistrefei thn lista ServiceList2
    public List<Service> getServiceList2(){
        return this.serviceList2;
    }
    
    //methodos gia na epistrefei thn metavlhth quantity
    public double getQuantity(){
        return this.quantity;
    }
    
    //methodos gia na pros8etei sthn metavlhth quantity to orisma pou dinw
    public double addQuantity(double a){
        return this.quantity+=a;
    }
    
    //methodos gia na pros8etei sthn lista donatorList ton donator poy dinw san orsima, an aftos den uparxei hdh
    public void addDonator(Donator dntr){
        if(this.donatorList.contains(dntr)) System.out.println("The Donator already exists!");
        else this.donatorList.add(dntr);
    }
    
    //methodos gia na dhmiourghsw 2 donators kai 2 beneficiaries kai na tous pros8esw stiw antistoixes listes
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
    
    //methodos gia na pros8etei sthn lista beneficiaryList ton beneficiary poy dinw san orsima, an aftos den uparxei hdh
    public void addBeneficiary(Beneficiary bnf){
        if(this.beneficiaryList.contains(bnf)) System.out.println("The Beneficiary already exists!");
        else this.beneficiaryList.add(bnf);
    }
    
    //methodos gia na emfanizei ta onomata kai thlefwna twn donators apo thn donatorList
    public void showDonatorList(){
        System.out.println("\nDONATOR LIST");
        for(Donator donator: this.donatorList){
            System.out.println("Name: "+ donator.getName()+"     PhoneNumber: " + donator.getPhone());
        }
    }
    
    //methodos gia na epistrefei thn donatorList
    public List<Donator> getDonatorList(){
        return this.donatorList;
    }
    
    //methodos pou dinw san orisma thn metavlhth phonenum kai elegxei an uparxei stis 2 listes 
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
        }
        return index;
    }

    public void showBeneficiaryList(){
    System.out.println("\nBENEFICIARY LIST");
        for(Beneficiary beneficiary: beneficiaryList){
            System.out.println("Name: "+beneficiary.getName()+"     PhoneNumber: "+beneficiary.getPhone());
        }
    }

    public List<Beneficiary> getBeneficiaryList(){
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

    public void addQuantityMaterial(double quan, int choice1){
        materialList.get(choice1).addQuantity(quan);
    }
    
    public void addQuantityMaterial1(double quan, int choice1){
        materialList1.get(choice1).addQuantity1(quan);
    }

    public void addQuantityService(double quan, int choice1){
        serviceList.get(choice1).addQuantity(quan);
    }
    
    public void addQuantityMaterial2(double quan, int choice1){
        materialList2.get(choice1).addQuantity2(quan);
    }

    public void addQuantityService2(double quan, int choice1){
        serviceList2.get(choice1).addQuantity2(quan);
    }
    
    public double scanner(double quan){
        return this.quantity=quan;
    }
    
    public void checkRequest(double quan, int choice){
        Scanner scan = new Scanner(System.in);
        int x=10;
        double quantity=quan;
        while(getMaterialList().get(choice).getQuantity()<scanner(quan)){
            System.out.println("Η ποσότητα δεν είναι διαθέσιμη! Δώστε άλλη!");
            quan=scan.nextDouble();
        }
            System.out.println("Η ποσότητα που ζητάτε είναι διαθέσιμη!");
            addRequest(quan, choice);
            addQuantityMaterial2(quan, choice);
    }
    
    public void checkRequest1(double quan, int choice){
        Scanner scan = new Scanner(System.in);
        int x=10;
        double quantity=quan;
        while(getServiceList().get(choice).getQuantity()<scanner(quan)){
            System.out.println("Η ποσότητα δεν είναι διαθέσιμη! Δώστε άλλη!");
            quan=scan.nextDouble();
        }
            System.out.println("Η ποσότητα που ζητάτε είναι διαθέσιμη!");
            addRequest1(quan, choice);
            addQuantityService2(quan, choice);
    }
           
    public void addQuantityService1(double quan, int choice1){
        serviceList1.get(choice1).addQuantity1(quan);
    }
    
    public void addRequest(double quan, int choice){
        materialList.get(choice).removeQuantity(quan);
    }
    
    public void addRequest1(double quan, int choice){
        serviceList.get(choice).removeQuantity(quan);
    }
    
    public void deleteAll1(){
        for(Material material: this.materialList1)
            material.deleteQuantity();
    }
    
    public void deleteAll2(){
        for(Service service: this.serviceList1)
            service.deleteQuantity();
    }
    
    public void deleteAll3(){
        for(Material material: this.materialList2)
            material.deleteQuantity();
    }
    
    public void deleteAll4(){
        for(Service service: this.serviceList2)
            service.deleteQuantity();
    }
    
    public void deleteQuantity1(int choice1){
        materialList1.get(choice1-1).deleteQuantity();
    }
    
    public void deleteQuantity3(int choice1){
        materialList2.get(choice1-1).deleteQuantity();
    }
    
    public void setQuantity1(int choice1,double quan){
        materialList1.get(choice1-1).setQuantity1(quan);
    }
    
    public void setQuantity2(int choice1,double quan){
        serviceList1.get(choice1-1).setQuantity1(quan);
    }
    
    public void setQuantity3(int choice1,double quan){
        materialList2.get(choice1-1).setQuantity2(quan);
    }
    
    public void setQuantity4(int choice1,double quan){
        serviceList2.get(choice1-1).setQuantity2(quan);
    }
    
    public void deleteQuantity2(int choice1){
        serviceList1.get(choice1-1).deleteQuantity();
    }
    
    public void deleteQuantity4(int choice1){
        serviceList2.get(choice1-1).deleteQuantity();
    }
    
    public void addInList(Entity a){
        this.entityList.add(a);
    }

     public void addEntity(Entity entity) {
        if(this.entityList.contains(entity)) System.out.println("The entity already exists!");
        else this.entityList.add(entity);
    }
    
    public void removeEntity(Entity entity) { //einai mono gia admin
         if(this.entityList.contains(entity)) this.entityList.remove(entity);
         else System.out.println("This entity does not exist!");
    }
    
    public int returnMaterialListSize(){
        return materialList.size();
    }

    public int returnServiceListSize(){
        return this.materialList.size();
    }

    public void listEntities() {
        List<Material> materialList=new ArrayList<>(); 
        List<Service> serviceList=new ArrayList<>();

        for(Entity entity: this.entityList){
            if(entity instanceof Material) materialList.add((Material)entity);
            else serviceList.add((Service)entity);
        }
        this.materialList=materialList;
        this.serviceList=serviceList;
    }
    
    public List<Material> getMaterialList(){
        return this.materialList;
    }
    
    public void listEntities1() {
        List<Material> materialList1=new ArrayList<>(); 
        List<Service> serviceList1=new ArrayList<>();

        for(Entity entity: this.entityList){
            if(entity instanceof Material) materialList1.add((Material)entity);
            else serviceList1.add((Service)entity);
        }
        this.materialList1=materialList1;
        this.serviceList1=serviceList1;
    }
    
    public void listEntities2() {
        List<Material> materialList2=new ArrayList<>(); 
        List<Service> serviceList2=new ArrayList<>();

        for(Entity entity: this.entityList){
            if(entity instanceof Material) materialList2.add((Material)entity);
            else serviceList2.add((Service)entity);
        }
        this.materialList2=materialList2;
        this.serviceList2=serviceList2;
    }

    public void showListEntities(int choice){
        System.out.println("This list contains:");
        if((!this.materialList.isEmpty()) && choice==1) System.out.println("Material Objects!");
        if((!this.serviceList.isEmpty()) && choice!=1) System.out.println("Service Objects!");
        
        if (choice==1){
            System.out.println("Materials: ("+ materialList.size()+")\n");
                for(Material material: this.materialList)
                    System.out.println(material.getEntityInfo() + " Quantity: " + material.getQuantity());
        }
        else{
            System.out.println("Services: ("+ serviceList.size()+")\n");
                for(Service service: this.serviceList){
                    System.out.println(service.getEntityInfo() + " Quantity: " + service.getQuantity());
                }
        }
    }
    
    public void showListEntities1(int choice){
        List<Material> materialList1=new ArrayList<>(); 
        List<Service> serviceList1=new ArrayList<>();
        
        System.out.println("This list contains:");
        if((!this.materialList1.isEmpty()) && choice==1) System.out.println("Material Objects!");
        if((!this.serviceList1.isEmpty()) && choice!=1) System.out.println("Service Objects!");
        
        if (choice==1){
            System.out.println("Materials: (3)\n");
                for(Material material: this.materialList1)
                    System.out.println(material.getEntityInfo() + " Quantity: " + material.getQuantity1());
        }
        else{
            System.out.println("Services: (3)\n");
                for(Service service: this.serviceList1){
                    System.out.println(service.getEntityInfo() + " Quantity: " + service.getQuantity1());
                }
        }
    }
    
    public void showListEntities2(int choice){
        List<Material> materialList2=new ArrayList<>(); 
        List<Service> serviceList2=new ArrayList<>();
        
        System.out.println("This list contains:");
        if((!this.materialList2.isEmpty()) && choice==1) System.out.println("Material Objects!");
        if((!this.serviceList2.isEmpty()) && choice!=1) System.out.println("Service Objects!");
        
        if (choice==1){
            System.out.println("Materials: (3))\n");
                for(Material material: this.materialList2)
                    System.out.println(material.getEntityInfo() + " Quantity: " + material.getQuantity2());
        }
        else{
            System.out.println("Services: (3)\n");
                for(Service service: this.serviceList2){
                    System.out.println(service.getEntityInfo() + " Quantity: " + service.getQuantity2());
                }
        }
    }
}