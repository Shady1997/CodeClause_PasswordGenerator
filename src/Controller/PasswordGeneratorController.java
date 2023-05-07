package Controller;

import Model.PasswordGeneratorModel;
import View.PasswordGeneratorView;

public class PasswordGeneratorController {
    private PasswordGeneratorModel model;
    private PasswordGeneratorView view;

    public PasswordGeneratorController(PasswordGeneratorModel model, PasswordGeneratorView view) {
        this.model = model;
        this.view = view;
    }

    public void generatePassword(int length) {
        String password = model.generatePassword(length);
        view.setPassword(password);
    }

    public void setView(PasswordGeneratorView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        PasswordGeneratorModel model = new PasswordGeneratorModel();
        PasswordGeneratorController controller = new PasswordGeneratorController(model, null);
        PasswordGeneratorView view = new PasswordGeneratorView(controller);
        controller.setView(view);
        view.setVisible(true);
    }
}





