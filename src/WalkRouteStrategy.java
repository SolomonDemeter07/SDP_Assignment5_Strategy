public class WalkRouteStrategy implements RouteStrategy {
    private static final double WALKING_SPEED_KMH = 5.0;
    private static final double SHORTCUT_FACTOR = 0.85;

    @Override
    public RouteResult buildRoute(String origin, String destination, double distanceKm) {
        validateInput(origin, destination, distanceKm);
        double effectiveDistance = distanceKm * SHORTCUT_FACTOR;
        int travelMinutes = (int) Math.round((effectiveDistance / WALKING_SPEED_KMH) * 60);
        String summary = "Through pedestrian zones, parks, and courtyard shortcuts";
        return new RouteResult("Walking", origin, destination, effectiveDistance, travelMinutes, 0.0, summary);
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