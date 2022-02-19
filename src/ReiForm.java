import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReiForm implements FileIO{
    private static int countNum=1000;
    private String id;
    private String reiStaff;
    private String money;
    private String reiDate;
    private String status;
    private String appStaff;
    public ReiForm(){
        this.id="--------";
        this.reiStaff="---";
        this.money="----";
        this.appStaff="---";
        this.reiDate="--------";
        this.status="---";
    }
    public ReiForm(String id,String reiStaff,String money,String reiDate,String status,String appStaff){
        this.id=id;
        this.reiStaff=reiStaff;
        this.money=money;
        this.reiDate=reiDate;
        this.status=status;
        this.appStaff=appStaff;
    }
    public ReiForm(String reiStaff,String money,String reiDate,String status,String appStaff){
        this.id="2022"+countNum;//自动生成编号
        countNum++;
        this.reiStaff=reiStaff;
        this.money=money;
        this.reiDate=reiDate;
        this.status=status;
        this.appStaff=appStaff;
    }
    public int getCountNum(){
        return countNum;
    }
    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppStaff() {
        return appStaff;
    }

    public String getMoney() {
        return money;
    }

    public String getReiDate() {
        return reiDate;
    }

    public void setAppStaff(String appStaff) {
        this.appStaff = appStaff;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getReiStaff() {
        return reiStaff;
    }

    public String getStatus() {
        return status;
    }

    public void setReiDate(String reiDate) {
        this.reiDate = reiDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReiStaff(String reiStaff) {
        this.reiStaff = reiStaff;
    }
    @Override
    public void saveInFile(){
        String info=getId()+" "+getReiStaff()+
                " "+getMoney()+ " "+getReiDate()+
                " "+getStatus()+ " "+getAppStaff();
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("ReiForm.txt",true));
            bw.write(info);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
