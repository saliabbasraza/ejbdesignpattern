package com.basho.decorator;

import com.basho.decorator.thirdparty.LogMessage;

@ComplexMessage
public class SystemLogMessage implements LogMessage {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    public void printMessage() {
        System.out.println(this.message);
    }
}
