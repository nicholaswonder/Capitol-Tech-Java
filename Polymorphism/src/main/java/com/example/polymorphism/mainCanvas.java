package com.example.polymorphism;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.io.IOException;
import java.util.Scanner;

public class mainCanvas extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scanner scan = new Scanner(System.in);
        int option = 1;
        stage.setTitle("Output");
        Group root = new Group();
        Canvas canvas = new Canvas(300,250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        System.out.println("Choose Shape to Draw");
        System.out.println("1. Circle");
        System.out.println("2. Line");
        System.out.println("3. Rectangle");
        System.out.println("4. Oval");
        System.out.println("5. Exit");
        option = scan.nextInt();

        switch (option)
        {
            case 1:
                gc.fillOval(10,60,30,30);
                break;
            case 2:
                gc.strokeLine(0,0,300,250);
                break;
            case 3:
                gc.fillRect(50,50, 100, 200);
                break;
            case 4:
                gc.fillOval(10,60,30,60);
                break;
            case 5:
                System.out.println("Cancelling program");
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }
        if (option > 0 && option < 5)
        {
            root.getChildren().add(canvas);
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}