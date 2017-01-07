package com.niit.shoppingcart.frontend.Handler;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.shoppingcart.giftsgallery.model.UserInfo;

@Component
public class RegistrationHandler {

	public UserInfo initFlow(){
		return new UserInfo();
	}
	


	public String validateDetails(UserInfo user,MessageContext messageContext){
		String status = "success";
		if(user.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("Name cannot be Empty").build());
			status = "failure";
			System.out.println("name pass");
		}
		
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
			System.out.println("password pass");
		}
		if(user.getConfirmpassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmpassword").defaultText("Confirmed Password cannot be Empty").build());
			status = "failure";
			System.out.println("cpassword pass");
		}
		if(!user.getConfirmpassword().equals(user.getPassword())){
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmpassword").defaultText("Passwords do not match").build());
			status = "failure";
			System.out.println("check password pass");
		}
		
			if(user.getEmailid().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"emailid").defaultText("Email cannot be Empty").build());
			status = "failure";
			System.out.println("emailid pass");
		}
		if(user.getPhno().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"phno").defaultText("Mobile No. cannot be Empty").build());
			status = "failure";
			System.out.println("phone no pass");
		}
		if(user.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
			System.out.println("address pass");
		}
		
		return status;
	}
}
