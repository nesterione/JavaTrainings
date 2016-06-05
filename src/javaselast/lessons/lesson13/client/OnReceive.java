package javaselast.lessons.lesson13.client;

@FunctionalInterface
public interface OnReceive {
    void receive(String message);
}
