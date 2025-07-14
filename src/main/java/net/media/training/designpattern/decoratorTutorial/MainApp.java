package net.media.training.designpattern.decoratorTutorial;

public class MainApp {

    public static void main(String[] args) {

        INotifier notifier = new Notifier("Sameer");
        boolean isFacebookEnabled = true;
        boolean isWhatsappEnabled = true;

        if (isFacebookEnabled) {
            notifier = new FacebookDecorator(notifier);
        }
        if (isWhatsappEnabled) {
            notifier = new SlackDecorator(notifier);
        }

//        notifier = new FacebookDecorator(new SlackDecorator(new Notifier("Sameer")));

        notifier.send("Hi Sameer");
    }

}
