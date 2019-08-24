package in.geekofia.shelltest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellExecuter {

    Process process;
    StringBuffer output;

    public ShellExecuter() {
    }

    public String executer(String command){

        output = new StringBuffer();

        try{
            process = Runtime.getRuntime().exec("su -c " + command);
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line = "";

            while ((line = reader.readLine()) != null){
                output.append(line + "\n");
            }

            while ((line = errorReader.readLine()) != null){
                output.append(line + "\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return output.toString();
    }
}
