import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppStaff extends Staff implements FileIO{
    private String role;
    private int permission;//为1则为部门,2为财务
    public AppStaff(){
        super();
        role="----";
    }
    public AppStaff(String id,String name,String phoneNumber,String role){
        super(id,name,phoneNumber);
        this.role=role;
        if(role.equals("部门副主管")||role.equals("部门主管")){
            permission=1;
        }
        else if(role.equals("财务副主管")||role.equals("财务主管")){
            permission=2;
        }
        else permission=0;
    }
    public void setRole(String role){
        this.role=role;
    }
    public int getPermission(){
        return permission;
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
