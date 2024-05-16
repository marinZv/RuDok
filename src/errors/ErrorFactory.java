package errors;

import observer.Publisher;
import observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class ErrorFactory implements Publisher {

    private static ErrorFactory instance = null;

    private List<Subscriber> subscribers;

    private ErrorFactory(){
    }

    public static ErrorFactory getInstance() {
        if(instance == null){
            instance = new ErrorFactory();
        }

        return instance;
    }

    public void generateError(String string){
        notifySubscribers(new MyError(string));
    }

    /*
        public RuError createErrorMessage(RuErrorType type){
            if(type == RuErrorType.ws_delete){
                return new DeleteWorkspaceError();
            }
            else if(type == RuErrorType.ns_add){
                return new AddError();
            }
            else if(type == RuErrorType.ns_delete){
                return new RemoveError();
            }
            else if(type == RuErrorType.sl_add){
                return new SlideAddError();
            }else if(type == RuErrorType.empty_autor){
                return new EmptyAuthorError();
            }else if(type == RuErrorType.ns_presentation){
                return new EditAuthorButtonError();
            }
            return null;
        }
    */
    @Override
    public void addSubscriber(Subscriber subscriber) {
        if(subscriber == null){
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

        for(int i = 0; i < subscribers.size(); i++){
            subscribers.get(i).update(notification);
        }

    }
}
