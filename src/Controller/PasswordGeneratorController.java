package Controller;

import Model.PasswordGeneratorModel;
import View.PasswordGeneratorView;
/*
 * Copyright (c) 2023 Shady Ahmed.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Shady Ahmed. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with Shady Ahmed.
 *
 * Created on May 7, 2023 at 10:30 AM
 */
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





