package com.zee.zee5app;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.SubscriberService;

public class SubscriptionRepoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		SubscriberService subscriberservice = applicationContext.getBean(SubscriberService.class);
		
		
		Subscription subscriber = new Subscription("subscriber@10","reg1004","2022-05-12","ACTIVE",
				"QUARTERLY","UPI",
				"TRUE","2022-08-12",499);
		subscriberservice.addSubscriber(subscriber);
		try {
			Subscription[] subscribers = subscriberservice.getAllSubscribers();
			for(int i = 0 ; i < subscribers.length;i++) {
				System.out.println(subscribers[i]);
			}
			Optional<List<Subscription>> optional = subscriberservice.getAllSubscriptionssDetails();
			if (optional.isPresent()){
				optional.get().forEach(e->System.out.println(e));
			}
			else {
				System.out.println("No subscribers found.");
			}
			String res = subscriberservice.deleteSubscriberById("subscriber@10");
			System.out.println(res);
		} catch (InvalidNameException | IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAmountException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		applicationContext.close();

	}

}
