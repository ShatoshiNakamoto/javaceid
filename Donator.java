public class Donator extends User {
    private Offers offersList;
    private String name;
    private int phone;
    private Organization org;
    
    public Donator(String name, int phone, Organization org){
        this.name=name;
        this.phone=phone;
        this.org=org;
        //Main.DonatorPhone.add(phone);
    }
    
    public Organization getOrg(){
        return this.org;
    }
    
    public int getPhone(){
        return this.phone;
    }
    
    public String getName(){
        return this.name;
    }
    /* private Material mat=new Material();
    private Service ser=new Service();
    private RequestDonation rd=new RequestDonation();
    
    public void addOffer(){
        System.out.println("1.Materials: \n" + mat.getMaterialList() + rd.setQuantity(100.0));
        System.out.println("2.Serveices: \n" + ser.getServiceList() + rd.setQuantity(100.0));
    } */
}