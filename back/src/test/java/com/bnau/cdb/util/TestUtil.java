package com.bnau.cdb.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestUtil {
	
	/**
	 * Convert a DTO to the json format.
	 *
	 * @param dto The object to convert.
	 * @return The converted json.
	 * @throws JsonProcessingException
	 */
	public static String dtoToJson(final Object dto) throws JsonProcessingException {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		final String requestJson = ow.writeValueAsString(dto);
		return requestJson;
	}
}
