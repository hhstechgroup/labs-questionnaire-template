package com.engagepoint.controller.page;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by stanislav.sobolev on 3/11/14.
 */

@Named
@SessionScoped
public class IdController implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
