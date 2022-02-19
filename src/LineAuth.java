import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LineAuth implements FileIO{
    private static int countNum=1;
    private String id;
    private String role;
    private String money;
    private String appStaff;
    public LineAuth(){
        this.id="-";
        this.role="-";
        this.money="-";
        this.appStaff="-";
    }
    public LineAuth(String id,String role,String money,String appStaff){
        this.id=id;
        this.role=role;
        this.money=money;
        this.appStaff=appStaff;
    }
    public LineAuth(String role,String money,String appStaff){
        this.id=countNum+"";
        countNum++;
        this.role=role;
        this.money=money;
        this.appStaff=appStaff;
    }

    public static int getCountNum() {
        return countNum;
    }

    public String getMoney() {
        return money;
    }

    public String getAppStaff() {
        return appStaff;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void saveInFile(){
        String info=id+" "+role+" "+money+" "+appStaff;
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("LineAuth.txt",true));
            bw.write(info);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
