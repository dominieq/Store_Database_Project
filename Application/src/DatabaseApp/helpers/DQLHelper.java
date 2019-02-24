package DatabaseApp.helpers;

//import java.util.ArrayList;
import java.util.List;

public class DQLHelper {

    private List<String> choiceValues;
    private List<String> askValues;

    public DQLHelper (List<String> choiceValues, List<String> askValues) {
        this.choiceValues = choiceValues;
        this.askValues = askValues;
    }


    public String getAskValue (String choiceValue) {
        System.out.println(choiceValue);
        System.out.println(askValues.size());
        return askValues.get(choiceValues.indexOf(choiceValue));
    }
}
