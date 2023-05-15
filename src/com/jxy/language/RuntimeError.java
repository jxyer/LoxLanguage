package com.jxy.language;

/**
 * @author jiangyuhao
 * @since 2023/5/15
 */
public class RuntimeError extends RuntimeException{

    final Token token;

    RuntimeError(Token token,String message){
        super(message);
        this.token=token;
    }

}
