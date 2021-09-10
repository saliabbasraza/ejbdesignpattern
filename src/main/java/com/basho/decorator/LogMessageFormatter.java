package com.basho.decorator;

import com.basho.decorator.thirdparty.LogMessage;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import static java.time.LocalDate.now;

@Decorator
@Priority(10)
public abstract class LogMessageFormatter implements LogMessage {

    @Delegate
    @Any
    @Inject
    private LogMessage logMessage;

    @Override
    public void printMessage() {
        String message = logMessage.getMessage();
        message = now().toString().concat(message);
        logMessage.setMessage(message);
    }
}
