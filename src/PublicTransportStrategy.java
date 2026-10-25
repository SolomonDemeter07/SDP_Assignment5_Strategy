public class PublicTransportStrategy implements RouteStrategy {
    private static final double BUS_SPEED_KMH = 25.0;
    private static final int STOP_WAIT_MINUTES = 6;
    private static final double BUS_FARE_KZT = 110.0;

    @Override
    public RouteResult buildRoute(String origin, String destination, double distanceKm) {
        validateInput(origin, destination, distanceKm);
        int travelMinutes = (int) Math.round((distanceKm / BUS_SPEED_KMH) * 60) + STOP_WAIT_MINUTES;
        String summary = "Via dedicated bus lanes with one transfer";
        return new RouteResult("Public Transit", origin, destination, distanceKm, travelMinutes, BUS_FARE_KZT, summary);
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