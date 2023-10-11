package Resources;

import Pojo.AddPlace;
import Pojo.Location;

import java.util.ArrayList;

public class ApiData {
	AddPlace addPlace = new AddPlace();

	public AddPlace addPlacePayload(String address, String language, String name){
		addPlace.setAccuracy(50);
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setName(name);
		ArrayList<String> typeList = new ArrayList<>();
		typeList.add("shoe park");
		typeList.add("shop");
		addPlace.setTypes(typeList);
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLon(33.427362);
		addPlace.setLocation(loc);

		return addPlace;
	}
}
