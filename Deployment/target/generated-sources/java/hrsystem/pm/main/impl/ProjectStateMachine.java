package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Project;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


public class ProjectStateMachine extends StateMachine<Project,Pm> {

    public static final int Closing = 1;
    public static final int Execution = 2;
    public static final int Initiation = 0;
    public static final int Monitoring_and_Control__ = 3;
    public static final int Planning = 4;


    private Project self;

    public ProjectStateMachine(Project self, Pm context) {
        this(self, context, Initiation);
    }

    public ProjectStateMachine(Project self, Pm context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void Closing_entry_action() throws XtumlException {
    }

    private void Execution_entry_action() throws XtumlException {
    }

    private void Initiation_entry_action() throws XtumlException {
    }

    private void Monitoring_and_Control___entry_action() throws XtumlException {
    }

    private void Planning_entry_action() throws XtumlException {
    }





    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { 
            },
            { 
            },
            { 
            },
            { 
            },
            { 
            }
        };
    }

    @Override
    public Project self() {
        return self;
    }

    @Override
    public String getClassName() {
        return "Project";
    }

}
