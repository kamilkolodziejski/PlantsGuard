package pl.put.poznan.plantsguard.controller;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.json.JsonObject;
import javax.swing.text.DateFormatter;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureSet;
import pl.put.poznan.plantsguard.model.MeasureSetWrapper;
import pl.put.poznan.plantsguard.model.MeasureType;
import pl.put.poznan.plantsguard.model.MeasureWrapper;
import pl.put.poznan.plantsguard.service.MeasureService;

@RestController
public class RestApiController {
	
	@Autowired
	MeasureService measureService;

	@RequestMapping(value="/api/measure/{phone}/save", method=RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Measure> saveMeasure(@RequestBody String json, @PathVariable Integer phone) {
		ObjectMapper mapper = new ObjectMapper();
		Measure measure = null;
		try {
			measure = mapper.readValue(json, Measure.class);
		}catch(Exception e) { e.printStackTrace(); };
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
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
	
	
	@RequestMapping(value="/api/measures/get", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getMeasures(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
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

	
	@RequestMapping(value="/api/measureset/get", method=RequestMethod.GET)
	public ResponseEntity<String> saveMeasureSetGET(MeasureSetWrapper wrapper) throws JsonProcessingException {
		MeasureSet measureSet = wrapper.getMeasureSet();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(measureSet).toString();
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@RequestMapping(value="/api/measureset/save", method=RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<MeasureSet> saveMeasureSet(@RequestBody String json) {
		ObjectMapper mapper = new ObjectMapper();
		MeasureSet measureSet = null;
		try {
			measureSet = mapper.readValue(json, MeasureSet.class);
			System.out.println(mapper.writeValueAsString(measureSet).toString());
		}catch(Exception e) { e.printStackTrace(); };
		return new ResponseEntity<MeasureSet>(measureSet, HttpStatus.OK);
		//return new ResponseEntity<Measure>(json, HttpStatus.OK);
	}

	@RequestMapping(value="/api/measureset/testmapper", method=RequestMethod.GET)
	public ResponseEntity<String> getTestMeasureSetMapper() throws JsonProcessingException {
		MeasureSet set = new MeasureSet("510243323");
		set.setMeasureSet(_generateMeasureSet());
		ObjectMapper mapper = new ObjectMapper();
		String resp = mapper.writeValueAsString(set).toString();
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/api/measureset/test", method=RequestMethod.GET)
	public ResponseEntity<MeasureSet> getTestMeasureSet() {
		MeasureSet set = new MeasureSet("510243323");
		set.setMeasureSet(_generateMeasureSet());
		return new ResponseEntity<MeasureSet>(set, HttpStatus.OK);
	}	
	
	private HashMap<MeasureType, List<Double>> _generateMeasureSet() {
		Random rand = new Random();
		HashMap<MeasureType, List<Double>> measureSet = new HashMap<>();
		for(MeasureType type : MeasureType.values()) {
			List<Double> measures = new ArrayList<>();
			for(int j=0; j<=(rand.nextInt()%10+2); j++) {
				measures.add(rand.nextDouble()%0.01);
			}
			measureSet.put(type, measures);
		}
		return measureSet;		
	}
}
