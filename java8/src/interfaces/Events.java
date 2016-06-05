package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Events {

    public static void main(String[] args) {

        VirtualButton button = new VirtualButton();

//        button.addEventListener(new Handler() {
//            @Override
//            public void action() {
//                System.out.println("click");
//            }
//        });

        button.addEventListener(
                ()->System.out.println("click lambda")
        );

        button.click();

        ArrayList<String> list = new ArrayList<>();
        list.iterator();
    }

}

class VirtualButton {

    private Handler handler;

    public void addEventListener(Handler handler) {
        this.handler = handler;
    }

    public void click() {
        if(handler!=null) {
            handler.action();
        }
    }
}

@FunctionalInterface
interface Handler {
    void action();
    default void qwer() {}
}
