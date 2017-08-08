package com.mars.alleluia.base;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    private final String CODE = "code";
    private final String MESSAGE = "message";
    private final String DATA = "data";

    protected Object packet(int code, String msg, Object obj) {
        Map<String, Object> result = new HashMap<>();
        result.put(CODE, code);
        if (msg != null) {
            result.put(MESSAGE, msg);
        }
        if (obj != null) {
            result.put(DATA, obj);
        }
        return result;
    }
}
