import java.io.File;
import java.util.Scanner;

public class ListFiles {

    public static void listFiles(String path,int hypens){
        File directoryPath = new File(path);
        File[] files = directoryPath.listFiles();
        if(files.length==0)return;

        for(File i : files){
            if(i.isDirectory() && !i.isHidden()){
                for(int j=0;j<hypens-6;j++) System.out.print("-");
                System.out.println(i.getName());
                listFiles(i.getAbsolutePath(),hypens+6);
            }else {
                for(int j=0;j<hypens-6;j++) System.out.print("-");
                System.out.println(i.getName());
            }
        }
        hypens = hypens - 6;
        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        listFiles(filename,6);
    }
}
