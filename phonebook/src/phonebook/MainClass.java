package phonebook;

import phonebook.controller.PhoneController;

public class MainClass {
    public static void main(String[] args) {
        PhoneController pc = new PhoneController();
        pc.run();
    }
}
