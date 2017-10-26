package pl.put.poznan.plantsguard.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureDataSet;


//@EnableScan
public //interface MeasuresRepository extends CrudRepository<Measure,String>{
class MeasuresRepository {
	public static MeasureDataSet findInPeriod(LocalDate dateFrom, LocalDate dateTo) {
		MeasureDataSet result = new MeasureDataSet();
		List<Measure> measures = new ArrayList<>();
		
		long days = java.time.temporal.ChronoUnit.DAYS.between(dateFrom, dateTo);
		Random rand = new Random();
		for(int i=0; i<=days; ++i) {
			Measure measure = new Measure();
			measure.setMeasureDate(dateFrom.plusDays(i).atStartOfDay());
			measure.setTemperature((float) ((rand.nextInt(3000)+1000)/100));
			measures.add(measure);
		}
		result.setMeasureList(measures);
		return result;
	}
	
//	List<Measure> findByDate(String measureDate);
//	
//	List<Measure> findInPeriod(String measureDateFrom, String measureDateTo) {
//		return null;
//	}
	
}
