package geocode;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderAddressComponent;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderResultType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandeep on 24/1/17.
 */
public class GeoLocationDetails {

  public Map<String, String> geoLocationDetails = new HashMap<>();

  public void extractResponse(GeocodeResponse geocodeResponse) {
    for (GeocoderResult geocoderResult : geocodeResponse.getResults()) {

      for (GeocoderAddressComponent geocoderAddressComponent : geocoderResult.getAddressComponents()) {
        String type = geocoderAddressComponent.getTypes().get(0);
        String long_name = geocoderAddressComponent.getLongName();
        String short_name = geocoderAddressComponent.getShortName();

        for (GeocoderResultType geocoderResultType : GeocoderResultType.values()) {
          if (type.equalsIgnoreCase(geocoderResultType.name())) {
            geoLocationDetails.put(type, long_name);
          }

        }
      }
    }
  }
}
