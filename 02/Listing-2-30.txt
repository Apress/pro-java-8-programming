import java.io.*;

public class ShowStack {

    public static void main(String[] args) throws IOException {
        ShowStack ss = new ShowStack();
    }

    public ShowStack() throws IOException {
        initialize();
    }

    protected void initialize() throws IOException {
        readFileData();
    }

    protected void readFileData() throws IOException {
        File f = new File("test.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
    }

}
