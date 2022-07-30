package com.mjp.dto;

import java.util.Objects;

public class CalcuInfo {

    private int id;

    private String name;

    public CalcuInfo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcuInfo calcuInfo = (CalcuInfo) o;
        return id == calcuInfo.id && Objects.equals(name, calcuInfo.name);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
