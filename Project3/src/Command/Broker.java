package Command;

//Invoker Object
public class Broker {

    private Command command;

    public Broker(Command aCommand){
        command = aCommand;
    }

    public void callOnTelephone(){
        command.execute();
    }
}
