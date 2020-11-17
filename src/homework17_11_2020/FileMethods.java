package homework17_11_2020;

import java.io.*;
public class FileMethods {

    // creating new file withouts ??? and swaping i and yota signs
    public void repairFile (String fileName){
        BufferedReader reader;
        try{
            if(!new File(fileName).exists()){ // vytvoril novu triedu s názvom
                System.out.println("problem: file "+ fileName + " does not exist!!");
                return;
            }
            FileReader fr = new FileReader(fileName);
            File file = new File("outputs/repairedFile.txt");
            file.createNewFile(); // vytvorenie noveho filu na defaultnom mieste

            FileWriter fw = new FileWriter(file); // otvorenie filu pre zapisovanie
            reader = new BufferedReader(fr);
            int c ;
            while((c = reader.read()) != -1)         //Read char by Char
            {
                char character = (char) c;          //converting integer to char

                // looking for i,I,y,Y and swaping them, plus deleting ?????????
                switch (character){
                    case 73: character=89; fw.write(character); break;
                    case 89: character=73; fw.write(character); break;
                    case 105: character=121; fw.write(character); break;
                    case 121: character=105; fw.write(character); break;
                    case 63: fw.flush(); break;
                    default: fw.write(character);
                }
            }
            fr.close();
            fw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
