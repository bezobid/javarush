package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by bezobid on 17.08.2016.
 */
public class UsersView implements View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        } else {
            System.out.println("All users:");
        }
        for(User u : modelData.getUsers()) {
            System.out.println("\t" + u);
        }
        System.out.println("===================================================");
    }
    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}

