package sample;
//Libraries
import com.sun.xml.internal.ws.util.StringUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.text.ParseException;
import java.util.ArrayList;
import javafx.scene.control.TextField;

//Controller Class
public class Controller {
    //Variable Declarations
    public TextField wordToSearch;
    public Label wordInMeaning;
    public static ArrayList<String> the_meaning = new ArrayList<String>();
    public javafx.scene.control.Label firstMeaning;

    Main.Model model = new Main.Model(); //calling the constructor for the model class

    //Search button action event
    public void btn_search(ActionEvent actionEvent) throws ParseException {
        String text = wordToSearch.getText().toLowerCase(); //Gets the word to be searched from the user and converts it to lowercase
        the_meaning = model.translate(text); // calls the function translate in model class and stores the return values in a variable
        wordInMeaning.setText(StringUtils.capitalize(text)); //Sets the word label to Title Case

        StringBuffer sb = new StringBuffer(); //constructor for StringBuffer
        //for loop to append the contents of the Arraylist to the Buffer
        for(String s: the_meaning){
            sb.append("- ");
            sb.append(s);
            sb.append("\n");
        }
        String str_themeaning = sb.toString(); //converts the StringBuffer to String
        firstMeaning.setText(str_themeaning); //sets the text of the label to the contents of str_themeaning
        the_meaning.clear();
        wordToSearch.clear(); //clears wordToSearch textfield
        }

    //Pressing Enter in the textfield action event
    public void getWord(ActionEvent actionEvent) throws ParseException {
        String text = wordToSearch.getText().toLowerCase(); //Gets the word to be searched from the user and converts it to lowercase
        the_meaning = model.translate(text); // calls the function translate in model class and stores the return values in a variable
        wordInMeaning.setText(StringUtils.capitalize(text)); //Sets the word label to Title Case

        StringBuffer sb = new StringBuffer(); //constructor for StringBuffer
        //for loop to append the contents of the Arraylist to the Buffer
        for(String s: the_meaning){
            sb.append("- ");
            sb.append(s);
            sb.append("\n");
        }
        String str_themeaning = sb.toString(); //converts the StringBuffer to String
        firstMeaning.setText(str_themeaning); //sets the text of the label to the contents of str_themeaning
        the_meaning.clear(); //clears the variable the_meaning
        wordToSearch.clear(); //clears wordToSearch textfield
    }
}


//Attributions
//Retrieved the String Buffer Code from here: https://www.tutorialspoint.com/How-to-create-a-string-from-a-Java-ArrayList