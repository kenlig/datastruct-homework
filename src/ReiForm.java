import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReiForm implements FileIO{
    private static int countNum=1000;
    private String id;
    private String reiStaff;
    private String money;
    private String reiDate;
    private int statusNum;
    private String appStaff;
    private String[] statusList={"NULL","创建","部门审批","财务审批","付款结束"};
    public ReiForm(){
        this.id="--------";
        this.reiStaff="---";
        this.money="----";
        this.appStaff="---";
        this.reiDate="--------";
        this.statusNum=0;
    }
    public ReiForm(String id,String reiStaff,String money,String reiDate,String status,String appStaff){
        this.id=id;
        this.reiStaff=reiStaff;
        this.money=money;
        this.reiDate=reiDate;
        for(int i=0;i<5;i++){
            if(status.equals(statusList[i])){
                this.statusNum=i;
                break;
            }
        }
        this.appStaff=appStaff;
    }
    public ReiForm(String reiStaff,String money,String reiDate){
        while(main.isReiForm(countNum)){
            countNum++;
        }
        String id="2022"+countNum;
        this.id=id;
        this.reiStaff=reiStaff;
        this.money=money;
        this.reiDate=reiDate;
        this.statusNum=1;
        this.appStaff=reiStaff;
    }
    public ReiForm(String id,String reiStaff,String money,String reiDate){
        this.id=id;
        this.reiStaff=reiStaff;
        this.money=money;
        this.reiDate=reiDate;
        this.statusNum=1;
        this.appStaff=reiStaff;
    }
    public int acceptReiForm(String id){
        if(statusNum>=1&&statusNum<=2) {
            statusNum++;
            this.appStaff=id;
            return 1;
        }
        return 0;
    }
    public int rejectReiForm(){
        statusNum=1;
        this.appStaff=reiStaff;
        return 1;
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
    public int getMoneyInt(){
        return Integer.parseInt(money);
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
        return statusList[statusNum];
    }

    public int getStatusNum() {
        return statusNum;
    }

    public void setReiDate(String reiDate) {
        this.reiDate = reiDate;
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
