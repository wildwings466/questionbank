package com.skilltest.questionbank.questionbank.util;

import com.fasterxml.jackson.databind.util.StdConverter;

import io.micrometer.common.util.StringUtils;

public class ToLowerCaseConverter extends StdConverter<String, String>{

	@Override
	public String convert(String value) {
		if (StringUtils.isBlank(value)) {
			return value;
		}
		return value.toLowerCase();
	}

}
