/**
 *  Program 2
 *  This class is used to create GeoLocation objects that store a latitude and longitude. 
 * It also has a method to calculate the distance between two GeoLocation objects.
 *  CS160-01
 *  5/30/2024
 *  @author  Jacob Archer
  */

    public class GeoLocation {
        public static final double EARTH_RADIUS_MILES = 3963.1676;
        private double latitude;
        private double longitude;

        public String getId() {
            return "Program 2, Jacob Archer";
        }
        
        public GeoLocation() {
            this.latitude = 0;
            this.longitude = 0;
        }

        public GeoLocation(double lat, double lon) {
            this.latitude = lat;
            this.longitude = lon;
        }

        public void setLatitude(double lat) {
            this.latitude = lat;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public void setLongitude(double lon) {
            this.longitude = lon;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public double distanceFrom(GeoLocation o) {
            double lat1 = Math.toRadians(this.latitude);
            double lon1 = Math.toRadians(this.longitude);
            double lat2 = Math.toRadians(o.getLatitude());
            double lon2 = Math.toRadians(o.getLongitude());

            double arcLength = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
            return arcLength * EARTH_RADIUS_MILES;
        }
    }
