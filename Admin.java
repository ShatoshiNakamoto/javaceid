public class Admin extends User {
    private boolean isTrue=true;
    private String name;
    private String phone;
    public Admin(String name, String phone, boolean isTrue){
        this.name=name;
        this.phone=phone;
        this.isTrue=isTrue;
    }

    public String getPhone(){
        return this.phone;
    }

    /* private Material mat=new Material();
    private Service ser=new Service();
    private RequestDonation rd=new RequestDonation();
    
    public void view() {
        System.out.println("1.Materials: \n" + mat.getMaterialList() + rd.setQuantity(100.0));
        System.out.println("2.Serveices: \n" + ser.getServiceList() + rd.setQuantity(100.0));
    } */
}