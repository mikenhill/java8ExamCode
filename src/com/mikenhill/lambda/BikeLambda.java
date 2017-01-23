package com.mikenhill.lambda;

import static java.util.stream.IntStream.generate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ac.simons.biking2.api.ChartsController;
import ac.simons.biking2.highcharts.HighchartsNgConfig;
import ac.simons.biking2.highcharts.Marker;
import ac.simons.biking2.highcharts.Options;
import ac.simons.biking2.highcharts.Series;
import ac.simons.biking2.highcharts.Series.Builder;
import ac.simons.biking2.misc.Sink;
import ac.simons.biking2.persistence.entities.Bike;

public class BikeLambda {

   
    

    public static void main (String args []) {
    	final LocalDate january1st = LocalDate.now().withMonth(1).withDayOfMonth(1);
    	final List<Bike> bikes = new ArrayList<Bike>();
    	final Map<LocalDate, Integer> summarizedPeriods = Bike.summarizePeriods(bikes, entry -> !entry.getKey().isBefore(january1st));
    	
    	
    	final Map<String, Object> userData = new HashMap<>();
    	userData.put("worstPeriod", Bike.getWorstPeriod(summarizedPeriods));
    	userData.put("bestPeriod", Bike.getBestPeriod(summarizedPeriods));
    	userData.put("average", summarizedPeriods.entrySet().stream().mapToInt(entry -> entry.getValue()).average().orElseGet(() -> 0.0));
    	userData.put("preferredBike", bikes.stream().max(new Bike.BikeByMilageInYearComparator(january1st.getYear())).orElse(null));
    	userData.put("currentYear", january1st.getYear());
    	
    	
    	final HighchartsNgConfig.Builder builder = HighchartsNgConfig.define();
    	builder.withUserData(userData);
    	
    	// Add the bike charts as columns
    	final int[] sums = bikes.stream().sequential().map(bike -> {
    	    final int[] milagesInYear = bike.getMilagesInYear(january1st.getYear());
    	    builder.series()
    		    .withName(bike.getName())
    		    .withColor("#" + bike.getColor())
    		    .withType("column")
    		    .withData(milagesInYear)
    		    .build();	
    	    return milagesInYear;
    	}).reduce(ChartsController::addArrays).orElse(generate(() -> 0).limit(12).toArray());
    	
    	userData.put("currentYearSum", Arrays.stream(sums).sum());
    }
    
    
    
}
