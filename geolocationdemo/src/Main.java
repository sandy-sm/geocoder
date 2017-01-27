import geocode.FetchGeoLocation;
import geocode.GeoLocationDetails;

import java.util.Map;

/**
 * Created by sandeep on 24/1/17.
 */
public class Main {

  public static void main(String[] args) {

    if (args.length < 2) {
      System.out.println("Usage: java Main <latitude> <longitude>");
      return;
    }

    GeoLocationDetails geoLocationDetails = new FetchGeoLocation(args[0], args[1]).fetchGeoLocationDetails();

    for(Map.Entry entry: geoLocationDetails.geoLocationDetails.entrySet()) {
      System.out.println(entry.getKey()+": "+ entry.getValue());

    }
  }
}
