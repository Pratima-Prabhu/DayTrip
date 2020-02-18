package io.proj.fulldaytrip.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.proj.fulldaytrip.model.Destination;
import io.proj.fulldaytrip.repository.DestinationRepository;

@Service
public class DestinationService {
	
	@Autowired
	private DestinationRepository destinationRepository;

	
	 public List<io.proj.fulldaytrip.model.Destination> getAllDestinations() {
		 List<io.proj.fulldaytrip.model.Destination> placeList=new ArrayList<>();
		 destinationRepository.findAll().forEach(placeList::add); 
		 return placeList; 
	 }
	 
	 

	public Optional<io.proj.fulldaytrip.model.Destination> getDestination(String name) {
		return destinationRepository.findById(name);
	}



	public void addDestination(io.proj.fulldaytrip.model.Destination dest) {
		destinationRepository.save(dest);
		
	}


	public void updateDestination(String name, io.proj.fulldaytrip.model.Destination dest) {
		destinationRepository.save(dest);
		
	}


	public void deleteDestination(String name) {
		destinationRepository.deleteById(name);
		
	}


	public List<io.proj.fulldaytrip.model.Destination> getDestinationWithinFiftyKms(float i) {
		List<io.proj.fulldaytrip.model.Destination> list=new ArrayList<>();
		destinationRepository.findByDistanceLessThan(50).forEach(list::add);
		return list;
	}



	public List<io.proj.fulldaytrip.model.Destination> getDestinationGreaterThanHundredKms(float i) {
		List<io.proj.fulldaytrip.model.Destination> list=new ArrayList<>();
		destinationRepository.findByDistanceGreaterThan(i).forEach(list::add);
		return list;
	}



	public List<io.proj.fulldaytrip.model.Destination> getDestinationBetweenFiftyAndHundredKms(float i, float j) {
		List<io.proj.fulldaytrip.model.Destination> list=new ArrayList<>();
		destinationRepository.findByDistanceBetween(i,j).forEach(list::add);
		return list;
	}



	public List<Destination> getDestinationBetweenStartAndEndKms(float i, float j) {
		List<io.proj.fulldaytrip.model.Destination> list=new ArrayList<>();
		destinationRepository.findByDistanceBetween(i,j).forEach(list::add);
		return list;
	}
	

}
