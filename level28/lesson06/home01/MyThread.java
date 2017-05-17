package com.javarush.test.level28.lesson06.home01;

/**
 * Created by bezobid on 03.06.2016.
 */
public class MyThread extends Thread{

    static int priority;

    public int priority(){
        priority++;
        if (priority > 10){
            priority = 1;
        }
        return priority;
    }

    public MyThread() {
        this.setPriority(priority());
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priority());

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        int groupMaxPriority = group.getMaxPriority();
        int newPriority = priority();
        if (newPriority > groupMaxPriority){
            this.setPriority(groupMaxPriority);
        }
        else{
            this.setPriority(newPriority);
        }
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(priority());

    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        int groupMaxPriority = group.getMaxPriority();
        int newPriority = priority();
        if (newPriority > groupMaxPriority){
            this.setPriority(groupMaxPriority);
        }
        else{
            this.setPriority(newPriority);
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priority());

    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        int groupMaxPriority = group.getMaxPriority();
        int newPriority = priority();
        if (newPriority > groupMaxPriority){
            this.setPriority(groupMaxPriority);
        }
        else{
            this.setPriority(newPriority);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        int groupMaxPriority = group.getMaxPriority();
        int newPriority = priority();
        if (newPriority > groupMaxPriority){
            this.setPriority(groupMaxPriority);
        }
        else{
            this.setPriority(newPriority);
        }
    }
}
