Design underground system
  import java.util.*;

class UndergroundSystem {

    // id -> [stationName, checkInTime]
    private Map<Integer, CheckInData> checkIns;

    // "start#end" -> [totalTime, numberOfTrips]
    private Map<String, RouteData> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkIns.get(id);

        String startStation = data.station;
        int checkInTime = data.time;

        int travelTime = t - checkInTime;

        String route = startStation + "#" + stationName;

        if (!routes.containsKey(route)) {
            routes.put(route, new RouteData(0, 0));
        }

        RouteData routeData = routes.get(route);

        routeData.totalTime += travelTime;
        routeData.count++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        RouteData data = routes.get(route);

        return (double) data.totalTime / data.count;
    }

    // Stores check-in information
    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores route information
    class RouteData {
        int totalTime;
        int count;

        RouteData(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}
Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
