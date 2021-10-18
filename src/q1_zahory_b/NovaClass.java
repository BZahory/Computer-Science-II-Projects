package q1_zahory_b;

public class NovaClass {

    String id, name, desc;

    public NovaClass(){
    }

    public NovaClass(String id, String name, String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + desc;
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
