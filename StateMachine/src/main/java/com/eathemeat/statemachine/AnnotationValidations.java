package com.eathemeat.statemachine;

import androidx.annotation.IntRange;

import java.lang.annotation.Annotation;

public class AnnotationValidations {


    /**
     * Validate a long value with two parameters.
     */
    public static void validate(Class<IntRange> annotation, IntRange ignored, long value,
                                String paramName1, long param1, String paramName2, long param2) {
        validate(annotation, ignored, value, paramName1, param1);
        validate(annotation, ignored, value, paramName2, param2);
    }

    /**
     * Validate a long value with one parameter.
     */
    public static void validate(Class<IntRange> annotation, IntRange ignored, long value,
                                String paramName, long param) {
        switch (paramName) {
            case "from":
                if (value < param) {
                    invalid(annotation, value, paramName, param);
                }
                break;
            case "to":
                if (value > param) {
                    invalid(annotation, value, paramName, param);
                }
                break;
        }
    }

    private static void invalid(Class<? extends Annotation> annotation, Object value,
                                String paramName, Object param) {
        String paramPrefix = "value".equals(paramName) ? "" : paramName + " = ";
        invalid("@" + annotation.getSimpleName() + "(" + paramPrefix + param + ")", value);
    }

    private static void invalid(String valueKind, Object value) {
        throw new IllegalStateException("Invalid " + valueKind + ": " + value);
    }

}
