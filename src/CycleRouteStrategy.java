public class CycleRouteStrategy implements RouteStrategy {
    private static final double CYCLING_SPEED_KMH = 18.0;
    private static final double BIKE_SHARE_UNLOCK_FEE_KZT = 150.0;

    @Override
    public RouteResult buildRoute(String origin, String destination, double distanceKm) {
        validateInput(origin, destination, distanceKm);
        int travelMinutes = (int) Math.round((distanceKm / CYCLING_SPEED_KMH) * 60);
        String summary = "Along dedicated bike lanes and embankment paths";
        return new RouteResult("Cycling", origin, destination, distanceKm, travelMinutes, BIKE_SHARE_UNLOCK_FEE_KZT, summary);
    }

    private void validateInput(String origin, String destination, double distanceKm) {
        if (origin == null || origin.isBlank() || destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Origin and destination must not be empty.");
        }
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero.");
        }
    }
}