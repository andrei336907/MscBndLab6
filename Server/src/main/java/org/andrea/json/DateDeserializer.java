package org.andrea.json;

import com.google.gson.*;
import org.andrea.exceptions.InvalidDateFormatException;

import java.lang.reflect.Type;
import java.util.Date;

import static org.andrea.utils.DateConverter.parseDate;

/**
 * type adapter for json deserialization
 */
public class DateDeserializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            return parseDate(json.getAsJsonPrimitive().getAsString());
        } catch (InvalidDateFormatException e) {
            throw new JsonParseException("");
        }
    }
}