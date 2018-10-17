import java.io.File;
import java.util.Scanner;

public class ListFiles {

    public static void listFiles(String path,int hypens){
        String hyphenString = getSeparatorString(hypens,'-');
        File directoryPath = new File(path);
        File[] files = directoryPath.listFiles();
        if(files==null || files.length==0)return;

        for(File i : files){
            System.out.print(hyphenString);
            if(i.isDirectory() && !i.isHidden() ){
                System.out.println(i.getName());
                listFiles(i.getAbsolutePath(),hypens+6);
            }else {
                System.out.println(i.getName());
            }
        }
        hypens = hypens - 6;
    }

    public static String getSeparatorString(int n , char c){
        StringBuilder s = new StringBuilder("");
        for(int i = 0;i<n;i++){
            s.append(c);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        listFiles(filename,6);
    }
}
