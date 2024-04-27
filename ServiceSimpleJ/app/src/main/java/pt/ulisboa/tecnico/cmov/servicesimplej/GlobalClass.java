package pt.ulisboa.tecnico.cmov.servicesimplej;

import android.app.Application;

public class GlobalClass extends Application {
    private int counter = 0;
    public int getCounter () { return counter;}

    public void incrementCounter () {this.counter += 1;}
}