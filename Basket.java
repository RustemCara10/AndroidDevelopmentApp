package com.example.trytry;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Basket {
    private final ArrayList<Product> myBasket = new ArrayList<>();
    private final Context context;
    private AlertDialog.Builder builder;

    public Basket(Context context) {
        this.context = context;
    }

    private String basketItemsInString(){

        String output="\n Products in the Basket";
        output += "\n ---------------------------------";
        int overallTotal=0;

        for (Product eachProduct : myBasket){

            int productTotal = eachProduct.getProductPrice() * eachProduct.getProductQuantity();
            overallTotal +=productTotal;

            output += "\n Product Name:" + eachProduct.getProductName();
            output += "\n Product Price: £" + eachProduct.getProductPrice();
            output += "\n Product Quantity Selected:" + eachProduct.getProductQuantity();
            output += "\n Price to Pay: £" + productTotal;
            output += "\n ---------------------------------";
        }

        output += "\n TOTAL TO PAY: £" + overallTotal;

        return output;
    }

    public void showBasket() {
        builder = new AlertDialog.Builder(context);

        builder.setTitle("Items in the basket");

        String basketItems = basketItemsInString();

        //Setting message manually and performing action on button click
        builder.setMessage(basketItems + "\nDo you want to Continue shopping?")
                .setCancelable(false)
                .setNegativeButton("Go to Purchase Screen", (dialog, id) -> {
                    //  Action for 'NO' Button
                  Toast.makeText(context.getApplicationContext(), "Click on icon",Toast.LENGTH_SHORT).show();

                    dialog.dismiss();
                })
                .setPositiveButton("Stay on the Products Page", (dialog, id) -> {
                    dialog.cancel();
                    /* finish();
                    Toast.makeText(getApplicationContext(),"you choose yes action for alert-box",
                            Toast.LENGTH_SHORT).show();*/
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("My Basket");
        alert.show();
    }

    public boolean addToBasket (Product p){
        return myBasket.add(p);
    }


    public boolean removeFromBasket (Product p){

        for (Product eachProduct : myBasket){
            if (Objects.equals(eachProduct.getProductName(), p.getProductName())){
                myBasket.remove(eachProduct);
                return true;
            }
        }
        return false;
    }

}
