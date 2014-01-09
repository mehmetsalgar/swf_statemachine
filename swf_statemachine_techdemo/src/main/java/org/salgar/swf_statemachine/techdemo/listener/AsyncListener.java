package org.salgar.swf_statemachine.techdemo.listener;

public interface AsyncListener {
    public void doResult(String correlationId, Object result);
    public void setValid(boolean valid);
}
