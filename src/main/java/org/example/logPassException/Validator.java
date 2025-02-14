package org.example.logPassException;

@FunctionalInterface
public interface Validator {
    void validate() throws Exception;
}
