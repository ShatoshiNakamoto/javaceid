import java.util.*;

public class Service extends Entity {
    private List<Service> ServiceList;
    private double quantity;
    
    public Service(String name, double quantity, String description, int entityid) {
        this.setName(name);
        this.setDescription(description);
        this.setEntityid(entityid);
        this.quantity=quantity;
        this.ServiceList=new ArrayList<Service>();
    }

    public Service() {}

    public void addQuantity(double quan){

        this.quantity = this.quantity+quan;

    }

    public double getQuantity(){
        return this.quantity;
    }
    
    public List<Service> getServiceList(){
        return this.ServiceList;
    }

    public void addInList(Service a){
        this.ServiceList.add(a);
    }

    public String getDetails() {
        return "Object: Service";
    }
}