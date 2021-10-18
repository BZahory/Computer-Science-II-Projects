package p3_zahory_b_old;

public class NovaClass {

    String id, name, desc;

    public NovaClass(){
    }

    public NovaClass(String id){
        this.id = id;
        this.name = "";
        this.desc = "";
    }

    @Override
    public String toString() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }
}
