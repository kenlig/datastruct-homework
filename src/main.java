import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static int flag=0;//未被加载过,flag=0;如果系统已经被加载过(回到主菜单),flag=1
    private static void getData(){

    }
    private static void welcome(){
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
            //报销管理
        }
        else if(temp==0){
            System.exit(0);
        }
    }

    private static void peopleManage() {
        System.out.println("人员管理系统:");
        System.out.println("1.报销人员管理");
        System.out.println("2.审批人员管理");
        System.out.println("0.返回主菜单");
        System.out.println("请选择:");
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
            //报销管理
        }
        else if(temp==0){
            return;
        }
    }

    public static void main(String argc[]){
        //TODO:读入相关内容
        getData();
        while(true){
            welcome();//主菜单什么的
        }

    }
}
/*这里是可变数组的代码
        ArrayList<Staff> s=new ArrayList<Staff>();
        for(int i=0;i<10;i++){
            s.add(new Staff(i+"","宇新","13012341234"));
        }
        for(int i=0;i<10;i++){
            s.get(i).saveInFile();
        }
带条件删除
        ArrayList<Staff> s=new ArrayList<Staff>();
        for(int i=0;i<10;i++){
            s.add(new Staff(i+"","宇新","13012341234"));
        }
        s.get(8).setId("---");
        for(int i=0;i<10;i++){
            if(s.get(i).getId()!="---") {
                s.get(i).saveInFile();
            }
            else {
                continue;
            }
        }

       try {
            BufferedReader br=new BufferedReader(new FileReader("ReiStaff.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        read d code
        */