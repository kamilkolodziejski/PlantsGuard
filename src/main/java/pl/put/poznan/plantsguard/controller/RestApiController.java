package pl.put.poznan.plantsguard.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.ReportRequest;
import pl.put.poznan.plantsguard.service.MeasureService;

@RestController
public class RestApiController {
	
	@Autowired
	MeasureService measureService;

	@RequestMapping(value="/api/measures/savejson", method=RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Measure> saveMeasure(@RequestBody ReportRequest request) {
		Measure measure = request.createMeasure();
		measureService.save(measure);
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/measures/{phone}/save", method=RequestMethod.GET)
	public ResponseEntity<String> getMeasure(@PathVariable(name="phone") String phone, @RequestParam(name="HUMI",required=false) Float humi,
																					   @RequestParam(name="TEMP",required=false) Float temp,
																					   @RequestParam(name="LIGHT",required=false) Float light,
																					   @RequestParam(name="SOIL",required=false) Float soil,
																					   @RequestParam(name="SWIMMER",required=false) Float swimmer,
																					   @RequestParam(name="BATT",required=false) Integer batt) {
		Measure measure = new Measure(humi, temp, soil, light);
		measureService.save(measure);
		return new ResponseEntity<String>("Success saved", HttpStatus.OK);
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
