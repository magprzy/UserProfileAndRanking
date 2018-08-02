package com.capgemini.userProfileAndRanking.controller.impl;

import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.userProfileAndRanking.controller.UserController;
import com.capgemini.userProfileAndRanking.excption.ExceptionController;
import com.capgemini.userProfileAndRanking.service.UserProfileService;
import com.capgemini.userProfileAndRanking.service.impl.UserProfileServiceImpl;
import com.capgemini.userProfileAndRanking.to.UserTO;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserProfileServiceImpl userProfileService;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserTO> getAllUsers() {

		return userProfileService.getAllUSers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserTO getUserById(@PathVariable("id") int id) {
		return userProfileService.getPlayerInformation(id);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@RequestBody UserTO userTO) {

		List<UserTO> users = getAllUsers();
		boolean userIsInSystem = false;
		for (UserTO user : users) {
			if (user.getId() == userTO.getId()) {
				userIsInSystem = true;
			} else {
				userIsInSystem = false;
			}
		}

		if (userIsInSystem == true) {
			return "The user with such an id already exists";
		} else {
			userProfileService.addUser(userTO);
			return "User added successfully";
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<UserTO> getUsersByParameters(
			@RequestParam("first") String firstName,
			@RequestParam("last") String lastName,
			@RequestParam("email") String email) {

		List<UserTO> users = userProfileService.getUserByParameters(firstName,
				lastName, email);
		return users;

	}

}
