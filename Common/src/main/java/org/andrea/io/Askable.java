package org.andrea.io;

import org.andrea.exceptions.InvalidDataException;

public interface Askable<T> {
    T ask() throws InvalidDataException;
}
