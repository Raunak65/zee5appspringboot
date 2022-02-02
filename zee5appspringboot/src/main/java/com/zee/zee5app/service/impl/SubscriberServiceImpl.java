package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SubscriberRepository;
import com.zee.zee5app.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private SubscriberRepository subscriberrepository ;
	@Override
	public String addSubscriber(Subscription subscriber) {
		// TODO Auto-generated method stub
		Subscription subscriber2 = subscriberrepository.save(subscriber);
		if(subscriber2!=null) {
			return "Success";
		}
		else return "Failed";
	}
	

	@Override
	public Optional<Subscription> getSubscriberById(String id)
			throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return subscriberrepository.findById(id);
	}

	@Override
	public Subscription[] getAllSubscribers()
			throws InvalidNameException, IdInvalidLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		List<Subscription> list = subscriberrepository.findAll();
		Subscription [] array = new Subscription[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteSubscriberById(String id)
			throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		try {
			Optional<Subscription> optional = this.getSubscriberById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				subscriberrepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException | IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionssDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriberrepository.findAll());
	}

}
