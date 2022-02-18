import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    //通用函数
    //ArrayLists
    private static ArrayList<ReiStaff> reiStaffs= new ArrayList<>();
    private static ArrayList<AppStaff> appStaffs= new ArrayList<>();
    private static HashMap<String,LineAuth> lineAuths=new HashMap<>();
    private static HashMap<String,ReiForm> reiForms=new HashMap<>();
    //下面是输入数据的函数
    private static void getDataRei(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("ReiStaff.txt"));
            String tmp="";
            while((tmp = br.readLine()) != null){
                String[] data=tmp.split(" ");//data array
                reiStaffs.add(new ReiStaff(data[0],data[1],data[2]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getDataApp(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("AppStaff.txt"));
            String tmp="";
            while((tmp = br.readLine()) != null){
                String[] data=tmp.split(" ");//data array
                appStaffs.add(new AppStaff(data[0],data[1],data[2],data[3]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getDataReiForm(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("ReiForm.txt"));
            String tmp="";
            while((tmp=br.readLine())!=null){
                String[] data=tmp.split(" ");
                reiForms.put(data[0],new ReiForm(data[0],data[1],data[2],data[3],data[4],data[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getDataLineAuth(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("LineAuth.txt"));
            String tmp="";
            while((tmp=br.readLine())!=null){
                String[] data=tmp.split(" ");
                lineAuths.put(data[0],new LineAuth(data[0],data[1],data[2],data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //以下是保存系统内容的函数
    private static void saveInfoToFiles(){
        for(int i=0;i<reiStaffs.size();i++){
            reiStaffs.get(i).saveInFile();
        }
        for(int i=0;i<appStaffs.size();i++){
            appStaffs.get(i).saveInFile();
        }
        for(ReiForm value:reiForms.values()){
            value.saveInFile();
        }
        for(LineAuth value:lineAuths.values()){
            value.saveInFile();
        }
    }
    //menus
    private static void welcome(){//主菜单
        System.out.println("欢迎使用财务报销管理系统,请输入你要执行的操作编号.");
        System.out.println("1.人员管理");
        System.out.println("2.报销管理");
        System.out.println("0.退出系统");
        System.out.print("请选择:");
        int temp=-1;
        while(true){
            Scanner scanner=new Scanner(System.in);
            temp=scanner.nextInt();
            if(temp!=1&&temp!=2&&temp!=0){
                System.out.println("输入不合法,请重新输入!");
            }
            else{
                break;
            }
        }
        if(temp==1){
            peopleManage();
        }
        else if(temp==2){
            reiManage();
        }
        else if(temp==0){
            saveInfoToFiles();
            System.exit(0);
        }
    }
    //以下是报销系统的内容
    private static void reiManage() {
        System.out.println("报销管理系统:");
        System.out.println("1.审批人额度授权表管理");
        System.out.println("2.报销单管理");
        System.out.println("0.返回上一层");
        System.out.println("请选择:");
        int temp = -1;
        while(true){
            Scanner scanner=new Scanner(System.in);
            temp=scanner.nextInt();
            if(temp!=1&&temp!=2&&temp!=0){
                System.out.println("输入不合法,请重新输入!");
            }
            else{
                break;
            }
        }
        if(temp==1){
            lineAuthManage();
        }
        else if(temp==2){
            reiFormManage();
        }
        else if(temp==0){
            welcome();
        }
    }
    //审批人额度授权表管理函数
    private static void lineAuthManage() {
        System.out.println("审批人额度授权表管理:");
        System.out.println("1.查询审批人额度授权表内容");
        System.out.println("2.修改审批人额度授权表内容");
        System.out.println("0.返回上一层");
        int temp = -1;
        while(true){
            Scanner scanner=new Scanner(System.in);
            temp=scanner.nextInt();
            if(temp!=1&&temp!=0&&temp!=2){
                System.out.println("输入不合法,请重新输入!");
            }
            else{
                break;
            }
        }
        if(temp==1){
            getLineAuthInfo();//todo：额度表内容好像不用cud吧
        }
        else if(temp==2){
            editLineAuthInfo();//todo
        }
        else if(temp==0){
            reiManage();
        }
    }
    //查询审批人额度授权表内容
    private static void getLineAuthInfo(){

    }
    //修改审批人额度授权表内容
    private static void editLineAuthInfo(){

    }
    //报销单管理
    private static void reiFormManage() {//todo:还没做完！
        System.out.println("报销单管理:");
        System.out.println("1.查看报销单列表");
        System.out.println("2.创建报销单");
        System.out.println("3.审批报销单");
        System.out.println("4.修改报销单");
        System.out.println("5.报销单据查询");
        System.out.println("0.返回上一层");
    }



    //以下是人员管理系统的内容!
    private static void peopleManage() {//人员管理系统
        System.out.println("人员管理系统:");
        System.out.println("1.报销人员管理");
        System.out.println("2.审批人员管理");
        System.out.println("0.返回上一层");
        System.out.println("请选择:");
        int temp = -1;
        while(true){
            Scanner scanner=new Scanner(System.in);
            temp=scanner.nextInt();
            if(temp!=1&&temp!=2&&temp!=0){
                System.out.println("输入不合法,请重新输入!");
            }
            else{
                break;
            }
        }
        if(temp==1){
            reiStaffManage();
        }
        else if(temp==2){
            appStaffManage();
        }
        else if(temp==0){
            welcome();
        }
    }
    //以下是报销人员的内容!
    private static void reiStaffManage(){//报销人员管理系统
        System.out.println("报销人员管理:");
        System.out.println("1.查询报销人员");
        System.out.println("2.增加报销人员");
        System.out.println("3.修改报销人员的信息");
        System.out.println("4.删除报销人员");
        System.out.println("0.返回上一层");
        int temp = -1;
        while(true){
            Scanner scanner=new Scanner(System.in);
            temp=scanner.nextInt();
            if(temp!=1&&temp!=2&&temp!=0&&temp!=3&&temp!=4){
                System.out.println("输入不合法,请重新输入!");
            }
            else{
                break;
            }
        }
        if(temp==1){
            getReiInfo();
        }
        else if(temp==2){
            addReiStaff();
        }
        else if(temp==3){
            editReiInfo();
        }
        else if (temp==4){
            deleteReiStaff();
        }else if(temp==0){
            peopleManage();
        }
    }
    //查询报销人员
    private static void getReiInfo(){//查询报销人员的信息
        System.out.println("报销人员的信息为:");
        for(int i=0;i<reiStaffs.size();i++){
            System.out.println("工号:"+reiStaffs.get(i).getId()+
                            " 姓名:"+reiStaffs.get(i).getName() +
                            " 手机号:"+reiStaffs.get(i).getPhoneNumber());
        }
        reiStaffManage();
    }
    //增加报销人员
    private static void addReiStaff(){//增加报销人员
        System.out.println("请输入增加报销人员的个数:");
        int temp=-1;
        Scanner scanner=new Scanner(System.in);
        temp=scanner.nextInt();
        for(int i=0;i<temp;i++) {
            System.out.println("请输入第"+(i+1)+"个人的工号:");
            Scanner scannerId=new Scanner(System.in);
            String id=scannerId.next();
            System.out.println("请输入第"+(i+1)+"个人的姓名:");
            String name=scannerId.next();
            System.out.println("请输入第"+(i+1)+"个人的手机号:");
            String phoneNumber=scannerId.next();
            reiStaffs.add(new ReiStaff(id,name,phoneNumber));
        }
        System.out.println("添加成功!即将返回上一层!");
        reiStaffManage();
    }
    //修改报销人员信息
    private static void editReiInfo(){//修改报销人员信息
        System.out.println("请输入需要修改的报销人员的工号:");
        String temp;
        Scanner scanner=new Scanner(System.in);
        temp=scanner.next();
        for(int i=0;i<reiStaffs.size();i++){
            if(reiStaffs.get(i).getId().equals(temp)){
                System.out.println("请输入"+temp+"的新姓名:");
                Scanner scannerId=new Scanner(System.in);
                String name=scannerId.next();
                System.out.println("请输入"+temp+"的新手机号:");
                String phoneNumber=scannerId.next();
                ReiStaff tempRei=new ReiStaff(temp,name,phoneNumber);
                reiStaffs.set(i,tempRei);
                System.out.println("修改成功!");
                reiStaffManage();
            }
        }
        System.out.println("查找失败,没有这个人!");
        reiStaffManage();
    }
    //删除报销人员
    private static void deleteReiStaff(){//删除报销人员
        System.out.println("请输入被删除的报销人员的工号:");
        String temp;
        Scanner scanner=new Scanner(System.in);
        temp=scanner.next();
        for(int i=0;i<reiStaffs.size();i++){
            if(reiStaffs.get(i).getId().equals(temp)){
                reiStaffs.remove(i);
                System.out.println("删除成功!");
                reiStaffManage();
            }
        }
        System.out.println("查找失败,没有这个人!");
        reiStaffManage();
    }
    //以下是审批人员的内容!
    //审批人员管理
    private static void appStaffManage(){//审批人员管理系统
        System.out.println("审批人员管理:");
        System.out.println("1.查询审批人员");
        System.out.println("2.增加审批人员");
        System.out.println("3.修改审批人员的信息");
        System.out.println("4.删除审批人员");
        System.out.println("0.返回上一层");
        int temp = -1;
        while(true){
            Scanner scanner=new Scanner(System.in);
            temp=scanner.nextInt();
            if(temp!=1&&temp!=2&&temp!=0&&temp!=3&&temp!=4){
                System.out.println("输入不合法,请重新输入!");
            }
            else{
                break;
            }
        }
        if(temp==1){
            getAppInfo();
        }
        else if(temp==2){
            addAppStaff();
        }
        else if(temp==3){
            editAppInfo();
        }
        else if (temp==4){
            deleteAppStaff();
        }else if(temp==0){
            peopleManage();
        }
    }
    //查询审批人员
    private static void getAppInfo(){
        //查询审批人员
        System.out.println("审批人员的信息为:");
        for(int i=0;i<appStaffs.size();i++){
            System.out.println("工号:"+appStaffs.get(i).getId()+
                    " 姓名:"+appStaffs.get(i).getName() +
                    " 手机号:"+appStaffs.get(i).getPhoneNumber()+
                    " 角色:"+appStaffs.get(i).getRole());
        }
        appStaffManage();
    }
    //增加审批人员
    private static void addAppStaff(){
        System.out.println("请输入增加审批人员的个数:");
        int temp=-1;
        Scanner scanner=new Scanner(System.in);
        temp=scanner.nextInt();
        for(int i=0;i<temp;i++) {
            System.out.println("请输入第"+(i+1)+"个人的工号:");
            Scanner scannerId=new Scanner(System.in);
            String id=scannerId.next();
            System.out.println("请输入第"+(i+1)+"个人的姓名:");
            String name=scannerId.next();
            System.out.println("请输入第"+(i+1)+"个人的手机号:");
            String phoneNumber=scannerId.next();
            System.out.println("请输入第"+(i+1)+"个人的角色:");
            String role=scannerId.next();
            appStaffs.add(new AppStaff(id,name,phoneNumber,role));
        }
        System.out.println("添加成功!即将返回上一层!");
        appStaffManage();
    }
    //修改审批人员信息
    private static void editAppInfo(){
        System.out.println("请输入需要修改的审批人员的工号:");
        String temp;
        Scanner scanner=new Scanner(System.in);
        temp=scanner.next();
        for(int i=0;i<appStaffs.size();i++){
            if(appStaffs.get(i).getId().equals(temp)){
                System.out.println("请输入"+temp+"的新姓名:");
                Scanner scannerId=new Scanner(System.in);
                String name=scannerId.next();
                System.out.println("请输入"+temp+"的新手机号:");
                String phoneNumber=scannerId.next();
                System.out.println("请输入"+temp+"的新角色:");
                String role=scannerId.next();
                AppStaff tempApp=new AppStaff(temp,name,phoneNumber,role);
                appStaffs.set(i,tempApp);
                System.out.println("修改成功!");
                appStaffManage();
            }
        }
        System.out.println("查找失败,没有这个人!");
        appStaffManage();
    }
    //删除审批人员
    private static void deleteAppStaff(){
        System.out.println("请输入被删除的审批人员的工号:");
        String temp;
        Scanner scanner=new Scanner(System.in);
        temp=scanner.next();
        for(int i=0;i<appStaffs.size();i++){
            if(appStaffs.get(i).getId().equals(temp)){
                appStaffs.remove(i);
                System.out.println("删除成功!");
                appStaffManage();
            }
        }
        System.out.println("查找失败,没有这个人!");
        appStaffManage();
    }
    //初始化
    public static void init(){
        getDataRei();
        getDataApp();
        getDataReiForm();
        getDataLineAuth();
    }
    //主函数
    public static void main(String argc[]){
        init();
        while(true){
            welcome();//主菜单什么的
        }
    }
}