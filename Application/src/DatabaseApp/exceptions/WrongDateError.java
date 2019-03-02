package DatabaseApp.exceptions;

public class WrongDateError extends Exception {

    private String wrongDate;

    private String correctDate;

    public WrongDateError(String wrongDate) {
        this.wrongDate = wrongDate;
    }

    private void generateCorrectDate(String wrongDate) {
        String correctDate = "";
        // TODO check wrongDate acknowledge what is wrong and create correctDate
        this.correctDate = correctDate;
    }

    public String getWrongDate() {
        return wrongDate;
    }

    public String getCorrectDate() {
        return correctDate;
    }
}


