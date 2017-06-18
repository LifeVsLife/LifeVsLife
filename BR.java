
//author: Moritz Höcker, Jonas Reichert
//date: 08.05.2017
//ver: 0.0.1

import java.io.*;
public class BR
{

    String path;
    public BR()
    {
        path = "I:/Schüler/Q11_Informatik/tester.txt";  //hier dateipfad ändern
    }

    public void writer(String text)
    {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file, false); //false überschreibt true addiert
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(this.getClass().getName());
        }
    }

    public String reader()
    {
        try {

            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);

            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while((line = br.readLine()) != null)
            {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            br.close();
            //return line;
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println(this.getClass().getName());
            return null;
        }
     }
 }
