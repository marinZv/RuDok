package errors;

public class MyError {

    private String message;

    public MyError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
