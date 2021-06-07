public class Admin extends User {
    private boolean isTrue=true;
    private String name;
    private String phone;
    
    //constructor 
    public Admin(String name, String phone, boolean isTrue){
        this.name=name;
        this.phone=phone;
        this.isTrue=isTrue;
    }
    
    //methodos gia na epistrefei thn metavlhth phone
    public String getPhone(){
        return this.phone;
    }
    
    //methodos gia na epistrefei thn metavlhth name
    public String getName(){
        return this.name;
    }
}