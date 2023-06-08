package singleton;

import java.util.ArrayList;
import java.util.List;

import dto.AddressDto;

public class Singleton {
	
	private static Singleton sc = null;
	
	public List<AddressDto> addressBook = null;
	
	public Singleton() {
		addressBook = new ArrayList<AddressDto>();
		
	}
	
	public static Singleton getInstance() {
		if(sc == null) {
			sc = new Singleton();
		}
		return sc;
	}

}
