package com.jxy.language;

import java.util.List;

/**
 * @author jiangyuhao
 * @since 2023/5/16
 */
public interface LoxCallable {

    int arity();

    Object call(Interpreter interpreter, List<Object> arguments);
}
