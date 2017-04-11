/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusystem;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author YangLaptop
 */
public class MenuSystem extends Application {
    @Override
    public void start(Stage primaryStage) {
        Dish[] menulist = Menu.GetMenu();
        Scene[] scList = new Scene[menulist.length];
        for(int i=0; i<menulist.length;i++){
            scList[i] = new MenuPage(i,menulist[i].Name,menulist[i].Description,menulist[i].Price,menulist[i].ImagePath,scList, primaryStage).getScene();
        }
        
        
        primaryStage.setTitle("Explore dishes");
        primaryStage.setScene(scList[0]);
        primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
