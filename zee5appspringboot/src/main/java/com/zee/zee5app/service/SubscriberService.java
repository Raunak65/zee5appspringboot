package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface SubscriberService {

	public String addSubscriber(Subscription subscriber);
	public Optional<Subscription> getSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException;
	public Subscription[] getAllSubscribers() throws InvalidNameException, IdInvalidLengthException, InvalidAmountException;
	public String deleteSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException;
	public Optional<List<Subscription>> getAllSubscriptionssDetails() throws InvalidNameException, IdNotFoundException, InvalidPasswordException, InvalidEmailException, IdInvalidLengthException, InvalidAmountException;
	
}
