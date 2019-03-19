package ru.sbt.mipt.oop;

public class Alarm implements Actionable, Printable {


    private AlarmState state;
    private final int id;
    private int password;


    public Alarm(int password, int id) {
        this.password = password;
        this.state = new DeactivatedState();
        this.id = id;
    }

    public AlarmState getState(){
        return state;
    }

    public int getId() {
        return id;
    }

    public void activate(int code) {
        state = state.activate(code, password);

    }

    public void deactivate(int code){
        state = state.deactivate(code, password);

    }

    public void danger() {
        state = state.danger();
    }

    public boolean activate(){
        return state.activated();
    }

    @Override
    public void printToSystemOut() {
        System.out.println("Alarm id: "+ getId());
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}