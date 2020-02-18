package io.proj.fulldaytrip.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.proj.fulldaytrip.model.Destination;


@Repository
public interface DestinationRepository extends CrudRepository<Destination,String> {


	public List<io.proj.fulldaytrip.model.Destination> findByDistanceLessThan(float i);
	
	public List<io.proj.fulldaytrip.model.Destination> findByDistanceGreaterThan(float i);

	public List<io.proj.fulldaytrip.model.Destination> findByDistanceBetween(float i, float j);

}
