/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusystem;

/**
 *
 * @author YangLaptop
 */
public class Dish {
    protected String Name;
    protected String Description;
    protected double Price;
    protected String ImagePath;
    
    public Dish(String dname, String discri, double price, String path) {
        this.Name = dname;
        this.Description = discri;
        this.Price = price;
        this.ImagePath = path;
    }
    
    public Dish(String name){
        this.Name = name;
    }
    
    public void setDesc(String s){
        this.Description = s;
    }
    
    public void setPrice(double d){
        this.Price = d;
    }
    
    public void setImage(String path){
        this.ImagePath = path;
    }
    
    @Override
    public String toString(){
        return Name + ":" + Description + ":" + Price + ":" + ImagePath;
    }
}
