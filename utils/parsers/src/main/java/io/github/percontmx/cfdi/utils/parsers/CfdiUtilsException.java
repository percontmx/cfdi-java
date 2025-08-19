package io.github.percontmx.cfdi.utils.parsers;

public class CfdiUtilsException extends RuntimeException {

    private static final long serialVersionUID = -1031468349358382412L;

    public CfdiUtilsException(String message) {
        super(message);
    }

    public CfdiUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CfdiUtilsException(Throwable cause) {
        super(cause);
    }

}
