package com.bibliophile;
import com.bibliophile.config.Configure;
public abstract class Main {

    //main method
    public static void main(String[] args){

        //Calling constructor of the Configure class to configure and build the Discord bot
        new Configure();
    }
}
