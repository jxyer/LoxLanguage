package com.jxy.language;

/**
 * @author jiangyuhao
 * @since 2023/5/16
 */
public class Return extends RuntimeException {
    final Object value;

    public Return(Object value) {
        super(null, null, false, false);
        this.value = value;
    }

}
