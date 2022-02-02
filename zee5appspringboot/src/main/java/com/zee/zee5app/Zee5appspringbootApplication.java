package com.zee.zee5app;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriberService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		EpisodeService episervice = applicationContext.getBean(EpisodeService.class);
		for(int i = 1;i<5;i++) {
			Episode epi = new Episode();
			epi.setId("series1episode@"+i);
			epi.setLength(40);
			epi.setLocation("location"+i);
			epi.setName("episode"+i);
			epi.setSeriesId("series1");
			epi.setTrailer("Trailer"+i);
			episervice.addEpisode(epi);
			
		}
		
//		try {
//			Register register = new Register(new BigDecimal("7867890134"),"raunak1","Raunak","Chandak","raunak1@mail.com","pass@afes");
//			System.out.println(userservice.addUser(register));
//		} catch (IdInvalidLengthException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (javax.naming.InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		applicationContext.close();
		
	}

}
