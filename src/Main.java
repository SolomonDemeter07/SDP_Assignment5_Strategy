public class Main {
    public static void main(String[] args) {
        String origin = "Astana IT University";
        String destination = "Khan Shatyr";
        double distanceKm = 7.5;

        System.out.println("=== Route Planning Demonstration (Runtime Strategy Switching) ===");

        Navigator navigator = new Navigator(new CarRouteStrategy());
        System.out.println(navigator.navigate(origin, destination, distanceKm));

        navigator.setStrategy(new WalkRouteStrategy());
        System.out.println(navigator.navigate(origin, destination, distanceKm));

        navigator.setStrategy(new CycleRouteStrategy());
        System.out.println(navigator.navigate(origin, destination, distanceKm));

        navigator.setStrategy(new PublicTransportStrategy());
        System.out.println(navigator.navigate(origin, destination, distanceKm));
    }
}