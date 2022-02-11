import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppStaff extends Staff implements FileIO{
    private String role;
    public AppStaff(){
        super();
        role="----";
    }
    public AppStaff(String id,String name,String phoneNumber,String role){
        super(id,name,phoneNumber);
        this.role=role;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
    @Override
    public void saveInFile() {
        String info=getId()+" "+getName()+" "+getPhoneNumber()+" "+getRole();
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("AppStaff.txt",true));
            bw.write(info);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
