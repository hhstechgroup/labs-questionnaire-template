package com.engagepoint.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: oleksandr.koval
 * Date: 1/29/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
@RequestScoped
@ManagedBean
public class ServiceConfigProperties {
    public int getPagesCount(){

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src\\main\\resources\\sdfconfig.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Integer.parseInt(prop.getProperty("pagescount"));
    }


}
