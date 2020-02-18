package io.proj.fulldaytrip.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import io.proj.fulldaytrip.model.Destination;
import io.proj.fulldaytrip.service.DestinationService;

@Controller
public class DestinationController {
	
	@Autowired
	private DestinationService destinationService;
	
//	@RequestMapping("/dummy/int/{test}")
//	@ResponseBody
//	public String getDummyValuess(@PathVariable("test") int test) throws URISyntaxException {
//		System.out.println("Inside getDummyValues int");
//		RestTemplate restTemplate = new RestTemplate();
//		final String baseUrl = "http://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22";
//	    URI uri = new URI(baseUrl);
//	     
//	    String result=restTemplate.getForObject(uri, String.class);
//	 System.out.println("output --> "+result);
//		return result;
//	}
//	@RequestMapping("/dummy/{test}")
//	@ResponseBody
//	public String getDummyValuess2(@PathVariable("test") String test) throws URISyntaxException {
//		System.out.println("Inside getDummyValues string");
//		RestTemplate restTemplate = new RestTemplate();
//		final String baseUrl = "http://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22";
//	    URI uri = new URI(baseUrl);
//	     
//	    String result=restTemplate.getForObject(uri, String.class);
//	 System.out.println("output --> "+result);
//		return result;
//	}
	
		
	@RequestMapping("/places")
	public String getAllDestinations(ModelMap model) {
		model.put("dest",destinationService.getAllDestinations());
		return "list-places";
	}
	
	
	
	@RequestMapping("/places/{name}")
	public String getDestination(ModelMap model,@PathVariable String name) {
		if(destinationService.getDestination(name).isPresent()) {
			
			model.put("dest", destinationService.getDestination(name));
		}
		
		
		return "page";
		
	}
	
	@RequestMapping(value="/places/add" ,method=RequestMethod.GET)
	public String showAddDestinationPage(ModelMap model) {
		model.addAttribute("dest", new Destination());
		return "places";
	}
	
	@RequestMapping(value="/places/add", method=RequestMethod.POST)
	public void addDestination(@Valid Destination dest) {
		destinationService.addDestination(dest);
	}
	
	
	
	
	
	@RequestMapping(value="/places/update/{name}",method=RequestMethod.PUT)
	public void updateDestination(@RequestBody Destination dest,@PathVariable String name) {
		destinationService.updateDestination(name,dest);
	}
	
	@RequestMapping(value="/places/delete/{name}",method=RequestMethod.DELETE)
	public void deleteDestination(@PathVariable String name) {
		destinationService.deleteDestination(name);
	}
	
	@RequestMapping("/places/distance/{count}")
	public List<Destination> getDestinationWithinFiftyKms(){
		return destinationService.getDestinationWithinFiftyKms(50);
		
	}
	
	@RequestMapping("/places/50To100")
	public List<Destination> getDestinationBetweenFiftyAndHundredKms(){
		return destinationService.getDestinationBetweenFiftyAndHundredKms(50,100);
		
	}
	
	@RequestMapping("/places/{start}/to/{end}")
	public List<Destination> getDestinationBetweenStartAndEndKms(){
		return destinationService.getDestinationBetweenStartAndEndKms(50,100);
		
	}
	
	@RequestMapping("/places/100")
	public List<Destination> getDestinationGreaterThanHundredKms(){
		return destinationService.getDestinationGreaterThanHundredKms(100);
		
	}
	
	
	
	

}
