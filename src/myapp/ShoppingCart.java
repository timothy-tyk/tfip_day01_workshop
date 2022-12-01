package myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
  public static void main(String[] args){
    //initialize console
    Console cons = System.console();
    System.out.println("Welcome to your shopping cart");
    String input = "";
    List<String> shoppingList = new LinkedList<>();
    while (!input.equals("exit")){
      if(input.equals("exit")){
        break;
      }
      else{
      input = cons.readLine(">");
      String[] inputSplit = input.split(" ");
      String command = inputSplit[0];
      
      switch(command.toLowerCase()){
        case "list":
        if(shoppingList.size()<=0) System.out.println("Your cart is empty");
        else{
        for (int i=0;i<shoppingList.size();i++){
          System.out.printf("%d: %s\n",i+1,shoppingList.get(i));
        }
      }
        break;

        case "add":
        String item = inputSplit[1];
        if(shoppingList.contains(item)){
          System.out.printf("You have %s in your cart\n", item);
        }else{
        shoppingList.add(item);
        System.out.printf("%s added to cart\n",item);
        }
        break;

        case "delete":
        item = inputSplit[1];
        // System.out.printf("List has %d items",shoppingList.size());
        int index = Integer.parseInt(item);
        if(index<=0 || index>shoppingList.size()) {
          System.out.println("Incorrect item index");
        }
        else{
          // shoppingList.remove(index-1) must be AFTER the print statement, if not will throw out of bounds error!!
          System.out.printf("%s removed from cart\n",shoppingList.get(index-1));
          shoppingList.remove(index-1);
        }
        break;
        
        
      }
    }
  }
  }
}
