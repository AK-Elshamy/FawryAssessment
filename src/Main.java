import com.enums.*;
import com.model.*;
import com.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new SpeedViolations(60, 80, 300));
        rules.add(new Seatbelt(100));

        QuantumRadar quantumRadar = new QuantumRadar(rules);

        Vehicle car1 = new Vehicle(94, "ABC1234", false, VehicleType.PRIVATE, new Date());
        quantumRadar.observe(car1);
        System.out.println();

        Vehicle truck1 = new Vehicle(75, "TRK9090", true, VehicleType.TRUCK, new Date());
        quantumRadar.observe(truck1);
        System.out.println();

        Vehicle car2 = new Vehicle(50, "XYZ5678", true, VehicleType.PRIVATE, new Date());
        quantumRadar.observe(car2);

        Vehicle car1Again = new Vehicle(90, "ABC1234", true, VehicleType.PRIVATE, new Date());
        quantumRadar.observe(car1Again);
        System.out.println();

        System.out.println("All fines (plate -> total amount):");
        Map<String, Integer> allFines = quantumRadar.getTotalFine();
        for (Map.Entry<String, Integer> entry : allFines.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " EGP");
        }

        System.out.println();
        System.out.println("Violated rules count:");
        Map<String, Integer> violatedRules = quantumRadar.getTotalViolatedRule();
        for (Map.Entry<String, Integer> entry : violatedRules.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}