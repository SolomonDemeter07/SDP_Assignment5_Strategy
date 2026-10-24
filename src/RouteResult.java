public class RouteResult {
    private final String transportMode;
    private final String origin;
    private final String destination;
    private final double distanceKm;
    private final int durationMinutes;
    private final double estimatedCostKzt;
    private final String routeSummary;

    public RouteResult(String transportMode, String origin, String destination, double distanceKm, int durationMinutes, double estimatedCostKzt, String routeSummary) {
        this.transportMode = transportMode;
        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
        this.durationMinutes = durationMinutes;
        this.estimatedCostKzt = estimatedCostKzt;
        this.routeSummary = routeSummary;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getEstimatedCostKzt() {
        return estimatedCostKzt;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s -> %s (%.1f km) | Time: %d min | Cost: %.0f KZT | Path: %s",
                transportMode, origin, destination, distanceKm, durationMinutes, estimatedCostKzt, routeSummary);
    }
}