import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class F23768989 extends Application {
	boolean IBP = false;
	public static void main(String[] args) {
    	launch(args);
    }
    public void start(Stage pS) {
    	BorderPane root = new BorderPane();
    	TextField text = new TextField();
    	VBox vl = new VBox();
    	VBox vr = new VBox();
    	HBox h = new HBox(text);
    	BL handleL = new BL(text);
    	Button equal = new Button("=");
    	equal.setOnAction((e -> { double Num2 = Double.parseDouble(text.getText());
    	switch(handleL.getOp()) {
    	case "+" : 
    		text.setText(Double.toString(handleL.getNum1() + Num2));
    	    break;
    	case "-" : 
    		text.setText(Double.toString(handleL.getNum1() - Num2));
    	    break;
    	case "/" : 
    		if(Num2 == 0) {
    			text.setText("Error");
    			break;
    		}
    		text.setText(Double.toString(handleL.getNum1() / Num2));
    		break;
    	case "*" : 
    		text.setText(Double.toString(handleL.getNum1() * Num2));
    	    break;
    	default: 
    		text.setText(Double.toString(Num2));
    	}
    	handleL.setNUM1(Num2);
    	handleL.setOp("");
    	IBP = true;
    	}));
    	vr.getChildren().add(equal);
    	String[] asdm = {"+","-","/", "*"};
    	ArrayList<Button> Lbuttons = new ArrayList<>();
    	for(int i = 0; i < 4; i++) {
        	Lbuttons.add(new Button(asdm[i]));
            Lbuttons.get(i).setOnAction(handleL);
       }
       vl.getChildren().addAll(Lbuttons);
       GridPane grid = new GridPane(); 
       String[] CEMR = {"C", "E", "M", "R"};
       ArrayList<Button> TopCenter = new ArrayList<>();
       for(int i = 0; i < 4; i++) {
    	   grid.add(new Button(CEMR[i]), i, 0);
    	   TopCenter.add((Button)grid.getChildren().get(i));
    	   switch(i) {
    	   case 0: 
    		   TopCenter.get(i).setOnAction(e ->{handleL.clean();});
    	       break;
    	   case 1: 
    		   TopCenter.get(i).setOnAction(e ->{System.exit(0);});
    	       break;
    	   case 2:
    		   TopCenter.get(i).setOnAction( e -> {handleL.setMem(Double.parseDouble(text.getText()));});
    		   break;
    	   case 3:
    		   TopCenter.get(i).setOnAction( e -> {text.setText(Double.toString(handleL.getMem()));});
    		   break;
    	   }
       }
       ArrayList<Button> center = new ArrayList<>();
       int t = 0;
       for(int i = 1; i < 4;i++) {
           for(int j = 0; j < 3; j++) {
        		grid.add(new Button(Integer.toString(t + 1)), j, i);
                t++;
        	}
        }
       grid.add(new Button("0"), 1 , 4);
       for(int i = 4; i < 14; i++) {
    	   center.add((Button)grid.getChildren().get(i));
           center.get(i -4).setOnAction(e ->{
           	Button pressed = (Button)e.getTarget();
           	if(IBP) text.clear();
           	IBP = false;
            text.setText(text.getText() + pressed.getText());});
       }
        text.setEditable(false);
    	root.setTop(h);
    	root.setCenter(grid);
    	root.setLeft(vl);
    	root.setRight(vr);
    	Scene scene = new Scene(root);
		pS.setScene(scene);
		pS.show();    	
    }  
    class BL implements EventHandler<ActionEvent>{
    	private TextField text;
    	private double Num1 = 0;
        private String op;
        private double mem;
        public void clean(){
        	text.clear();
        	Num1 = 0;
        	op = "";
        }
        public void setNUM1(double d) {Num1= (int)d;}
        public void setOp(String d) {op = d;}
        public double getMem() {return mem;}
        public void setMem(double m) {mem = m;}
        public double getNum1() {return Num1;}
        public String getOp() {return op;}
        public BL(TextField t) {text = t;}
        public void handle(ActionEvent e) {
            Button pressed = (Button)e.getTarget();
    		Num1 = Double.parseDouble(text.getText());
            op = pressed.getText();
            IBP = true;
        }
        
    }
}