import java.io.File;
import java.util.Scanner;

public class ListFiles {
    public void Recursive(String name){
        File file = new File(name);
        File[] files = file.listFiles();
        if(files.length==0)return;
        for(int i=0;i<files.length;i++){
            System.out.println(files[i]);
            if(files[i].isDirectory() && !files[i].isHidden()){
                Recursive(files[i].toString());
            }
        }
        return ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        ListFiles lf = new ListFiles();
        lf.Recursive(filename);
    }
}
