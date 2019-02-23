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

//    public List<String> getChoiceValues() {
//        return choiceValues;
//    }
//
//    public List<String> getAskValues() {
//        return askValues;
//    }

    public String getAskValue (String choiceValue) {
        System.out.println(choiceValue);
        System.out.println(askValues.size());
        return askValues.get(choiceValues.indexOf(choiceValue));
    }

//    public void setChoiceValues(List<String> choiceValues) {
//        this.choiceValues = choiceValues;
//    }
//
//    public void setAskValues(List<String> askValues) {
//        this.askValues = askValues;
//    }
//
//    public void set(List<String> choiceValues, List<String> askValues) {
//        this.choiceValues = choiceValues;
//        this.askValues = askValues;
//    }
}
