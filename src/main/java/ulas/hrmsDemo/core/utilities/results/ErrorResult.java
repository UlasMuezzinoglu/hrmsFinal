package ulas.hrmsDemo.core.utilities.results;

public class ErrorResult extends Result{

    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }


    public ErrorResult() {
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
    public ErrorResult(String message, int statusCode){
        super(false,message);
        this.statusCode = statusCode;
    }


}
