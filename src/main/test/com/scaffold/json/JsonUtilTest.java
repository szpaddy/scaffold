package com.scaffold.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.scaffold.common.utils.JsonUtil;

public class JsonUtilTest {

	@Test
	public void testGetJsonString() throws Exception {
		log(JsonUtil.getJsonString(getUser()));
		log(JsonUtil.getJsonString(getUserList()));
		log(JsonUtil.getJsonString(getUserMap()));
	}

	@Test
	public void testGetJavaObject() throws Exception {
		log(JsonUtil.getJavaObject("{\"id\":1,\"name\":\"liubei\"}", UserBean.class));
	}

	@Test
	public void testGetJavaGeneric() throws Exception {
		log(JsonUtil.getJavaGeneric(
				"[{\"id\":1,\"name\":\"liubei\"},{\"id\":2,\"name\":\"guanyu\"},{\"id\":3,\"name\":\"zhangfei\"}]",
				new TypeReference<List<UserBean>>() {
				}));
		log(JsonUtil
				.getJavaGeneric(
						"{\"zhangfei\":{\"id\":3,\"name\":\"zhangfei\"},\"guanyu\":{\"id\":2,\"name\":\"guanyu\"},\"liubei\":{\"id\":1,\"name\":\"liubei\"}}",
						new TypeReference<Map<String, UserBean>>() {
						}));
	}

	private List<UserBean> getUserList() {
		UserBean userBean1 = new UserBean(1, "liubei");
		UserBean userBean2 = new UserBean(2, "guanyu");
		UserBean userBean3 = new UserBean(3, "zhangfei");

		List<UserBean> userBeans = new ArrayList<UserBean>();
		userBeans.add(userBean1);
		userBeans.add(userBean2);
		userBeans.add(userBean3);

		return userBeans;
	}

	private Map<String, UserBean> getUserMap() {
		UserBean userBean1 = new UserBean(1, "liubei");
		UserBean userBean2 = new UserBean(2, "guanyu");
		UserBean userBean3 = new UserBean(3, "zhangfei");

		Map<String, UserBean> map = new HashMap<String, UserBean>();
		map.put("liubei", userBean1);
		map.put("guanyu", userBean2);
		map.put("zhangfei", userBean3);

		return map;
	}

	private UserBean getUser() {
		return new UserBean(1, "liubei");
	}

	private void log(Object obj) {
		System.out.println(obj);
	}
}
