package com.scaffold.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private final static ObjectMapper objectMapper = new ObjectMapper();

	private JsonUtil() {
	}

	/**
	 * Java对象转换为对应的json字符串
	 * 
	 * @param obj
	 *            需要转换的java对象
	 * @return java对象的json字符串
	 * @throws Exception
	 */
	public static String getJsonString(Object obj) throws Exception {
		return objectMapper.writeValueAsString(obj);
	}

	/**
	 * 解析得到java对象
	 * 
	 * @param jsonStr
	 * @param valueType
	 *            需要转换得到的java对象类型
	 * @return
	 * @throws Exception
	 */
	public static <T> T getJavaObject(String jsonStr, Class<T> valueType) throws Exception {
		return objectMapper.readValue(jsonStr, valueType);
	}

	/**
	 * 解析得到java泛型对象
	 * 
	 * @param jsonStr
	 * @param valueTypeRef
	 *            泛型对象类型
	 * @return
	 * @throws Exception
	 */
	public static <T> T getJavaGeneric(String jsonStr, TypeReference<T> valueTypeRef) throws Exception {
		return objectMapper.readValue(jsonStr, valueTypeRef);
	}
}
