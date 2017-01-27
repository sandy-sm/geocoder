package geocode;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;

import java.io.IOException;

/**
 * Created by sandeep on 24/1/17.
 */
public class FetchGeoLocation {

  String latitude;
  String longitude;

  public FetchGeoLocation() {}

  public FetchGeoLocation(String latitude, String longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoLocationDetails fetchGeoLocationDetails() {

    final Geocoder geocoder = new Geocoder();
    GeocoderRequest geocoderRequest =  new GeocoderRequestBuilder().setLocation(new LatLng(latitude, longitude))
        .setLanguage("en").getGeocoderRequest();
    GeocodeResponse geocoderResponse = null;

    try {
      geocoderResponse = geocoder.geocode(geocoderRequest);
    } catch (IOException ioException) {
      throw new RuntimeException("Failed to fetch geo location details due to "+ ioException.getMessage());
    }

    GeoLocationDetails geoLocationDetails = new GeoLocationDetails();
    geoLocationDetails.extractResponse(geocoderResponse);

    return geoLocationDetails;
  }

}
