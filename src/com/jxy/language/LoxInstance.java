package com.jxy.language;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangyuhao
 * @since 2023/5/18
 */
public class LoxInstance {
    private final LoxClass loxClass;
    private final Map<String, Object> fields = new HashMap<>();

    public LoxInstance(LoxClass loxClass) {
        this.loxClass = loxClass;
    }

    @Override
    public String toString() {
        return loxClass.name + " instance";
    }

    public Object get(Token name) {
        if (fields.containsKey(name.lexeme)){
            return fields.get(name.lexeme);
        }

        LoxFunction method = loxClass.findMethod(name.lexeme);
        if (method!=null)return method.bind(this);

        throw new RuntimeError(name, "未定义的属性"+name.lexeme+"。");
    }

    public void set(Token name, Object value) {
        fields.put(name.lexeme,value);
    }
}
