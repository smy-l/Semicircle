package club.banyuan.exception;

public class CustomException extends Exception{
    public String msg;

    public CustomException(){}

    public CustomException(String msg){
        super(msg);
    }
    @Override
    public String getMessage() {
        if(msg!=null)
            return msg;
        else
            return "CustomException";
    }
}
