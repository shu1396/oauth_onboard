import java.io.*;
import java.util.Scanner;

public class CountLines {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        for(int i=0;i<args.length;i++) {
            String fileName = args[i];
            int lineCount = 0;
            File file = new File(fileName);
            try (FileReader fr = new FileReader(file)) {
                /*int ch;
                while((ch=fr.read())!=-1){
                    if((char)ch=='\n')lineCount++;
                    //System.out.print((char)ch);
                }*/
                BufferedReader bufferReader = new BufferedReader(fr);
                while(bufferReader.readLine()!=null){
                    lineCount++;
                }
                System.out.println();
                lineCount++;
                System.out.println("FileName :" +fileName+ "  :" + lineCount);
            } catch (IOException ex){
                System.out.println("Caught Exception:" + ex);
            }
        }
    }
}
