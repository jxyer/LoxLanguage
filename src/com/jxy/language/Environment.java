package com.jxy.language;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangyuhao
 * @since 2023/5/15
 */
public class Environment {
    final Environment enclosing;
    private final Map<String, Object> values = new HashMap<>();

    public Environment() {
        enclosing = null;
    }

    public Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }
        if (enclosing != null) return enclosing.get(name);
        throw new RuntimeError(name, "未定义的变量" + name.lexeme + "。");
    }

    void define(String name, Object value) {
        values.put(name, value);
    }

    public void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
        }
        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name, "未定义的变量" + name.lexeme + "。");
    }
}
