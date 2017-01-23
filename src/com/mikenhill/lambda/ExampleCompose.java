package com.mikenhill.lambda;

import java.util.function.Function;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
 
public class ExampleCompose {
 
    public static void main(String[] args) {
        ExampleCompose ex = new ExampleCompose();
        Function<Double , Double> mySin = (Double d) -> ex.sin2(d);
        Function<Double , Double> myLog = d -> Math.log(d);
        Function<Double , Double> myExp = d -> ex.exp2(d);
        ExampleCompose myExampleCompose = new ExampleCompose();
        System.out.println(myExampleCompose.calculate(mySin.compose(myLog), 0.8));
        // prints log:sin:-0.22
        System.out.println(myExampleCompose.calculate(mySin.andThen(myLog), 0.8));
        // prints sin:log:-0.33
        System.out.println(myExampleCompose.calculate(mySin.compose(myLog).andThen(myExp), 0.8));
        //log:sin:exp:0.80
        System.out.println(myExampleCompose.calculate(mySin.compose(myLog).compose(myExp), 0.8));
        //exp:log:sin:0.71
        System.out.println(myExampleCompose.calculate(mySin.andThen(myLog).compose(myExp), 0.8));
        //exp:sin:log:-0.23
        System.out.println(myExampleCompose.calculate(mySin.andThen(myLog).andThen(myExp), 0.8));
        //sin:log:exp:0.71
        
        mySin.apply(23D);
        
        Function<String , Integer> mySin2 = 
        (first) -> {
        	String second = "";
         	if (first.length() < second.length()) return -1; 
        	else if (first.length() > second.length()) return 1; 
        	else return 0; 
        };

        Button button1 = new Button("Accept", new ImageView(imageAccept));
        button1.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                label.setText("Accepted");
            }
        });
        
 
    }
 
    public Double calculate(Function<Double , Double> operator, Double d) {
        return operator.apply(d);
    }
 
    public Double sin2(Double d) {
        System.out.print("sin:" + Math.sin(d));
        return Math.sin(d);
    }
 
    public Double checkAllowedValue(Double d) {
        System.out.print("log:");
        return Math.log(d);
    }
 
    public Double exp2(Double d) {
        System.out.print("exp:");
        return Math.exp(d);
    }
 
}
        