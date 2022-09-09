package com.unl.ute.sw.models;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonaJSMD {
    private String msg;
    private Integer code;
    private List<PersonaJSMD> data = new ArrayList<>();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<PersonaJSMD> getData() {
        return data;
    }

    public void setData(List<PersonaJSMD> data) {
        this.data = data;
    }
}


