import java.util.*;

public class Beneficiary extends User {
    private int noPersons;
    private RequestDonationList receivedList;
    private Requests requestsList;
    private Organization org;
    private RequestDonationList rdl=new RequestDonationList();
    private Requests rq;
    private String name;
    private int phone;
    
    public Beneficiary(String name, int phone, Organization org) {
        this.name=name;
        this.phone=phone;
        this.org=org;
        this.rq = new Requests(this);
        this.noPersons=1;
        Main.BeneficiaryPhone.add(phone);
    }
    
    public String getName(){
        return this.name;
    }

    public int getPhone(){
        return this.phone;
    }
    
    public Organization getOrg(){
        return this.org;
    }
    
    public int setPersons(int persons){
        this.noPersons=persons;
        return persons;
    }
    
    public int getPersons(){
        return this.noPersons;
    }
    
    public RequestDonationList getReceivedList(){
        return this.receivedList;
    }
    
    /* public void addRequest1(Material mat) {
        if(org.getCurrentDonations().contains(mat));
        //getReceivedList().add(mat);
        }
    
    public void addRequest2(Service ser) {
        if(org.getCurrentDonations().contains(ser));
        //getReceivedList().add(mat);
        }    
    
    public List<RequestDonation> showRequests() {
        return rdl.getRdEntities(); */
    }
    
    /* public void commit() {
        rq.commit(RequestDonation(rd));
        
    }*/

