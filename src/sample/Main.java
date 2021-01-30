package sample;
//Libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;

//Main Class
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Desktop Dictionary");
        primaryStage.setScene(new Scene(root, 400, 300)); //400, 150 //400, 300
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(400);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("book.png"))) ;
        primaryStage.show();
    }

    //main method
    public static void main(String[] args) {
        launch(args);
    }

    //Model Class
    public static class Model {

        public static ArrayList<String> meaning = new ArrayList<String>(); //instantiating an ArrayList list for the meaning
        public static ArrayList<String> errorMsg = new ArrayList<String>(); //instantiating an ArrayList list for the errorMsg

        //translate method that returns an ArrayList
        public static ArrayList<String> translate(String the_word) throws ParseException {
            //System.out.println("START"); //Remove later
            JSONParser parser = new JSONParser(); //calling the constructor for the JSON Parser
            try {
                FileReader reader = new FileReader("data.json"); //reading the .json file
                Object obj = parser.parse(reader); //parsing the .json file
                JSONObject empjsonobj = (JSONObject) obj; //converting the .json file to JSON Object
                JSONArray word = (JSONArray) empjsonobj.get(the_word); //getting the meaning of the word
                for (Object o : word) {
                    meaning.add(o.toString()); //adding every meaning of the word to the ArrayList in the form of a String
                }
            }
            catch(Exception e){
                e.printStackTrace();
                errorMsg.add("The word doesn't exist. Please double check it.");
                errorMsg.add("Or the word is not in our database. Sorry.");
                errorMsg.add("Please enter another word.");
                return errorMsg;
            }
            return meaning; //returns the meaning of the word in ArrayList
        }



    }
    }

//Attributions
//Code for adding every meaning of the word was retrieved from here: https://stackoverflow.com/questions/16726946/java-add-each-word-to-an-arraylist
//The Book icon was retrieved from here: https://dlpng.com/png/6988817
