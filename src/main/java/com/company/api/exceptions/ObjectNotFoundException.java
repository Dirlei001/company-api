package com.company.api.exceptions;

import lombok.Getter;

@Getter
public class ObjectNotFoundException extends RuntimeException  {
    private String msg;

    public ObjectNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
}
