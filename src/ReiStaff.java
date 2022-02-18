import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReiStaff extends Staff implements FileIO{
    public ReiStaff(){
        super();
    }
    public ReiStaff(String id,String name,String phoneNumber){
        super(id,name,phoneNumber);
    }
    @Override
    public void saveInFile(){
        String info=getId()+" "+getName()+" "+getPhoneNumber();
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("ReiStaff.txt"));
            bw.write(info);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
