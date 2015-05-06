package com.qcqz.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;

import com.qcqz.cons.CommonConstant;
import com.qcqz.pageModel.User;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest extends AbstractContextControllerTests{
	private static MockHttpSession mockSession;
	private static User user;
	@BeforeClass
	public static void initUser(){
		user = new User();
		
		mockSession = new MockHttpSession();
	}
	
	@Test
	public void testLogin() throws Exception{
		ResultActions result = mockMvc.perform(get("/user/login").session(mockSession)
				.param("userName", "admin").param("passwd", "admin").accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk()).andExpect(jsonPath("$."+CommonConstant.STATUS_KEY).value(CommonConstant.STATUS_OK)).andDo(print());
		User sessionUser = (User) mockSession.getAttribute(CommonConstant.USER_CONTEXT);
		Assert.assertNotNull(sessionUser);
	}
}
