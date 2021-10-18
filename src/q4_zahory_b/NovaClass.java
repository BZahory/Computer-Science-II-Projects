package q4_zahory_b;

import java.util.Comparator;

public class NovaClass implements Comparator, Comparable<NovaClass> {

    String id, name, desc;

    public NovaClass(){
    }

    public NovaClass(String id){
        this.id = id;
        this.name = "";
        this.desc = "";
    }

    public NovaClass(String id, String name, String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.name.replaceAll("[^0-9]", "") +
                "|" +
                this.name.replaceAll("[0-9]", "") +
                this.desc + "|"+
                this.id;
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

    @Override
    public int compare(Object o, Object t1) {
        String[] oSpl, tSpl;
        oSpl = o.toString().split("\\|");
        tSpl = t1.toString().split("\\|");

        if(Integer.parseInt(oSpl[0]) == Integer.parseInt(tSpl[0]))
            return compareHelper(oSpl[1].toLowerCase(),tSpl[1].toLowerCase());
        else if(Integer.parseInt(oSpl[0]) < Integer.parseInt(tSpl[0]))
            return -1;
        else
            return 1;
    }

    @Override
    public int compareTo(NovaClass novaClass) {
        return compare(this, novaClass);
    }

    public int compareHelper(String x, String y){
        if((int)x.charAt(0)<(int)y.charAt(0))
            return -1;
        else if ((int)x.charAt(0)<(int)y.charAt(0))
            return 1;
        else
            if(x.length()>1&&y.length()>1)
                return compareHelper(x.substring(1),y.substring(1));
            else if(x.length()==1)
                return -1;
            else
                return 1;
    }
}
