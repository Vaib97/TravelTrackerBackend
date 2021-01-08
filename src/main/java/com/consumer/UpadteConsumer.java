package com.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.config.MessagingConfig;
import com.model.Traveller;
import com.service.TravellerService;

@Component
public class UpadteConsumer {
	@Autowired 
	TravellerService travellerService;
	
	//It will consume the message from the queue
	@RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Traveller journey) {
		
		travellerService.save(journey);
        System.out.println("Message recieved from queue : " + journey);
    }

}
