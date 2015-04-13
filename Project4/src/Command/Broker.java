package Command;

//Invoker Object
public class Broker {

    Command command;

    public Broker(Command aCommand){
        command = aCommand;
    }

    public void callOnTelephone(){
        command.execute();
    }
}
