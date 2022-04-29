/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package odev3;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
    
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/int", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            sc1.close();
            System.out.println(inputList);
            String input2 = req.queryParams("input2").replaceAll("\\s","");
            int input2AsInt = Integer.parseInt(input2);
            boolean result = App.searchInteger(inputList, input2AsInt);
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            map.put("result", result);
            return new ModelAndView(map, "int.mustache");
        }, new MustacheTemplateEngine());

        get("/int",
        (rq, rs) -> {
            Map<String, String> map = new HashMap<String, String>();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "int.mustache");
        }, new MustacheTemplateEngine());

        post("/str", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()){
                String value = sc1.next().replaceAll("\\s","");
                inputList.add(value);
            }
            sc1.close();
            System.out.println(inputList);
            String input2 = req.queryParams("input2").replaceAll("\\s","");
            boolean result = App.searchString(inputList, input2);
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            map.put("result", result);
            return new ModelAndView(map, "str.mustache");
        }, new MustacheTemplateEngine());
        
        get("/str",
        (rq, rs) -> {
            Map<String, String> map = new HashMap<String, String>();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "str.mustache");
        }, new MustacheTemplateEngine());

        post("/char", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Character> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()){
                char value = sc1.next().charAt(0);
                inputList.add(value);
            }
            sc1.close();
            System.out.println(inputList);
            Character input2 = req.queryParams("input2").charAt(0);
            App.deleteChar(inputList, input2);
            Map<String, Character> map = new HashMap<String, Character>();
            map.put("status", input2);
            return new ModelAndView(map, "char.mustache");
        }, new MustacheTemplateEngine());

        get("/char",
        (rq, rs) -> { 
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "not selected yet!");
            return new ModelAndView(map, "char.mustache");
        }, new MustacheTemplateEngine());

    }
static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
    }return 4567;//return default port if heroku-port isn't set (i.e. on localhost)   
}

    public static boolean searchInteger(ArrayList<Integer> array, int e) { 
        System.out.println("inside search"); 
        if (array == null) return false; 
        for (int elt : array) { 
            if (elt == e) return true; 
        } 
        return false; 
    }

    public static boolean searchString(ArrayList<String> array, String e) { 
        System.out.println("inside search"); 
        if (array == null) return false; 
        for (String elt : array) { 
            if (elt.equalsIgnoreCase(e)) return true; 
        } 
        return false; 
    }

    public static boolean deleteChar(ArrayList<Character> array, char e) { 
        System.out.println("inside search"); 
        if (array == null) return false; 
        if(array.remove(Character.valueOf(e))) return true;
        return false; 
    }
}
