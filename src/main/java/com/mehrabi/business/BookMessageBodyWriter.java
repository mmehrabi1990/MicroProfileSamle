package com.mehrabi.business;

import com.mehrabi.business.model.Book;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class BookMessageBodyWriter
        implements MessageBodyWriter<Book> {

    @Override
    public boolean isWriteable(
            Class<?> type, Type genericType,
            Annotation[] annotations,
            MediaType mediaType) {

        return type.equals(Book.class);
    }

    // ...

    @Override
    public void writeTo(
            Book book, Class<?> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) {

        JsonWriter jsonWriter = Json.createWriter(entityStream);
        JsonObject jsonObject = BookMapper.map(book);
        jsonWriter.writeObject(jsonObject);
        jsonWriter.close();
    }
}