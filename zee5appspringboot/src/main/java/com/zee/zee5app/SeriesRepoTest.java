package com.zee.zee5app;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.SeriesService;

public class SeriesRepoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(SeriesRepoTest.class, args);
		
		SeriesService seriesservice = applicationContext.getBean(SeriesService.class);
		
		Series series1 = new Series("series@10", "Family Man", 
				"https://www.youtube.com/watch?v=TcMBFSGVi1c&ab_channel=TVF",
				 "2022-09-02", "location10",
				"HINDI", "A,B,C",10, 10);
		seriesservice.addSeries(series1);
		try {
			Series[] series = seriesservice.getAllSeries();
			for(int i = 0 ; i < series.length;i++) {
				System.out.println(series[i]);
			}
			Optional<List<Series>> optional = seriesservice.getAllSeriesDetails();
			if (optional.isPresent()){
				optional.get().forEach(e->System.out.println(e));
			}
			else {
				System.out.println("No series found.");
			}
			String res = seriesservice.deleteSeriesById("series@10");
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
		}
		
		
		applicationContext.close();
	}

}
