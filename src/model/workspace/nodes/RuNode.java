package model.workspace.nodes;

import observer.Publisher;
import observer.Subscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements Publisher, Serializable {

    public RuNode parent;
    public String name;

    List<Subscriber> subscribers;

    public RuNode(){

    }

    public RuNode(String name, RuNode parent){
        this.name = name;
        this.parent = parent;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof RuNode){
            RuNode node = (RuNode) obj;
            return this.getName().equals(node.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return "RuNode{" +
                "parent=" + parent +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

        if(subscriber == null) {
            return;
        }
        if(subscribers == null){
            subscribers = new ArrayList<>();
        }
        if(subscribers.contains(subscriber)){
            return;
        }
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if(subscriber == null || subscribers == null || !subscribers.contains(subscriber)){
            return;
        }
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification) {

        if(notification == null || subscribers == null || subscribers.isEmpty()){
            return;
        }
        /*
        for(Subscriber s : subscribers){
            s.update(notification);
        }
        */
        for(int i = 0; i < subscribers.size(); i++){
            subscribers.get(i).update(notification);
        }

    }


}
