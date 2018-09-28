package com.mh453Uol.masjidma.configurations;

import java.io.IOException;
import java.time.Month;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


public class MonthSerializer extends StdSerializer<Month>  {

	private static final long serialVersionUID = 1L;

	protected MonthSerializer() {
		super(Month.class);
	}

	@Override
	public void serialize(Month value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeNumber(value.getValue());
	}
	 

}
