import java.util.*;

public class Service extends Entity {
    private List<Service> ServiceList;
    
    public Service(String name, double quantity, String description, int entityid) {
        this.setName(name);
        this.setDescription(description);
        this.setEntityid(entityid);

        this.ServiceList=new ArrayList<Service>();
    }

    public Service() {}
    
    
    
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