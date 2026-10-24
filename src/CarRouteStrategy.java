public class CarRouteStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 45.0;
    private static final double FUEL_COST_PER_KM_KZT = 35.0;
    private static final int TRAFFIC_DELAY_MINUTES = 8;

    @Override
    public RouteResult buildRoute(String origin, String destination, double distanceKm) {
        validateInput(origin, destination, distanceKm);
        int travelMinutes = (int) Math.round((distanceKm / AVERAGE_SPEED_KMH) * 60) + TRAFFIC_DELAY_MINUTES;
        double totalCost = Math.round(distanceKm * FUEL_COST_PER_KM_KZT);
        String summary = "Via main city avenues and highway bypass (includes traffic delay)";
        return new RouteResult("Car", origin, destination, distanceKm, travelMinutes, totalCost, summary);
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