public class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Initial route strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Route strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    public RouteResult navigate(String origin, String destination, double distanceKm) {
        return strategy.buildRoute(origin, destination, distanceKm);
    }
}