package pl.put.poznan.plantsguard.controller;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.json.JsonObject;
import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureJson;
import pl.put.poznan.plantsguard.model.MeasureWrapper;
import pl.put.poznan.plantsguard.model.ReportRequest;
import pl.put.poznan.plantsguard.service.MeasureService;

@RestController
public class RestApiController {
	
	@Autowired
	MeasureService measureService;

	@RequestMapping(value="/api/measure/save", method=RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Measure> saveMeasure(@RequestBody String json) {
		ObjectMapper mapper = new ObjectMapper();
		Measure measure = null;
		try {
			measure = mapper.readValue(json, Measure.class);
		}catch(Exception e) { e.printStackTrace(); };
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
		//return new ResponseEntity<Measure>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/measures/{phone}/save", method=RequestMethod.GET)
	public ResponseEntity<String> saveMeasureGET(MeasureWrapper wrapper) {
		Measure measure = wrapper.measurable();
		return new ResponseEntity<String>("Success saved", HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/measures", method=RequestMethod.GET)
	public ResponseEntity<Measure> getTestMeasure() {
		Measure measure = new Measure(65.2f,36.6f,71.04f,null);
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
		try {
			LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.BASIC_ISO_DATE);
			LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.BASIC_ISO_DATE);
			String response = measureService.getFromPeriod(from, to);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}catch(Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return new ResponseEntity<String>(sw.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
