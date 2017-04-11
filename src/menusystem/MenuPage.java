/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusystem;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author YangLaptop
 */
public class MenuPage {
    protected GridPane gpane = new GridPane();
    protected Scene scene = null;
    protected int id = -1;
    protected Scene[] sclist = null;
    protected Stage st = null;
    
    public GridPane getPane(){ return gpane;}
    public Scene getScene(){ return scene;}
    
    public MenuPage(int Dishid, String name, String desc, double price, String imgPath, Scene[] sc, Stage stage){
        id = Dishid;
        st = stage;
        sclist = sc;
        // Prev Button
        Button prebtn = new Button();
        prebtn.setMinWidth(80.0);
        prebtn.setPrefWidth(80.0);
        prebtn.setMaxWidth(80.0);
        prebtn.setText("< Prev");
        prebtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(id-1 >=0){
                    st.setScene(sclist[id-1]);
                }
            }
        });
        
        // Next Button
        Button nextbtn = new Button();
        nextbtn.setMinWidth(80.0);
        nextbtn.setPrefWidth(80.0);
        nextbtn.setMaxWidth(80.0);
        nextbtn.setText("Next >");
        nextbtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(id+1 < sclist.length){
                    st.setScene(sclist[id+1]);
                }
                
            }
        });
        
        // Name Label
        Label namelabel = new Label(name);
        namelabel.setWrapText(true);
        
        // Description Label
        Label deslabel = new Label(desc);
        deslabel.setWrapText(true);
        deslabel.setStyle("-fx-font-size: 15px;");
        
        // Price Label
        Label pricelabel = new Label("Price: $"+price);
        pricelabel.setWrapText(true);
        
        // Grid Pane layout
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(10);
        ColumnConstraints column11 = new ColumnConstraints();
        column11.setPercentWidth(10);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(45);
        ColumnConstraints column22 = new ColumnConstraints();
        column22.setPercentWidth(15);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(10);
        ColumnConstraints column33 = new ColumnConstraints();
        column33.setPercentWidth(10);
        gpane.getColumnConstraints().addAll(column1,column11,column2,column22,column3,column33);  // set columns
        
        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(15);
        RowConstraints row00 = new RowConstraints();
        row00.setPercentHeight(5);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(35);
        RowConstraints row11 = new RowConstraints();
        row11.setPercentHeight(20);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(25);
        gpane.getRowConstraints().addAll(row0,row00,row1,row11,row2);  // set rows
        
        
        gpane.getChildren().addAll(prebtn,nextbtn);   // add button
        gpane.getChildren().addAll(namelabel,deslabel,pricelabel);   // add labels
        gpane.setStyle("-fx-background: #f0ffff;");
        GridPane.setRowIndex(namelabel, 0);
        GridPane.setColumnIndex(namelabel,3);
        GridPane.setColumnSpan(namelabel, 2);
        GridPane.setRowSpan(namelabel, 2);
        GridPane.setHalignment(namelabel, HPos.LEFT);
        GridPane.setValignment(namelabel, VPos.CENTER);
        GridPane.setRowIndex(deslabel, 1);
        GridPane.setColumnIndex(deslabel,3);
        GridPane.setColumnSpan(deslabel, 2);
        GridPane.setRowSpan(deslabel, 2);
        GridPane.setHalignment(deslabel, HPos.LEFT);
        GridPane.setValignment(deslabel, VPos.TOP);
        GridPane.setRowIndex(pricelabel, 3);
        GridPane.setColumnIndex(pricelabel,3);
        GridPane.setColumnSpan(pricelabel, 2);
        
        GridPane.setRowIndex(prebtn,4);
        GridPane.setColumnIndex(prebtn,1);
        GridPane.setRowIndex(nextbtn,4);
        GridPane.setColumnIndex(nextbtn,4);
        GridPane.setHalignment(prebtn, HPos.RIGHT);
        GridPane.setValignment(prebtn, VPos.CENTER);
        GridPane.setHalignment(nextbtn, HPos.LEFT);
        GridPane.setValignment(nextbtn, VPos.CENTER);
        
        // load picture.
        ImageView picView = new ImageView();
        if(imgPath.contains("https://") || imgPath.contains("http://"))
        {
            Image image = new Image(imgPath);
            picView.setImage(image);
        }else{
            try{
                //InputStream is = new BufferedInputStream(new FileInputStream("src\\menusystem\\resources\\" + imgPath));
                InputStream is = Menu.class.getResourceAsStream("resources/" + imgPath);
                Image image = new Image(is);
                picView.setImage(image);
            }catch(NullPointerException ex){ 
                try{
                    //InputStream is = new BufferedInputStream(new FileInputStream("src\\menusystem\\resources\\" + "default.jpg"));
                    InputStream is = new BufferedInputStream(new FileInputStream("default.jpg"));
                    Image image = new Image(is);
                    picView.setImage(image);
                }catch(FileNotFoundException exx){ }
            }
        }
        
        picView.setFitWidth(410);
        picView.setFitHeight(410);
        //picView.setPreserveRatio(true);
        gpane.getChildren().add(picView);   // add picView
        GridPane.setRowIndex(picView,2);
        GridPane.setRowSpan(picView, 2);
        GridPane.setColumnIndex(picView,1);
        GridPane.setHalignment(picView, HPos.LEFT);
        GridPane.setValignment(picView, VPos.BOTTOM);
        
        Scene tmp = new Scene(gpane, 800, 600);
        tmp.getStylesheets().add(
                MenuSystem.class.getResource("newCascadeStyleSheet.css").toExternalForm()
        );
        scene = tmp;
    }
}
