package DatabaseApp.exceptions;

public class ParsingError extends Exception{

    private String wrongDate;

    public ParsingError(String wrongDate) {
        this.wrongDate = wrongDate;
    }

    public String getWrongDate() {
        return this.wrongDate;
    }
}
