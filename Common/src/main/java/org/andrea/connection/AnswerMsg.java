package org.andrea.connection;

public class AnswerMsg implements Response {
    private static final long serialVersionUID = 666;
    private String msg;
    private Status status;

    public AnswerMsg() {
        msg = "";
        status = Status.FINE;
    }

    /**
     * clear message
     *
     * @return
     */
    public AnswerMsg clear() {
        msg = "";
        return this;
    }

    /**
     * set answer that you want user to see
     *
     * @param str
     */
    public AnswerMsg info(Object str) {
        msg = str.toString();
        return this;
    }

    /**
     * set error message
     *
     * @param str Message what happened
     * @return
     */
    public AnswerMsg error(Object str) {
        msg = "Error" + str.toString() + "/n";
        setStatus(Status.ERROR);
        return this;
    }

    /**
     * get content of message
     *
     * @return
     */
    public String getMessage() {
        return msg;
    }

    /**
     * gets status of message
     *
     * @return
     */
    public Status getStatus() {
        return status;
    }

    @Override
    public String getContextType() {
        return "application/json";
    }

    @Override
    public String getContextLength() {
        return String.valueOf(msg.length());
    }

    @Override
    public String getHost() {
        return "127.0.0.1";
    }

    public AnswerMsg setStatus(Status s) {
        status = s;
        return this;
    }

    @Override
    public String toString() {
        switch (getStatus()) {
            case ERROR:
                return "INFO:  " + getMessage();
            default:
                return "HTTP/1.1 \nHOST: " + getHost()+ "\nCONTEXT-LENGTH: " + getContextLength() + "\nCONTEXT-TYPE: " + getContextType() + "\n"
                        + getMessage();
        }
    }

}
