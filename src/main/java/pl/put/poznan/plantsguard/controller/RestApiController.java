package pl.put.poznan.plantsguard.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureDataSet;
import pl.put.poznan.plantsguard.model.ReportRequest;
import pl.put.poznan.plantsguard.service.MeasureService;
import pl.put.poznan.plantsguard.service.MeasuresRepository;
import pl.put.poznan.plantsguard.utils.JsonMeasuresBuilder;

@RestController
public class RestApiController {
	

//	@Autowired
//	MeasuresRepository measureRepository;
	@Autowired
	MeasureService measureService;

	@RequestMapping(value="/api/measures/savejson", method=RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Measure> saveMeasure(@RequestBody ReportRequest request) {
		Measure measure = request.createMeasure();
		measureService.save(measure);
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
	}
	@RequestMapping(value="/api/measures/savejson/test", method=RequestMethod.GET)
	public ResponseEntity<ReportRequest> testSaveMeasure() {
		ReportRequest report = new ReportRequest("123456",32.4f,32.1f,34.55f,86.5f,21f,64f, 5.32f);
		return new ResponseEntity<ReportRequest>(report, HttpStatus.OK);
	}

	@RequestMapping(value="/api/measures/{phone}/getsave", method=RequestMethod.GET)
	public ResponseEntity<Measure> getMeasure(@RequestBody ReportRequest request, @PathVariable(name="phone") String phone ) {
		Measure measure = request.createMeasure();
		String result = measureService.save(measure);
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
	}
//	@RequestMapping(value="/api/measures/getsave/test", method=RequestMethod.GET)
//	public ResponseEntity<HashMap<String,Float>> testGetMeasure() {
//		//Measure measure = request.createMeasure();
//		//String result = measureService.save(measure);
//		HashMap<String,Float> map = new HashMap<>();
//		map.put("temp", 15.6f);
//		map.put("humi", 53.6f);
//		return new ResponseEntity<HashMap<String,Float>>(map, HttpStatus.OK);
//	}

	@RequestMapping(value="/api/measures/get", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getMeasures(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
//		MeasureDataSet dataSet = new MeasureDataSet().setMeasureList(measureService.findInPeriod(dateFrom, dateTo));
//		MeasureDataSet dataSet = MeasuresRepository.getFromPeriod(LocalDate.parse(dateFrom, DateTimeFormatter.BASIC_ISO_DATE), 
//				LocalDate.parse(dateTo, DateTimeFormatter.BASIC_ISO_DATE));
//		JsonMeasuresBuilder jsonBuilder = new JsonMeasuresBuilder();
//		JsonObject response = jsonBuilder.createJsonFromDataSet(dataSet);
//		return new ResponseEntity<String>(/*response.toString()*/ new String(),HttpStatus.OK);
		return new ResponseEntity<String>(measureService.getFromPeriod(dateFrom, dateTo).toString(),HttpStatus.OK);
	}
}
