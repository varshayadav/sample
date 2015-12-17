package com.company;

/**
 * Created by varshay on 12/16/15.
 */
public class Product {

    String productName;
    double productCost;
    String productCategory;
    int productQuantity;
    double costWithTax;
    Boolean isImported;

    Product(String name, String category, int quantity, double cost,boolean isImported){
        this.productName=name;
        this.isImported=isImported;
        this.productCost=cost;
        this.productQuantity=quantity;
        this.productCategory=category;
    }

    public double calculateTaxedAmount(){

        double cost=this.productCost,taxedAmt=0;
        String category=this.productCategory;

        if(this.isImported) {

            if (category.equalsIgnoreCase("other")) {

                taxedAmt=(cost*10)/100;
                taxedAmt=round(taxedAmt,2);
                cost=cost+taxedAmt;
                cost=round(cost,2);
            }

            cost=cost+(cost*5)/100;
            cost=round(cost,2);
            this.costWithTax=cost;

        }else{
            if (category.equalsIgnoreCase("other")) {

                taxedAmt=(cost*10)/100;
                taxedAmt=round(taxedAmt,2);
                cost=cost+taxedAmt;
                cost=round(cost,2);
                this.costWithTax=cost;
            }else{
                this.costWithTax=productCost;
            }

        }
        return costWithTax;
    }

    public static double round(double value,int places) {

        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}
