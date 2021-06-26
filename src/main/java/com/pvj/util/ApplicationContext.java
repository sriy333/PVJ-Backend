package com.pvj.util;

public class ApplicationContext {

	private String logRef;
	
	private ApplicationContext() {

    }

    private static class ApplicationCtxtInner {
        private ApplicationCtxtInner() {
        }

        private static final ApplicationContext context = new ApplicationContext();
    }

	public String getLogRef() {
		return logRef;
	}

	public void setLogRef(String logRef) {
		this.logRef = logRef;
	}
    
	public static ApplicationContext getInstance() {
        return ApplicationCtxtInner.context;
    }
}
