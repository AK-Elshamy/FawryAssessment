package com.service;

import com.model.*;

import java.util.*;

public class QuantumRadar {
    private final List<Rule> rules;
    private final List<Fine> fines = new ArrayList<>();
    private final Map<String, Integer> violationCounts = new LinkedHashMap<>();

    public QuantumRadar(List<Rule> rules) {
        this.rules = rules;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void observe(Vehicle vehicle) {
        List<Violation> violations = new ArrayList<>();

        for (Rule rule : rules) {
            Violation violation = (Violation) rule.check(vehicle);
            if (violation != null) {
                violations.add(violation);
                String ruleName = rule.getClass().getSimpleName();
                violationCounts.merge(ruleName, 1, Integer::sum);
            }
        }

        if (!violations.isEmpty()) {
            Fine fine = new Fine(vehicle.getPlateNumber(), violations);
            fines.add(fine);
            fine.print();
        }
    }

    public Map<String, Integer> getTotalFine() {
        Map<String, Integer> totalsByPlate = new LinkedHashMap<>();
        for (Fine fine : fines) {
            totalsByPlate.merge(fine.getPlateNumber(), fine.getTotalAmount(), Integer::sum);
        }
        return totalsByPlate;
    }

    public Map<String, Integer> getTotalViolatedRule() {
        return new LinkedHashMap<>(violationCounts);
    }
}