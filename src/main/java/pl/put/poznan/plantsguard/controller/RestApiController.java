package pl.put.poznan.plantsguard.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.plantsguard.model.JsonMeasuresBuilder;
import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureDataSet;
import pl.put.poznan.plantsguard.model.ReportRequest;
import pl.put.poznan.plantsguard.service.MeasureService;
import pl.put.poznan.plantsguard.service.MeasuresRepository;

@RestController
public class RestApiController {
	

	@Autowired
	MeasuresRepository measureRepository;
//	@Autowired
//	MeasureService measureService;

	@RequestMapping(value="/api/measures/save", method=RequestMethod.POST, consumes= {"application/json","*/*"})
	public ResponseEntity<Measure> saveMeasure(@RequestBody ReportRequest request) {
		Measure measure = request.createMeasure();
		measureRepository.save(measure);
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
	}

	@RequestMapping(value="/api/measures/testsave", method=RequestMethod.POST)
	public ResponseEntity<String> saveTestMeasure() {
		//Measure measure = request.createMeasure();
		//String result = measureService.save(measure);
		return new ResponseEntity<String>(new String(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/measures/test", method=RequestMethod.GET)
	public ResponseEntity<ReportRequest> test() {
		ReportRequest report = new ReportRequest("123456",32.4f,32.1f,34.55f,86.5f,21f,64f, 5.32f);
		return new ResponseEntity<ReportRequest>(report,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/json/test", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> testJson(@RequestBody ReportRequest request) {
		Measure measure = request.createMeasure();
		JsonMeasuresBuilder builder = new JsonMeasuresBuilder();
		return new ResponseEntity<String>(builder.createJsonFromMeasure(measure).toString(),HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/api/measures/get", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getMeasures(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
////		MeasureDataSet dataSet = new MeasureDataSet().setMeasureList(measureService.findInPeriod(dateFrom, dateTo));
//		MeasureDataSet dataSet = MeasuresRepository.findInPeriod(LocalDate.parse(dateFrom, DateTimeFormatter.BASIC_ISO_DATE), 
//				LocalDate.parse(dateTo, DateTimeFormatter.BASIC_ISO_DATE));
//		JsonMeasuresBuilder jsonBuilder = new JsonMeasuresBuilder();
//		JsonObject response = jsonBuilder.createJsonFromDataSet(dataSet);
		return new ResponseEntity<String>(/*response.toString()*/ new String(),HttpStatus.OK);
	}
}
