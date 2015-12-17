package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String output="";

        double totalCost = 0;
        double totalTaxAmt=0;
        while (true) {
            System.out.println("Enter product quantity,name of product,category of product,price of product ,Is it Imported -->seperated by comma. Enter exit for stopping the application");
            String item = br.readLine();
            if (item.equals("exit")) {
                break;
            }
            String[] itemList = item.split(",");

            int itemQuantity = Integer.parseInt(itemList[0]);
            String itemName = itemList[1];
            String itemCategory = itemList[2];
            double itemCost = Double.parseDouble(itemList[3]);
            boolean isItemImported=Boolean.parseBoolean(itemList[4]);

            Product product=new Product(itemName,itemCategory,itemQuantity,itemCost,isItemImported);

            double itemTaxedAmt=product.calculateTaxedAmount();

            double itemTax=product.costWithTax-product.productCost;

            totalTaxAmt=totalTaxAmt+itemTax;

            totalCost=totalCost+itemTaxedAmt;
            output=output+product.productQuantity+" "+product.productName+" -"+product.costWithTax+"\n";
        }
        totalTaxAmt=round(totalTaxAmt,2);
        output=output+"Sales tax: "+totalTaxAmt+"\nTotal: "+totalCost;
        System.out.println(output);
    }

    public static double round(double value,int places) {
        if (places < 0) throw new IllegalArgumentException();

            long factor = (long) Math.pow(10, places);
            value = value * factor;
            long tmp = Math.round(value);
            return (double) tmp / factor;
        }


}
