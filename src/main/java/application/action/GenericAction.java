package application.action;

public abstract class GenericAction<E> implements Action<E> {
    protected String message;
    protected String code;

    public GenericAction(String code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }
}
