package com.basho.decorator;

import com.basho.decorator.thirdparty.LogMessage;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

@Decorator
@Priority(20)
public abstract class LogMessageJSONFormatter implements LogMessage {

    @Delegate
    @Any
    @Inject
    @ComplexMessage
    private LogMessage logMessage;

    @Override
    public void printMessage() {
        String message = logMessage.getMessage();
        message = JsonbBuilder.create().toJson(message);
        logMessage.setMessage(message);
    }
}
