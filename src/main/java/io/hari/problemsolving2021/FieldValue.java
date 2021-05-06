package io.hari.problemsolving2021;

/**
 * @Author hayadav
 * @create 5/6/2021
 */
public enum FieldValue {
    AGE("NUMBER"),
    GENDER("STRING"),
    IS_AFFLUENT("BOOLEAN");

    String number;
    FieldValue(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }
}
