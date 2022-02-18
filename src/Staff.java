import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Staff implements FileIO{
    private String id;
    private String name;
    private String phoneNumber;
    public Staff(){
        this.id="000";
        this.name="--";
        this.phoneNumber="13000000000";
    }
    public Staff(String id,String name,String phoneNumber){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void saveInFile(){
        String info=getId()+" "+getName()+" "+getPhoneNumber();
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("Staff.txt"));
            bw.write(info);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
