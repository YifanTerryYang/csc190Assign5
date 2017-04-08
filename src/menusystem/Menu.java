/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusystem;

import java.io.*;
import java.util.LinkedList;
/**
 *
 * @author YangLaptop
 */
public class Menu {
    protected static final String configPath = "config.txt";
    
    public static Dish[] GetMenu() {
        // This will reference one line at a time
        String line = null;
        Dish[] result = null;
        LinkedList<Dish> tmp = new LinkedList<Dish>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(configPath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            Dish t = null;
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
//                for (String a : line.split(":")){
//                    System.out.println("---" + a.trim());
//                }
                System.out.println(line);
                String key = line.split(":")[0].trim().toLowerCase();
                String value = "";
                try{ value = line.substring(line.indexOf(":")+1);}
                catch(ArrayIndexOutOfBoundsException ex){}
                
                switch (key) {
                    case "name":
                            t = new Dish(value);
                        break;
                    case "description":
                        t.setDesc(value);
                        break;
                    case "price":
                        t.setPrice(Double.parseDouble(value.replace("$", "")));
                        break;
                    case "image":
                        t.setImage(value.trim());
                        tmp.add(t);
                        break;
                    default:
                        break;
                }
            }   

            // Always close files.
            bufferedReader.close();
            
            result = tmp.toArray(new Dish[0]);
        }
        catch(FileNotFoundException ex) {
            result = new Dish[]{
                new Dish("Welcome!","We don't have dish for you, yet! Ask waiter for more information",-1,"default.jpg"),
            };
        }
        catch(IOException ex) {
            result = new Dish[]{
                new Dish("Welcome!","We don't have dish for you, yet! Ask waiter for more information",-1,"default.jpg"),
            };
        }
        
        return result;
    }
    
}
