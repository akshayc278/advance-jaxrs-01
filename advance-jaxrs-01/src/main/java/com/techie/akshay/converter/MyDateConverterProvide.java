package com.techie.akshay.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import com.techie.akshay.model.MyDate;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvide implements ParamConverterProvider{
	//Other way to implement is using messageBodywriters 
	//using messagbodywriter you can create custom mediatype like mediaType.customeClass as well

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar cal=Calendar.getInstance();
					if("tommorrow".equalsIgnoreCase(value)) {
						cal.add(Calendar.DATE, 1);
					}
					if("yesterdat".equalsIgnoreCase(value)) {
						cal.add(Calendar.DATE, -1);
					}
					MyDate myDate=new MyDate();
					myDate.setDate(cal.get(Calendar.DATE));
					myDate.setMonth(cal.get(Calendar.MONTH));
					myDate.setYear(cal.get(Calendar.YEAR));
					return rawType.cast(myDate);
				}

				@Override
				public String toString(T value) {
					if(value == null) {
						return null;
					}
					return value.toString();
				}
				
			};
		}
		return null;
	}

}
