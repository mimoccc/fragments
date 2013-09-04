package com.astound.fragments.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PublishEvent {

    public PageEvent.EventType type() default PageEvent.EventType.ELEMENT_EVENT;

    public String value();

}