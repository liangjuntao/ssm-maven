package example.properties;

import java.util.Properties;
 
/**
 * 了解Preoperties的使用
 */
 public class ReadJVM {
     public static void main(String[] args) {
         Properties pps = System.getProperties();
         pps.list(System.out);
     }
 }