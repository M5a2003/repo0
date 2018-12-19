package chequesprint;

import java.io.*;

import java.awt.*;

import java.util.*;

import java.applet.*;

import javax.swing.*;

import java.awt.event.*; 

import javax.swing.event.*;

 

public class Test extends JApplet

{

    //empty constructor

    public Test()

    {

        System.out.println("Java");

    }

    //single variable constructor

    public Test(String s)

    {

        System.out.println(s);

    }

    //method

    public void method()

    {

       System.out.println("method");

   }

    //init

    public void init()

    {

                 System.out.println("Applet initializing");

                 getContentPane().add(new panel());

        method();

        }

       //start

   public void start()

       {

                System.out.println("Applet starting");
       }
   
   //stop

       public void stop()

        {

                System.out.println("Applet stopping");

        }

        //destroy

        public void destroy()

        {

                System.out.println("Applet destroyed");

        }

    //Panel

    public class panel extends JPanel

    {

        public panel()

        {

            //this is where the diplay items go

        }

    }

    public  static void main(String[] args)

    {

        Chequesprint chequesprint = new Chequesprint();

        chequesprint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Test   t = new Test();

        t.init();               // simulate browser call(1)

        chequesprint.setSize(800,800);         // Set the size of the frame

        chequesprint.setVisible(true);         // Show the frame

    }

}


