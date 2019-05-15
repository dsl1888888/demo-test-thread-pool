package com.example.demo.opt;

public class TesClassLoad
{

    static
    {
        System.out.println("我被动了");
    }

    public static void main(String[] args)
    {

        for (int i = 0; i < 10; i++)
        {
            new TesClassLoad();
        }
    }
}
