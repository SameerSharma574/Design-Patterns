package net.media.training.designpattern.decoratorTutorial;

public class SlackDecorator extends BaseNotifierDecorator {

    public SlackDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        String phoneNbr = databaseService.getSlackHandleUsername(getUsername());
        System.out.println("Sending " + msg + " by WhatsApp on " + phoneNbr);
    }

}

