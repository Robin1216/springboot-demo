package com.robin.springboot.demo.java_ExportExcel;

import java.util.Objects;

public class Model {

    private String s1;
    private String s2;

    public Model() {
    }

    public Model(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "Model{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(s1, model.s1) &&
                Objects.equals(s2, model.s2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s1, s2);
    }
}
