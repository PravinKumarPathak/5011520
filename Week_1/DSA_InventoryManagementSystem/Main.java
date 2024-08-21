package InventoryManagementSystem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ManageInventory inv=new ManageInventory();
        inv.addProduct(new Product(1,"SmartPhone",25,20000));
        inv.addProduct(new Product(2,"Television",7,45000));
        inv.addProduct(new Product(3,"AirConditioner",13,50000));
        Product pro=new Product(4,"Tablet",20,30000);
        inv.addProduct(pro);
        inv.addProduct(new Product(5,"WashingMachine",19,21000));
        System.out.println("Product Added :");
        System.out.println(inv.display());
        inv.updateProduct(2,new Product(6,"Oven",17,17000));
        System.out.println("\nProduct updated!!\n");
        System.out.println(inv.display());
        inv.deleteProduct(pro);
        System.out.println("\nProduct with ProductId 4 deleted!!\n");
        System.out.println(inv.display());
    }
}

class Product{
    int productId;
    String productName;
    int quantity;
    double price;
    
    Product(int productId,String productName,int quantity,double price){
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }

    public String toString(){
        return "[ProductId="+productId+","+"ProductName="+productName+","+"Quantity="+quantity+","+"Price="+price+"]";
    }

}

class ManageInventory{
    ArrayList<Product> al=new ArrayList<>();
    
    public void addProduct(Product ref){
        al.add(ref);
    }
    
    public void updateProduct(int i,Product ref){
        al.set(i,ref);
    }

    public void deleteProduct(Product ref){
        al.remove(ref);
    }

    public ArrayList<Product> display(){
        return al;
    }
}